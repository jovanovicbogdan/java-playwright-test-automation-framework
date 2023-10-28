package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.fixtures.UITestFixtures;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TodoMVCE2ETests extends UITestFixtures {

  @Test
  @Tag("smoke")
  void shouldAddNewTodo() {
    todoMVCPage.navigateToTodoMVCPage();
    todoMVCPage.fillTodoInput("new todo");
    todoMVCPage.pressEnter();
  }

}
