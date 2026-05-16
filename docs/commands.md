# Commands

SmartAdmin uses `/smartadmin` as the main command. The preferred short command is `/sa`.

Aliases: `/sa`, `/si`

## `/sa help`

Shows the available SmartAdmin commands.

## `/sa profile <player>`

Shows a player's current risk score, risk level, last seen time, and recent important signals.

Use this when staff need a quick overview before deciding whether to watch a player manually.

## `/sa timeline <player>`

Shows recent timeline events for a player.

Timeline entries can include joins, valuable ore mining, ore burst signals, block placement signals, chat signals, and risk level changes.

## `/sa watch <player>`

Toggles live watch mode for the command sender.

When enabled, the staff member receives important live events from the watched player. Watch mode is in-memory and resets after restart.

## `/sa alerts`

Toggles personal staff alerts.

This affects whether the sender receives SmartAdmin alerts when players cross configured thresholds.

## `/sa reload`

Reloads `config.yml` without restarting the server.

Storage settings are not reconnected during reload in v0.1. Restart the server after changing the database path.

## `/sa version`

Shows the installed SmartAdmin version.

## `/sa evidence <player>`

Prepared placeholder for future investigation reports.

In v0.1, use `/sa profile <player>` and `/sa timeline <player>` for investigation data.
