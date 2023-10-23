package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.UpworkLoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestFixtures.class)
public class UpworkLoginE2ETests extends TestFixtures {

  @Test
  @Tag("smoke")
  void testUpworkLogin() {
    upworkLoginPage.navigateToUpworkHomepage();
//    upworkLoginPage.login("f3101810241dmxhm", "strange!");
    upworkLoginPage.login("", "strange!");
  }

}
