# Commands

ServerIntel uses `/serverintel` as the main command. The preferred short command is `/si`.

Aliases: `/si`, `/smartadmin`, `/sa`

## `/si help`

Shows the available ServerIntel commands.

## `/si profile <player>`

Shows a player's current risk score, risk level, last seen time, and recent important signals.

Use this when staff need a quick overview before deciding whether to watch a player manually.

## `/si timeline <player>`

Shows recent timeline events for a player.

Timeline entries can include joins, valuable ore mining, ore burst signals, block placement signals, chat signals, and risk level changes.

## `/si watch <player>`

Toggles live watch mode for the command sender.

When enabled, the staff member receives important live events from the watched player. Watch mode is in-memory and resets after restart.

## `/si alerts`

Toggles personal staff alerts.

This affects whether the sender receives ServerIntel alerts when players cross configured thresholds.

## `/si reload`

Reloads `config.yml` without restarting the server.

Storage settings are not reconnected during reload in v0.1. Restart the server after changing the database path.

## `/si version`

Shows the installed ServerIntel version.

## `/si evidence <player>`

Prepared placeholder for future investigation reports.

In v0.1, use `/si profile <player>` and `/si timeline <player>` for investigation data.
