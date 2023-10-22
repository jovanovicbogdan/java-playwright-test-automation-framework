package dev.bogdanjovanovic.common;

import com.microsoft.playwright.Page;
import dev.bogdanjovanovic.poms.TodoMVCPage;
import dev.bogdanjovanovic.poms.WebFormPage;

public class PomContainer {
  private final TodoMVCPage todoMVCPage;
  private final WebFormPage webFormPage;

  public PomContainer(final Page page) {
    this.todoMVCPage = new TodoMVCPage(page);
    this.webFormPage = new WebFormPage(page);
  }

  public TodoMVCPage getTodoMVCPage() {
    return todoMVCPage;
  }

  public WebFormPage getWebFormPage() {
    return webFormPage;
  }

}
