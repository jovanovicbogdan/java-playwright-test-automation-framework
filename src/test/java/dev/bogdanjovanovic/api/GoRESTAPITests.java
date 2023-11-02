package dev.bogdanjovanovic.api;

import dev.bogdanjovanovic.fixtures.APITestFixtures;
import dev.bogdanjovanovic.helpers.GoREST;
import org.junit.jupiter.api.Test;

public class GoRESTAPITests extends APITestFixtures {

  @Test
  void createUser() {
    final GoREST goREST = new GoREST();
    goREST.createUser();
  }

  @Test
  void getUsers() {
    final GoREST goREST = new GoREST();
    goREST.getUsers();
  }

}
