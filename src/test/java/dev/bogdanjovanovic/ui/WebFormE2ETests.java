package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.fixtures.UITestFixtures;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WebFormE2ETests extends UITestFixtures {

  @Test
  @Tag("smoke")
  void testWebFormTextInput() {
    webFormPage.navigateToWebFormPage();
    webFormPage.fillTextInput("Hello World!");
  }

}
