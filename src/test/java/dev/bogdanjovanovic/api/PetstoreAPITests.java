package dev.bogdanjovanovic.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import dev.bogdanjovanovic.fixtures.APITestFixtures;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PetstoreAPITests extends APITestFixtures {

  @Test
  @Tag("api")
  void shouldAddNewPetToTheStore() {
    final Map<String, Object> data = new HashMap<>();
    data.put("id", 1);
    data.put("name", "doggie");
    data.put("status", "available");

    final Map<String, Object> category = new HashMap<>();
    category.put("id", 1);
    category.put("name", "dog");
    data.put("category", category);

    final List<String> photoUrls = new ArrayList<>();
    photoUrls.add("https://doggie.com");
    data.put("photoUrls", photoUrls);

    final List<Map<String, Object>> tags = new ArrayList<>();
    final Map<String, Object> tag = new HashMap<>();
    tag.put("id", 1);
    tag.put("name", "dogz");
    tags.add(tag);
    data.put("tags", tags);

    final APIResponse newPetResponse = request.post("/v2/pet", RequestOptions.create().setData(data));
    assertTrue(newPetResponse.ok());
  }

  @Test
  @Tag("api")
  void shouldGetPetById() {
    final APIResponse petResponse = request.get("/v2/pet/" + 1);
    assertTrue(petResponse.ok());
    final JsonObject pet = new Gson().fromJson(petResponse.text(), JsonObject.class);
    assertTrue(pet.has("id"));
    assertTrue(pet.get("category").isJsonObject());
  }

}
