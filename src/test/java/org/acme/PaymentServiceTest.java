package org.acme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;

@QuarkusTest
@TestProfile(StripeTestProfile.class)
public class PaymentServiceTest {
  @Inject
  PaymentService paymentService;

  @Test
  public void testStripePaymentProvider() {
    String provider = paymentService.getPaymentProvider();
    Assertions.assertEquals("stripe", provider);
  }
}
