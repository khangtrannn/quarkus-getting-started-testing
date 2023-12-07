package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentService {
  @ConfigProperty(name = "payment.provider", defaultValue = "paypal")
  String paymentProvider;

  public String getPaymentProvider() {
    return paymentProvider;
  }
}
