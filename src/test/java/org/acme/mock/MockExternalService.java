package org.acme.mock;

import org.acme.ExternalService;

import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
public class MockExternalService extends ExternalService {
  @Override
  public String service() {
    return "mock";
  }
}
