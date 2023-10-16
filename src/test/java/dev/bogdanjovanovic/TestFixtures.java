package dev.bogdanjovanovic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TestFixtures {
  Playwright playwright;
  Browser browser;
  BrowserContext context;
  Page page;

  @BeforeAll
  void launchBrowser() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
  }

  @BeforeEach
  void createContextAndPage() {
    context = browser.newContext();
    context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
    page = context.newPage();
  }

  @AfterEach
  void closeContext() {
    context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    context.close();
  }

}
