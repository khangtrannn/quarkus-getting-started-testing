package org.acme.country;

import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MockCountryResourceTest {
  @InjectMock
  @RestClient
  CountryService countryService;

  @BeforeEach
  void setUp() {
    Mockito.when(countryService.getByName("germany")).thenReturn(Collections.singletonList(new Country("Mock Germany Fifa", List.of("Berlin"))));
  }

  @Test
  public void testGermany() {
    given()
      .when().get("/country/name/germany")
      .then()
      .statusCode(200)
      .body("$.size()", is(1), "[0].fifa", is("Mock Germany Fifa"));
  }

  @Test
  public void testFrance() {
    given()
      .when().get("/country/name/france")
      .then()
      .statusCode(200)
      .body("$.size()", is(0));
  }
}
