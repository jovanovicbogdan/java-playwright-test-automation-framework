package dev.bogdanjovanovic.fixtures;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.HashMap;
import java.util.Map;

@TestInstance(Lifecycle.PER_CLASS)
public class APITestFixtures {

  private Playwright playwright;
  private APIRequestContext request;

  void createPlaywright() {
    playwright = Playwright.create();
  }

  void createAPIRequestContext() {
    final Map<String, String> headers = new HashMap<>();
    headers.put("Accept", "application/json");

    request = playwright.request().newContext(new APIRequest.NewContextOptions()
        .setBaseURL("https://petstore.swagger.io/v2")
        .setExtraHTTPHeaders(headers));
  }

  @BeforeAll
  void beforeAll() {
    createPlaywright();
    createAPIRequestContext();
  }

  void disposeAPIRequestContext() {
    if (request != null) {
      request.dispose();
      request = null;
    }
  }

  void closePlaywright() {
    if (playwright != null) {
      playwright.close();
      playwright = null;
    }
  }

  @AfterAll
  void afterAll() {
    disposeAPIRequestContext();
    closePlaywright();
  }

}
