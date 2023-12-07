package org.acme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ExternalServiceTest {
  @Inject
  ExternalService externalService;

  @Test
  public void testExternalService() {
    Assertions.assertEquals("mock", externalService.service());
  }
}
