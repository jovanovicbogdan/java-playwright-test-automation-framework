package dev.bogdanjovanovic.poms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class UpworkLoginPage {
  private final Page page;
  private final Locator loginLink;
  private final Locator loginUsername;
  private final Locator loginPasswordContinue;
  private final Locator loginPassword;
  private final Locator loginControlContinue;

  public UpworkLoginPage(final Page page) {
    this.page = page;
    loginLink = page.locator("a.login-link");
    loginUsername = page.locator("#login_username");
    loginPasswordContinue = page.locator("#login_password_continue");
    loginPassword = page.locator("#login_password");
    loginControlContinue = page.locator("#login_control_continue");
  }

  public void navigateToUpworkHomepage() {
    page.navigate("https://stage.upwork.com/");
  }

  public void clickOnLoginLink() {
    loginLink.click();
  }

  public void fillUsername(final String username) {
    loginUsername.fill(username);
  }

  public void clickOnPasswordContinue() {
    loginPasswordContinue.click();
  }

  public void fillPassword(final String password) {
    loginPassword.fill(password);
  }

  public void clickOnLoginControlContinue() {
    loginControlContinue.click();
  }

  public void login(final String username, final String password) {
    clickOnLoginLink();
    fillUsername(username);
    clickOnPasswordContinue();
    fillPassword(password);
    clickOnLoginControlContinue();
  }

}
