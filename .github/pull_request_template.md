## What and why

<!-- One or two sentences. What changes, and what problem it solves. -->

## How to verify

<!-- Steps on device/emulator, or the tests that cover it. Screenshots for UI changes. -->

## Checklist

- [ ] `./gradlew testDebugUnitTest lint` is green
- [ ] One logical change; unrelated fixes are not smuggled in
- [ ] No framework types leaked into `model/`
- [ ] Derived state computed in the ViewModel, not in composables
- [ ] Time taken from the injected `Clock`, not `LocalDate.now()`
- [ ] `CLAUDE.md` updated if a convention or a known-debt item changed
