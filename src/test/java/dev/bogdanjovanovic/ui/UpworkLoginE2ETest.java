package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.UpworkLoginPage;
import org.junit.jupiter.api.Test;

public class UpworkLoginE2ETest extends TestFixtures {

  @Test
  void testUpworkLogin() {
    final UpworkLoginPage page = pomContainer.getUpworkLoginPage();
    page.navigateToUpworkHomepage();
    page.login("test", "test");
  }

}
