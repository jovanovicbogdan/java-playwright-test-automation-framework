package dev.bogdanjovanovic.api;

import dev.bogdanjovanovic.fixtures.APITestFixtures;
import dev.bogdanjovanovic.services.GoREST;
import org.junit.jupiter.api.Test;

public class GoRESTAPITests extends APITestFixtures {

  @Test
  void createUser() {
    final GoREST goREST = new GoREST(restClient);
    goREST.createUser();
  }

  @Test
  void getUsers() {
    final GoREST goREST = new GoREST(restClient);
    goREST.getUsers();
  }

}
