package dev.bogdanjovanovic.ui.e2e;

import dev.bogdanjovanovic.ui.common.TestFixtures;
import dev.bogdanjovanovic.ui.poms.UpworkLoginPage;
import org.junit.jupiter.api.Test;

public class UpworkLoginE2ETest extends TestFixtures {

  @Test
  void testUpworkLogin() {
    final UpworkLoginPage page = pomContainer.getUpworkLoginPage();
    page.navigateToUpworkHomepage();
    page.login("test", "test");
  }

}
