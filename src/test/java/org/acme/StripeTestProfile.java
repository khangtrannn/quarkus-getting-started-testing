package org.acme;

import java.util.Map;
import java.util.Set;

import io.quarkus.test.junit.QuarkusTestProfile;

public class StripeTestProfile implements QuarkusTestProfile {
  @Override
  public Map<String, String> getConfigOverrides() {
    return Map.of("payment.provider", "stripe");
  }

  @Override
  public Set<String> tags() {
    return Set.of("stripe");
  }
}
