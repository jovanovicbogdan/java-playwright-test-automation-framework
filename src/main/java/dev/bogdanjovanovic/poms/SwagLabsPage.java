package dev.bogdanjovanovic.poms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import dev.bogdanjovanovic.contants.AppURLs;

public class SwagLabsPage {
  private final Page page;
  private final Locator usernameInput;
  private final Locator passwordInput;
  private final Locator loginButton;

  public SwagLabsPage(final Page page) {
    this.page = page;
    this.usernameInput = page.locator("#user-name");
    this.passwordInput = page.locator("#password");
    this.loginButton = page.locator("#login-button");
  }

  public void navigateToSwagLabsHomepage() {
    page.navigate(AppURLs.SWAG_LABS_HOME_PAGE);
  }

  public void login(final String username, final String password) {
    usernameInput.fill(username);
    passwordInput.fill(password);
    loginButton.click();
  }

}
