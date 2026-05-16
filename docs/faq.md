# FAQ

## Is ServerIntel an anti-cheat?

No. ServerIntel is a smart staff assistant. It provides investigation signals and timelines for staff review.

## Does ServerIntel auto-ban players?

No. ServerIntel does not auto-ban in v0.1 and does not recommend punishing without review.

## Can it detect xray perfectly?

No. The mining detector is a configurable heuristic. It can highlight suspicious mining patterns, but it cannot prove xray alone.

## Does the player need a client mod?

No. ServerIntel uses server-side data only.

## Which server software is supported?

ServerIntel is built for Paper/Spigot-style Java servers and compiles against Paper API `1.21.11-R0.1-SNAPSHOT`.

## What database does it use?

SQLite. The default file is `plugins/ServerIntel/serverintel.db`.

## Which command should staff use?

Use `/si`. The full command is `/serverintel`, and legacy-friendly aliases `/smartadmin` and `/sa` are also registered.

## Is v0.1.0-beta production ready?

It is a public beta. Test it on a staging server first, tune thresholds, and review staff workflows before using it on a live server.
