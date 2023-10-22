package dev.bogdanjovanovic.ui.poms;

import com.microsoft.playwright.Page;

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
