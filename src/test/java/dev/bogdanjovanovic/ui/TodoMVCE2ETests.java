package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.TodoMVCPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TodoMVCE2ETests extends TestFixtures {

  @Test
  @Tag("smoke")
  void shouldAddNewTodo() {
    todoMVCPage.navigateToTodoMVCPage();
    todoMVCPage.fillTodoInput("new todo");
    todoMVCPage.pressEnter();
  }

}
