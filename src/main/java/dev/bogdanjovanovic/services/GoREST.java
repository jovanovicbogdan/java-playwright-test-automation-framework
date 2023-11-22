package dev.bogdanjovanovic.services;

import dev.bogdanjovanovic.rest.RestClient;

import java.net.URI;
import java.util.HashMap;

public class GoREST {

  private final RestClient restClient;

  public GoREST(final RestClient restClient) {
    this.restClient = restClient;
  }

  public void createUser() {
    final HashMap<String, Object> values = new HashMap<>() {
      {
        put("name", "René Descartes");
        put("email", "rene@gmail.com");
        put("gender", "male");
        put("status", "active");
      }
    };
    final URI uri = URI.create("https://gorest.co.in/public/v2/users");
    restClient.sendPostRequest(uri, values, "Accept", "application/json");
  }

  public void getUsers() {
    final URI uri = URI.create("https://gorest.co.in/public/v2/users?page=2&per_page=20");
    restClient.sendGetRequest(uri, "Accept", "application/json");
  }

}
