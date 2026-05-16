# Permissions

ServerIntel keeps permissions simple for the beta release.

| Permission | Default | Description |
| --- | --- | --- |
| `serverintel.admin` | op | Full access to all ServerIntel commands. |
| `serverintel.staff` | op | Access to profile, timeline, watch, alerts, help, version, and evidence placeholder. |
| `serverintel.reload` | op | Access to `/si reload`. |
| `serverintel.alerts` | op | Allows a player to receive staff alerts. |
| `serverintel.bypass` | false | Excludes a player from risk scoring unless config allows scoring bypassed players. |

## Recommended Setup

- Give trusted moderators `serverintel.staff` and `serverintel.alerts`.
- Give administrators `serverintel.admin` and `serverintel.reload`.
- Give builders, owners, or test accounts `serverintel.bypass` only if you do not want them included in risk scoring.

## Bypass Behavior

By default, players with `serverintel.bypass` still create timeline entries, but positive risk points are not applied.

Set `risk.score-bypassed-players: true` if you want bypassed players to be scored anyway.
