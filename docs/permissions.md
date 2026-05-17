# Permissions

SmartAdmin keeps permissions simple for the beta release.

| Permission | Default | Description |
| --- | --- | --- |
| `smartadmin.admin` | `op` | Full access to all SmartAdmin commands. |
| `smartadmin.staff` | `op` | Access to profile, timeline, watch, alerts, help, version, and evidence placeholder. |
| `smartadmin.reload` | `op` | Access to `/sa reload`. |
| `smartadmin.alerts` | `op` | Allows a player to receive staff alerts. |
| `smartadmin.bypass` | `false` | Excludes a player from risk scoring unless config allows scoring bypassed players. |

## Recommended Staff Setup

Give trusted moderators:

```text
smartadmin.staff
smartadmin.alerts
```

Give administrators:

```text
smartadmin.admin
smartadmin.reload
```

Give trusted builders, owners, or test accounts `smartadmin.bypass` only when you do not want them included in risk scoring.

## Bypass Behavior

By default, players with `smartadmin.bypass` can still create timeline entries, but positive risk points are not applied.

Set this option if bypassed players should still be scored:

```yaml
risk:
  score-bypassed-players: true
```
