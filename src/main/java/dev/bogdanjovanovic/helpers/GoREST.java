package dev.bogdanjovanovic.helpers;

import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class GoREST {

  public void createUser() {
    try {
      final String requestBody = prepareRequest();
      final HttpRequest request = HttpRequest

          .newBuilder(URI.create("https://gorest.co.in/public/v2/users"))
          .header("Accept", "application/json")
          .POST(HttpRequest.BodyPublishers.ofString(requestBody))
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

  public void getUsers() {
    try {
      final String requestBody = prepareRequest();
      final HttpRequest request = HttpRequest

          .newBuilder(URI.create("https://gorest.co.in/public/v2/users"))
          .header("Accept", "application/json")
          .GET()
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

  private String prepareRequest() throws JsonProcessingException {
    final HashMap<String, Object> values = new HashMap<>() {
      {
        put("name", "René Descartes");
        put("email", "rene@gmail.com");
        put("gender", "male");
        put("status", "active");
      }
    };

    final ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(values);
  }

}
