package org.acme.country;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class RegularCountryResourceTest {
  @Test
  public void testGreece() {
    given()
      .when().get("/country/name/vietnam")
      .then()
      .statusCode(200)
      .body("$.size()", is(1), "[0].fifa", is("VIE"));
  }
}
