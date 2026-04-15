# SubTracker

An Android app for tracking subscriptions — see what you're paying for, when the next payment is due, and how much you spend in total.

## Tech Stack

- **Kotlin**
- **Jetpack Compose** + **Material3**
- **Navigation 3**
- **MVVM** with `ViewModel` + `UiState`
- **Room** (local database)
- **Coroutines** + **Flow**

## Features

- View all subscriptions with status filter (All / Active / Paused / Cancelled)
- Subscription detail screen with payment history
- Add and edit subscriptions with full form validation
- Category picker with emoji icons and color coding
- Billing period selector (monthly, yearly, etc.)
- Reminder days before next payment
- Notes per subscription
- Local persistence with Room

## Architecture

Feature-based package structure:

```
app/
├── feature/
│   ├── subscriptions/   # List screen
│   ├── detail/          # Detail screen
│   └── edit/            # Add / Edit screen
├── data/
│   ├── local/           # Room database, DAOs, entities
│   ├── mapper/          # Entity ↔ domain model mappers
│   └── repository/
├── model/               # Domain models (Subscription, Payment, etc.)
└── fake/                # Mock data for Compose previews
```

## Screenshots

_Coming soon_

## Running Locally

1. Clone the repo
2. Open in Android Studio
3. Run on emulator or physical device (API 26+)

> The app uses a local Room database seeded with mock data on first launch.

## Related

- [SubTracker Backend](https://github.com/adzinka/SubTrackerBackend) — Spring Boot REST API (in progress)
