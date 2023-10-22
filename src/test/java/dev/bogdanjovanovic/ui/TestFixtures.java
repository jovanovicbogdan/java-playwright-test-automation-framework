package dev.bogdanjovanovic.ui;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import dev.bogdanjovanovic.ui.poms.PomContainer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TestFixtures {

  Browser browser;
  BrowserContext context;
  PomContainer pomContainer;

  @BeforeAll
  void launchBrowser() {
    final Playwright playwright = Playwright.create();
    browser = getBrowserType(playwright).launch(new LaunchOptions().setHeadless(false));
  }

  @BeforeEach
  void createContextAndPage() {
    context = browser.newContext();
//    context.tracing().start(new Tracing.StartOptions()
//        .setScreenshots(true)
//        .setSnapshots(true)
//        .setSources(true));
    final Page page = context.newPage();
    pomContainer = new PomContainer(page);
  }

  @AfterEach
  void closeContext() {
//    context.tracing().stop(new Tracing.StopOptions()
//        .setPath(Paths.get("trace.zip")));
    context.close();
  }

  private BrowserType getBrowserType(final Playwright playwright) {
    final String browserName = System.getProperty("browser", "chromium");

    return switch (browserName) {
      case "chromium" -> playwright.chromium();
      case "firefox" -> playwright.firefox();
      case "webkit" -> playwright.webkit();
      default -> throw new IllegalArgumentException("Unknown browser: " + browserName);
    };
  }

}
