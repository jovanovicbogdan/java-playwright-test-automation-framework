package dev.bogdanjovanovic.rest;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class RestClient {

  public HttpResponse<String> sendGetRequest(final URI uri, final String... headers) {
    try {
      final HttpRequest request = HttpRequest
          .newBuilder(uri)
          .headers(headers)
          .GET()
          .build();
      final HttpClient client = HttpClient.newHttpClient();
      final HttpResponse<String> response = client.send(request,
          HttpResponse.BodyHandlers.ofString());
      System.out.println(response.body());
      return response;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  public HttpResponse<String> sendPostRequest(final URI uri, final HashMap<String, Object> body,
      final String... headers) {
    try {
      final ObjectMapper objectMapper = new ObjectMapper();
      final HttpRequest request = HttpRequest
          .newBuilder(uri)
          .headers(headers)
          .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(body)))
          .build();
      final HttpClient client = HttpClient.newHttpClient();
      final HttpResponse<String> response = client.send(request,
          HttpResponse.BodyHandlers.ofString());
      System.out.println(response.body());
      return response;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

}
