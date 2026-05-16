package cz.betminekdev.smartadmin.risk;

import cz.betminekdev.smartadmin.alerts.AlertService;
import cz.betminekdev.smartadmin.config.SmartAdminConfig;
import cz.betminekdev.smartadmin.storage.PlayerProfile;
import cz.betminekdev.smartadmin.storage.StorageService;
import cz.betminekdev.smartadmin.timeline.TimelineEvent;
import cz.betminekdev.smartadmin.timeline.TimelineEventType;
import cz.betminekdev.smartadmin.timeline.TimelineService;
import cz.betminekdev.smartadmin.watch.WatchService;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Supplier;

public final class RiskService {
    private final JavaPlugin plugin;
    private final StorageService storage;
    private final TimelineService timelineService;
    private final AlertService alertService;
    private final WatchService watchService;
    private final Supplier<SmartAdminConfig> config;

    public RiskService(JavaPlugin plugin, StorageService storage, TimelineService timelineService, AlertService alertService,
                       WatchService watchService, Supplier<SmartAdminConfig> config) {
        this.plugin = plugin;
        this.storage = storage;
        this.timelineService = timelineService;
        this.alertService = alertService;
        this.watchService = watchService;
        this.config = config;
    }

    public void addSignal(Player player, TimelineEventType eventType, Location location, int riskChange, String reason, String details) {
        SmartAdminConfig current = config.get();
        long now = System.currentTimeMillis();
        try {
            storage.upsertPlayer(player.getUniqueId(), player.getName(), now);
            Optional<PlayerProfile> optionalProfile = storage.findProfile(player.getUniqueId());
            int oldScore = optionalProfile.map(PlayerProfile::riskScore).orElse(0);
            boolean bypassed = player.hasPermission("smartadmin.bypass") && !current.scoreBypassedPlayers();
            int appliedRisk = bypassed ? 0 : Math.max(0, riskChange);
            int newScore = clampScore(oldScore + appliedRisk, current.maxScore());

            if (newScore != oldScore) {
                storage.updateRisk(player.getUniqueId(), newScore, now);
            }

            String fullDetails = details == null ? "" : details;
            if (bypassed) {
                fullDetails = fullDetails.isEmpty() ? "bypassed=true" : fullDetails + "; bypassed=true";
            }
            TimelineEvent event = timelineService.record(player, eventType, location, appliedRisk, reason, fullDetails);
            watchService.notify(event);

            if (newScore != oldScore && RiskLevel.fromScore(oldScore) != RiskLevel.fromScore(newScore)) {
                TimelineEvent riskEvent = timelineService.record(
                        player,
                        TimelineEventType.RISK_LEVEL_CHANGED,
                        location,
                        0,
                        "Risk changed to " + newScore + " - Status: " + RiskLevel.fromScore(newScore).name(),
                        "oldScore=" + oldScore + "; newScore=" + newScore
                );
                watchService.notify(riskEvent);
            }

            if (appliedRisk > 0) {
                alertService.handleRiskIncrease(player, oldScore, newScore, reason);
            }
        } catch (SQLException exception) {
            plugin.getLogger().warning("Could not store risk signal for " + player.getName() + ": " + exception.getMessage());
        }
    }

    public void decayScores() {
        SmartAdminConfig current = config.get();
        if (!current.decayEnabled() || current.decayAmount() <= 0) {
            return;
        }
        try {
            int changed = storage.decayRiskScores(current.decayAmount());
            if (changed > 0) {
                plugin.getLogger().fine("Decayed risk scores for " + changed + " player profiles.");
            }
        } catch (SQLException exception) {
            plugin.getLogger().warning("Could not decay risk scores: " + exception.getMessage());
        }
    }

    public static int clampScore(int score, int maxScore) {
        return Math.max(0, Math.min(Math.max(1, maxScore), score));
    }
}
