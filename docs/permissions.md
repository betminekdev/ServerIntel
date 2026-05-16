# Permissions

SmartAdmin keeps permissions simple for the beta release.

| Permission | Default | Description |
| --- | --- | --- |
| `smartadmin.admin` | op | Full access to all SmartAdmin commands. |
| `smartadmin.staff` | op | Access to profile, timeline, watch, alerts, help, version, and evidence placeholder. |
| `smartadmin.reload` | op | Access to `/sa reload`. |
| `smartadmin.alerts` | op | Allows a player to receive staff alerts. |
| `smartadmin.bypass` | false | Excludes a player from risk scoring unless config allows scoring bypassed players. |

## Recommended Setup

- Give trusted moderators `smartadmin.staff` and `smartadmin.alerts`.
- Give administrators `smartadmin.admin` and `smartadmin.reload`.
- Give builders, owners, or test accounts `smartadmin.bypass` only if you do not want them included in risk scoring.

## Bypass Behavior

By default, players with `smartadmin.bypass` still create timeline entries, but positive risk points are not applied.

Set `risk.score-bypassed-players: true` if you want bypassed players to be scored anyway.
