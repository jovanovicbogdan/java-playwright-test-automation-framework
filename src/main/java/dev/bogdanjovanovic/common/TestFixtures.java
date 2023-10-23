package dev.bogdanjovanovic.common;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import dev.bogdanjovanovic.poms.SwagLabsPage;
import dev.bogdanjovanovic.poms.TodoMVCPage;
import dev.bogdanjovanovic.poms.UpworkLoginPage;
import dev.bogdanjovanovic.poms.WebFormPage;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

@TestInstance(Lifecycle.PER_CLASS)
public class TestFixtures implements TestWatcher {

  private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
  private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
  private static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
  private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

  protected SwagLabsPage swagLabsPage;
  protected TodoMVCPage todoMVCPage;
  protected UpworkLoginPage upworkLoginPage;
  protected WebFormPage webFormPage;

  public static Playwright getPlaywright() {
    return playwrightThreadLocal.get();
  }

  public static Browser getBrowser() {
    return browserThreadLocal.get();
  }

  public static BrowserContext getBrowserContext() {
    return browserContextThreadLocal.get();
  }

  public static Page getPage() {
    return pageThreadLocal.get();
  }

  @BeforeAll
  void launchBrowser() {
    playwrightThreadLocal.set(Playwright.create());
    browserThreadLocal.set(
        getBrowserType(getPlaywright()).launch(new LaunchOptions().setHeadless(false)));
  }

  @BeforeEach
  void createContextAndPage() {
    browserContextThreadLocal.set(getBrowser().newContext(
        new NewContextOptions().setViewportSize(1280, 1024)
    ));
    pageThreadLocal.set(getBrowserContext().newPage());

    swagLabsPage = new SwagLabsPage(getPage());
    todoMVCPage = new TodoMVCPage(getPage());
    upworkLoginPage = new UpworkLoginPage(getPage());
    webFormPage = new WebFormPage(getPage());
  }

  @Override
  public void testFailed(final ExtensionContext context, final Throwable cause) {
    final String path =
        System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
    takeScreenshot(path);
  }

  @AfterAll
  void closeContext() {
    getBrowserContext().close();
  }

  private BrowserType getBrowserType(final Playwright playwright) {
    final String browserName = System.getProperty("browser", "chromium").trim();

    return switch (browserName) {
      case "chromium" -> playwright.chromium();
      case "firefox" -> playwright.firefox();
      case "webkit" -> playwright.webkit();
      default -> throw new IllegalArgumentException("Unknown browser: " + browserName);
    };
  }

  private void takeScreenshot(final String path) {
    getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
  }

}
