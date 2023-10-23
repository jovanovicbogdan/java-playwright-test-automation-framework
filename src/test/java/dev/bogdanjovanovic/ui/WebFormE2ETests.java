package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.WebFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WebFormE2ETests extends TestFixtures {

  @Test
  @Tag("smoke")
  void testWebFormTextInput() {
    webFormPage.navigateToWebFormPage();
    webFormPage.fillTextInput("Hello World!");
  }

}
