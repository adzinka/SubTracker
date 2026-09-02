# SubTracker — Android

Subscription tracker: what you pay for, when the next payment is due, how much it adds up to.
Companion backend: <https://github.com/adzinka/SubTrackerBackend> (Kotlin/Spring today, Java/Spring rewrite in progress).

---

## Working agreement

The owner of this repo is deliberately learning Android, Java and Spring, and is learning to work with coding
agents. Speed is **not** the goal — understanding is. Two modes; if the request does not make the mode obvious,
ask which one applies before touching anything.

**Learning mode** (default for anything architectural or new to the owner)
- Do not write production code.
- Explain the options and the trade-offs, sketch the skeleton (signatures, TODOs), write *failing* tests.
- Review what the owner wrote: correctness first, then idiom, then style.
- Ask the owner questions back ("why is this `Flow` and not `StateFlow`?") instead of silently fixing.

**Delivery mode** (only when explicitly requested)
- Write the code. Reserved for things the owner already understands and that carry no learning value:
  CI, Gradle config, mappers, docs, tests written by an existing example, mechanical refactors.

**Language:** explanations, reviews and discussion in **Russian**. Code, comments, identifiers, commit messages,
branch names, PR titles/descriptions and everything committed to the repo in **English**.

---

## Workflow

- One task = one branch = one PR. Never commit directly to `main`.
- Branch names: `feat/<slug>`, `fix/<slug>`, `refactor/<slug>`, `chore/<slug>`, `test/<slug>`, `build/<slug>`.
- Commits: [Conventional Commits](https://www.conventionalcommits.org/), imperative mood, one logical change per
  commit. Scope is optional and lowercase: `feat(detail): add delete confirmation dialog`.
- State the plan before writing code; wait for confirmation.
- A PR is not done until `./gradlew testDebugUnitTest lint` is green.
- Do not bump dependency versions as a side effect of an unrelated task.

---

## Stack

| Area | Choice |
|---|---|
| Language | Kotlin 2.1, JVM toolchain 21 |
| UI | Jetpack Compose + Material 3 |
| Navigation | **Navigation 3** (`androidx.navigation3`) — alpha, expect breaking changes |
| DI | Hilt |
| Persistence | Room (KSP) |
| Async | Coroutines + Flow |
| Build | AGP 9.1, Gradle 9.3.1, version catalog in `gradle/libs.versions.toml` |
| minSdk / targetSdk | 26 / 36 |

---

## Architecture

Feature-based packages, MVVM, unidirectional data flow: `UI -> ViewModel (UiState) -> Repository -> Room`.

```
app/src/main/java/com/adzinka/subtracker/
├── feature/
│   ├── subscriptions/   list screen: Screen, ViewModel, UiState, Mappers, components/
│   ├── detail/          detail screen + payment history
│   ├── edit/            add / edit form
│   ├── stats/           STUB
│   └── settings/        STUB
├── data/
│   ├── local/           Room database, DAOs, entities, TypeConverters
│   ├── mapper/          entity <-> domain
│   └── repository/      SubscriptionRepository (interface) + OfflineSubscriptionRepository
├── model/               domain models — no Android or Room types here
├── core/ui/             theme, spacing, shared components, formatters
├── di/                  Hilt modules
└── fake/                mock data
```

Rules:
- `model/` stays free of framework types. Room lives behind `data/local/entity` + mappers.
- Composables receive state and lambdas; they never touch a repository or a ViewModel field directly.
- Filtering, sorting and derived values belong in the ViewModel, not in the composable.
- Time comes from the injected `java.time.Clock`, never `LocalDate.now()` — the tests depend on this.

---

## Commands

```bash
./gradlew testDebugUnitTest      # unit tests — must pass before every PR
./gradlew assembleDebug          # debug APK
./gradlew lint                   # Android Lint; report in app/build/reports/lint-results-debug.html
./gradlew installDebug           # install on a running emulator/device
```

---

## Known debt — context, not a to-do list

Do not "fix" these as a side effect of another task. Each one gets its own PR.

- **Money is `Int`.** `SubscriptionPricing` divides integers and loses precision (there is a `TODO` in the file).
  Target: `Long` in minor units (haléře/cents) with a single formatting helper. This must be agreed with the
  backend before the API contract is frozen.
- **Dates are `LocalDate` here but `String` on the backend.** The wire format will be ISO-8601.
- **`fallbackToDestructiveMigration(dropAllTables = true)`** in `AppModule` wipes user data on any schema change.
  Real Room migrations are required before anything ships.
- **`getSubscriptionById(): Flow<Subscription>`** is non-null; after a delete the detail screen has no valid state.
- **Detail screen actions are stubs** — `ActionButtons` has `onClick = { /* TODO */ }` and `DetailViewModel` has
  two matching `// TODO`s. Edit and delete do not work from the detail screen.
- **`reminderDays` is stored but does nothing.** No WorkManager, no notification channel, no POST_NOTIFICATIONS.
- **Compose versions are fought over**: the BOM is `2024.09.00` while `androidx.compose.ui` is pinned separately
  to `1.10.4`. The BOM should own the Compose versions.
- **`compileOptions` targets Java 11** while the toolchain is 21.
- **No tests.** `ExampleUnitTest` / `ExampleInstrumentedTest` are generated stubs.
- **Mock data ships in `main`** (`fake/`); seeding belongs behind a debug-only path.
- **No INTERNET permission** in the manifest — needed once the network layer lands.
- `stats/` and `settings/` render "will be soon".

## Out of scope until the backend integration phase

Networking, sync, auth, multi-device. The app is offline-first and Room is the source of truth for the UI;
that does not change when the API arrives.
