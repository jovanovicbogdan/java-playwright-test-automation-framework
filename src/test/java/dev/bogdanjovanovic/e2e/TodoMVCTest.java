package dev.bogdanjovanovic.e2e;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.TodoMVCPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TodoMVCTest extends TestFixtures {

  @Test
  @Tags({@Tag("todomvc"), @Tag("smoke")})
  void shouldAddNewTodo() {
    final TodoMVCPage page = pomContainer.getTodoMVCPage();
    page.navigateToTodoMVCPage();
    page.fillTodoInput("new todo");
    page.pressEnter();
  }

}
