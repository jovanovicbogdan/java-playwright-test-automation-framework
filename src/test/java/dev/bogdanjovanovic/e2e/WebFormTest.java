package dev.bogdanjovanovic.e2e;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.WebFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class WebFormTest extends TestFixtures {

  @Test
  @Tags({@Tag("webform"), @Tag("smoke")})
  void testWebFormTextInput() {
    final WebFormPage page = pomContainer.getWebFormPage();
    page.navigateToWebFormPage();
    page.fillTextInput("Hello World!");
  }

}
