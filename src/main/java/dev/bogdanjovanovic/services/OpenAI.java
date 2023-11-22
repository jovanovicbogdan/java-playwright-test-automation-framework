package dev.bogdanjovanovic.services;

import dev.bogdanjovanovic.contants.AppURLs;
import dev.bogdanjovanovic.models.ChatCompletion;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class OpenAI {

  final String OPENAI_API_KEY = System.getenv("OPENAI_API_KEY");
  final String CHAT_COMPLETIONS_ENDPOINT_V1 = "/v1/chat/completions";

  public void chatCompletion(final ChatCompletion prompt) {
    try {
      final HttpRequest request = HttpRequest

          .newBuilder(URI.create(AppURLs.OPENAI_BASE_API_URL + CHAT_COMPLETIONS_ENDPOINT_V1))
          .header("Accept", "application/json")
          .POST(HttpRequest.BodyPublishers.ofString(prepareRequest(prompt)))
          .build();

      final HttpClient client = HttpClient.newHttpClient();
      final HttpResponse<String> response = client.send(request,
          HttpResponse.BodyHandlers.ofString());

      System.out.println(response.body());
      client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  private String prepareRequest(final ChatCompletion prompt) throws JsonProcessingException {
    final HashMap<String, Object> values = new HashMap<>() {
      {
        put("model", prompt.model());
        put("messages", prompt.messages());
      }
    };

    final ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(values);
  }

}
