package dev.bogdanjovanovic.ui.poms;

import com.microsoft.playwright.Page;

public class PomContainer {
  private final TodoMVCPage todoMVCPage;
  private final WebFormPage webFormPage;
  private final UpworkLoginPage upworkLoginPage;

  public PomContainer(final Page page) {
    this.todoMVCPage = new TodoMVCPage(page);
    this.webFormPage = new WebFormPage(page);
    this.upworkLoginPage = new UpworkLoginPage(page);
  }

  public TodoMVCPage getTodoMVCPage() {
    return todoMVCPage;
  }

  public WebFormPage getWebFormPage() {
    return webFormPage;
  }

  public UpworkLoginPage getUpworkLoginPage() {
    return upworkLoginPage;
  }
}
