package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.WebFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WebFormE2ETest extends TestFixtures {

  @Test
  @Tag("smoke")
  void testWebFormTextInput() {
    final WebFormPage page = pomContainer.getWebFormPage();
    page.navigateToWebFormPage();
    page.fillTextInput("Hello World!");
  }

}
