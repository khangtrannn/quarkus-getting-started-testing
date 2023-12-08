package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Foo {
  @Inject
  Charlie charlie;

  @ConfigProperty(name = "bar")
  boolean bar;

  public String ping() {
    return bar ? charlie.ping() : "nok";
  }
}
