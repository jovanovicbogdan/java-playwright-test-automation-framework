package dev.bogdanjovanovic.ui;

import dev.bogdanjovanovic.common.TestFixtures;
import dev.bogdanjovanovic.poms.SwagLabsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class SwagLabsE2ETests extends TestFixtures {

  @Test
  @Tags({@Tag("smoke"), @Tag("swaglabs")})
  @DisplayName("SwagLabs login test")
  @Description("This test verifies that user can login to SwagLabs")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("Bogdan Jovanović")
  @Link(name = "Bitbucket", url = "https://bitbucket.org/...")
  @Issue("QA-1234")
  @TmsLink("TC-1234")
  void testLoginSwagLabs() {
    swagLabsPage.navigateToSwagLabsHomepage();
    swagLabsPage.login("standard_user", "secret_sauce");
  }

}
