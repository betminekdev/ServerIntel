# Release Checklist

Use this checklist before publishing a SmartAdmin beta build.

## Build

- Run `.\gradlew.bat clean build --console plain` on Windows.
- Confirm `build/libs/SmartAdmin-0.1.0-beta.jar` exists.
- Confirm GitHub Actions passes on `main`.

## Manual Server Test

- Start a Paper/Spigot test server with the JAR installed.
- Confirm `plugins/SmartAdmin/config.yml` is created.
- Confirm `plugins/SmartAdmin/smartadmin.db` is created.
- Join with a player.
- Run `/smartadmin help`, `/sa help`, and `/si help`.
- Mine valuable ores and verify `/sa profile <player>` and `/sa timeline <player>`.
- Toggle `/sa alerts`.
- Toggle `/sa watch <player>`.
- Test `/sa reload`.

## Public Release

- Create GitHub release `v0.1.0-beta`.
- Upload the built JAR.
- Paste `RELEASE_NOTES.md`.
- Add Modrinth, Hangar, and SpigotMC links when available.
- Use the matching platform description from `publishing/`.

## Messaging Review

- Do not claim perfect cheat detection.
- Do not call SmartAdmin an auto-ban anti-cheat.
- Keep the beta warning visible.
- Present all suspicious behavior as signals for manual review.
