package dev.bogdanjovanovic.poms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import dev.bogdanjovanovic.contants.AppURLs;

public class TodoMVCPage {
  private final Page page;
  private final Locator newTodoInput;

  public TodoMVCPage(final Page page) {
    this.page = page;
    this.newTodoInput = page.locator(".new-todo");
  }

  public void navigateToTodoMVCPage() {
    page.navigate(AppURLs.TODO_MVC_HOME_PAGE);
  }

  public void fillTodoInput(final String content) {
    newTodoInput.fill(content);
  }

  public void pressEnter() {
    newTodoInput.press("Enter");
  }

}
