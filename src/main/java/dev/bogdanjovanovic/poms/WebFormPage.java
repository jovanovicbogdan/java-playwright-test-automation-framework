package dev.bogdanjovanovic.poms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import dev.bogdanjovanovic.contants.AppURLs;

public class WebFormPage {
  private final Page page;
  private final Locator textInput;

  public WebFormPage(final Page page) {
    this.page = page;
    this.textInput = page.locator("#my-text-id");
  }

  public void navigateToWebFormPage() {
    page.navigate(AppURLs.WEB_FORM_PAGE);
  }

  public void fillTextInput(final String text) {
    textInput.fill(text);
  }

}
