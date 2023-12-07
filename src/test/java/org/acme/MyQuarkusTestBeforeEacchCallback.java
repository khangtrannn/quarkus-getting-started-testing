package org.acme;

import io.quarkus.test.junit.callback.QuarkusTestBeforeEachCallback;
import io.quarkus.test.junit.callback.QuarkusTestMethodContext;

public class MyQuarkusTestBeforeEacchCallback implements QuarkusTestBeforeEachCallback {
  @Override
  public void beforeEach(QuarkusTestMethodContext context) {
    System.out.println("Executing " + context.getTestMethod());
  }
}
