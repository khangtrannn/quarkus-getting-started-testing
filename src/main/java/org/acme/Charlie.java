package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Charlie {
  public String ping() {
    return "Lightning";
  }
}
