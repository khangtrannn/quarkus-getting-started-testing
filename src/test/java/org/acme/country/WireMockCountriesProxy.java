package org.acme.country;

import com.github.tomakehurst.wiremock.WireMockServer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.util.Collections;
import java.util.Map;

public class WireMockCountriesProxy implements QuarkusTestResourceLifecycleManager {
  private WireMockServer wireMockServer;

  @Override
  public Map<String, String> start() {
    wireMockServer = new WireMockServer(8089);
    wireMockServer.start();
    configureFor(8089);

    stubFor(
      get(urlEqualTo("/v3.1/name/vietnam"))
        .willReturn(
          aResponse()
            .withHeader("Content-Type", "application/json")
            .withBody("[{ \"fifa\": \"Viet Nam Fifa WireMock\" }]")
        )
    );

    stubFor(
      get(urlMatching(".*"))
        .atPriority(10)
        .willReturn(aResponse().proxiedFrom("https://restcountries.com/")));

    return Collections.singletonMap("quarkus.rest-client.rest-countries.url", wireMockServer.baseUrl());
  }

  @Override
  public void stop() {
    if (wireMockServer != null) {
      wireMockServer.stop();
    }
  }
}
