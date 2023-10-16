package dev.bogdanjovanovic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Test2 extends TestFixtures {

  @Test
  @Tag("trace-viewer")
  void shouldReturnInnerHTML() {
    page.setContent("<div>hello</div>");
    assertEquals("hello", page.innerHTML("css=div"));
  }

  @Test
  void shouldClickButton() {
    Page popup = page.waitForPopup(() -> {
      page.evaluate("window.open('about:blank');");
    });
    assertEquals("about:blank", popup.url());
  }

}
