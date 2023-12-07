package org.acme.country;

import java.util.List;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class Country {
  private final String fifa;
  private final List<String> captitals;

  @JsonbCreator
  public Country(@JsonbProperty("fifa") String fifa, @JsonbProperty("capital") List<String> capitals) {
    this.fifa = fifa;
    this.captitals = capitals;
  }

  public String getFifa() {
    return fifa;
  }

  public List<String> getCaptitals() {
    return captitals;
  }

}
