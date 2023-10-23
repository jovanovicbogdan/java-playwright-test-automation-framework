package dev.bogdanjovanovic.poms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TodoMVCPage {
  private final Page page;
  private final Locator newTodoInput;

  public TodoMVCPage(final Page page) {
    this.page = page;
    this.newTodoInput = page.locator(".new-todo");
  }

  public void navigateToTodoMVCPage() {
    page.navigate("https://demo.playwright.dev/todomvc/");
  }

  public void fillTodoInput(final String content) {
    newTodoInput.fill(content);
  }

  public void pressEnter() {
    newTodoInput.press("Enter");
  }

}
