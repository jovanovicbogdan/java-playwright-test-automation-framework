package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.SwagLabsPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class SwagLabsE2ETests extends TestFixtures {

  @Test
  @Tags({@Tag("smoke"), @Tag("swaglabs")})
  void testLoginSwagLabs() {
    swagLabsPage.navigateToSwagLabsHomepage();
    swagLabsPage.login("standard_user", "secret_sauce");
  }

}
