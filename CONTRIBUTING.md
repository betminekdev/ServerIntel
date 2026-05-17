# Contributing

Thanks for helping improve SmartAdmin.

## Build

Windows:

```powershell
.\gradlew.bat clean build --console plain
```

Linux/macOS:

```bash
./gradlew clean build --console plain
```

## Code Style

- Keep classes focused.
- Prefer existing project patterns.
- Keep changes small and reviewable.
- Avoid unrelated formatting churn.
- Use clear names for moderation and investigation concepts.

## Project Positioning

SmartAdmin is a staff assistant, not a classic anti-cheat.

Do not add or document claims such as:

- guaranteed cheat detection
- perfect xray detection
- client-side detection
- automatic punishment accuracy

Use wording such as:

- suspicious behavior
- risk signals
- timeline evidence
- staff review
- manual investigation

## Before Opening a PR

- Run the build.
- Test relevant commands on a Paper/Spigot server when behavior changes.
- Keep plugin logic, docs, and publishing text consistent.
- Explain any config changes clearly.
