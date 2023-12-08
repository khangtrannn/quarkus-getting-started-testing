package org.acme.country;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class RegularCountryResourceTest {
  @Test
  public void testVietNam() {
    given()
      .when().get("/country/name/vietnam")
      .then()
      .statusCode(200)
      .body("$.size()", is(1), "[0].fifa", is("VIE"));
  }
}
