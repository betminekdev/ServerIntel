# Release Checklist

Use this checklist before publishing a ServerIntel beta build.

## Build

- Run `.\gradlew.bat clean build --console plain` on Windows.
- Confirm `build/libs/ServerIntel-0.1.0-beta.jar` exists.
- Confirm GitHub Actions passes on `main`.

## Manual Server Test

- Start a Paper/Spigot test server with the JAR installed.
- Confirm `plugins/ServerIntel/config.yml` is created.
- Confirm `plugins/ServerIntel/serverintel.db` is created.
- Join with a player.
- Run `/serverintel help`, `/si help`, `/smartadmin help`, and `/sa help`.
- Mine valuable ores and verify `/si profile <player>` and `/si timeline <player>`.
- Toggle `/si alerts`.
- Toggle `/si watch <player>`.
- Test `/si reload`.

## Public Release

- Create GitHub release `v0.1.0-beta`.
- Upload the built JAR.
- Paste `RELEASE_NOTES.md`.
- Add Modrinth, Hangar, and SpigotMC links when available.
- Use the matching platform description from `publishing/`.

## Messaging Review

- Do not claim perfect cheat detection.
- Do not call ServerIntel an auto-ban anti-cheat.
- Keep the beta warning visible.
- Present all suspicious behavior as signals for manual review.
