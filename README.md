# Playwright Practice

- Thread safe Test Automation Framework for UI testing using Java Playwright with JUnit5 parallel testing capabilities.

## GitHub Actions

- Workflow configured to run tests on push or pull request on branch master.

## How to run

```bash
./gradlew clean test -DincludeTags=TAG_1,TAG_2 -Dbrowser=BROWSER_NAME -Dheadless=false
```

## TODO

- [x] ~~Attach screenshots to allure report~~
- [ ] Add API tests support
- [ ] Add OpenAI API integration
