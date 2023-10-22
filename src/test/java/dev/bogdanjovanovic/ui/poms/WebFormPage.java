package dev.bogdanjovanovic.ui.poms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WebFormPage {
  private final Page page;
  private final Locator textInput;

  public WebFormPage(final Page page) {
    this.page = page;
    this.textInput = page.locator("#my-text-id");
  }

  public void navigateToWebFormPage() {
    page.navigate("https://www.selenium.dev/selenium/web/web-form.html");
  }

  public void fillTextInput(final String text) {
    textInput.fill(text);
  }

}
