# Playwright Practice

- Thread safe Test Automation Framework for UI testing using Java Playwright with JUnit5 parallel testing capabilities.

## GitHub Actions

- Workflow configured to run tests on push or pull request on branch master.

## How to run

```bash
./gradlew clean test -DincludeTags=TAG_1,TAG_2 -Dbrowser=BROWSER_NAME -Dheadless=false
```

### JUnit5 Configuration

- The following configuration is currenty set in the `src/test/resources/junit-platform.properties` file:

```
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=same_thread
junit.jupiter.execution.parallel.mode.classes.default=concurrent
junit.jupiter.execution.parallel.config.strategy=dynamic
junit.jupiter.execution.parallel.config.dynamic.factor=0.5
```

- The above configuration will run the tests in parallel using the same thread with max number of thread equal to 1/2 of the number of CPU cores, and will run the tests in the same class concurrently.
- Feel free to change the configuration to your needs.

#### TODO

- [x] ~~Attach screenshots to allure report~~
- [x] ~~Add API tests support~~
- [x] ~~Publish allure report to GitHub pages~~
- [ ] Add OpenAI API integration - TBD
