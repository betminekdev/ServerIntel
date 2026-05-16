# Detection Philosophy

ServerIntel is a staff assistant, not an anti-cheat.

It collects server-side signals, creates timelines, calculates risk scores, and alerts staff when behavior deserves manual review.

## What ServerIntel Does

- Tracks important player actions.
- Adds risk points for configured signals.
- Stores timeline events for investigation.
- Alerts staff when risk passes configured thresholds.
- Helps staff decide what to review next.

## What ServerIntel Does Not Do

- It does not guarantee cheat detection.
- It does not detect client-side cheat mods.
- It does not inspect screenshots or player devices.
- It does not auto-ban players.
- It does not prove xray by itself.

## Mining Signals

The MVP mining detector watches valuable ore mining:

- diamond ore
- deepslate diamond ore
- emerald ore
- deepslate emerald ore
- ancient debris
- gold ore
- deepslate gold ore
- iron ore
- deepslate iron ore

It can add risk for valuable ores, high-value ore bursts, ancient debris bursts, and unusual new-player mining activity.

These signals are useful starting points for staff review. They should be combined with timeline context, server rules, player history, and manual observation.

## Risk Levels

| Score | Level | Meaning |
| --- | --- | --- |
| 0-25 | SAFE | No major current concern. |
| 26-50 | WATCH | Worth keeping an eye on. |
| 51-75 | SUSPICIOUS | Review timeline and watch manually. |
| 76-100 | HIGH_RISK | Strong review priority, still not proof. |
