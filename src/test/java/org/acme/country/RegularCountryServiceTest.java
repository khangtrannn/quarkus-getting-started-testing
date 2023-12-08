package org.acme.country;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@QuarkusTestResource(value = WireMockCountriesProxy.class, restrictToAnnotatedClass = true)
public class RegularCountryServiceTest {
  @Inject
  @RestClient
  CountryService countryService;

  @Test
  void testGR() {
    assertThat(countryService.getByName("GR")).hasSizeGreaterThan(1).extracting("fifa").contains("BEL");
  }

  @Test
  void testVietNamWireMock() {
    assertThat(countryService.getByName("vietnam")).hasSize(1).extracting("fifa").contains("Viet Nam Fifa WireMock");
  }
}
