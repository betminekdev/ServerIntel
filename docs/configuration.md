# Configuration

SmartAdmin creates `plugins/SmartAdmin/config.yml` on first startup.

After editing the config, run `/sa reload`. Restart the server after changing storage paths.

## Messages

`messages.prefix` controls the chat prefix used by plugin messages.

## Risk

```yaml
risk:
  max-score: 100
  decay-enabled: true
  decay-amount: 2
  decay-interval-minutes: 30
  score-bypassed-players: false
```

- `max-score`: upper limit for player risk.
- `decay-enabled`: whether risk lowers over time.
- `decay-amount`: how much risk is removed each interval.
- `decay-interval-minutes`: how often decay runs.
- `score-bypassed-players`: whether `smartadmin.bypass` players can still gain risk.

## Mining

`mining.valuable-ores` maps material names to risk points.

The burst detector adds extra risk when a player mines enough configured ore in a short window. This is a signal for review, not proof of xray.

## Signals

The beta includes lightweight TNT, lava, chat spam, and suspicious link signals.

These are intentionally simple and should be tuned for your community.

## Alerts

```yaml
alerts:
  enabled: true
  threshold: 60
  high-risk-threshold: 80
  cooldown-seconds: 30
```

- `threshold`: when staff alerts can begin.
- `high-risk-threshold`: stronger visual urgency in alert output.
- `cooldown-seconds`: prevents repeated alerts for the same player.

## Storage

```yaml
storage:
  type: sqlite
  database-file: "plugins/SmartAdmin/smartadmin.db"
  keep-data-days: 14
```

Only SQLite is supported in v0.1. Timeline cleanup uses `keep-data-days`.

## Discord

Discord settings are present for future releases. Webhook sending is not implemented in v0.1.
