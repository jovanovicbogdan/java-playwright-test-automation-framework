package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.TodoMVCPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TodoMVCE2ETest extends TestFixtures {

  @Test
  @Tag("smoke")
  void shouldAddNewTodo() {
    final TodoMVCPage page = pomContainer.getTodoMVCPage();
    page.navigateToTodoMVCPage();
    page.fillTodoInput("new todo");
    page.pressEnter();
  }

}
