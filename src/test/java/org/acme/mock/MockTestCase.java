package org.acme.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@QuarkusTest
public class MockTestCase {
  @Inject
  MockableBean1 mockableBean1;

  @Inject
  MockableBean2 mockableBean2;

  @BeforeAll
  public static void setup() {
    MockableBean1 mock = Mockito.mock(MockableBean1.class);
    Mockito.when(mock.greet("Stuart")).thenReturn("A mock for Stuart");
    QuarkusMock.installMockForType(mock, MockableBean1.class);
  }

  @Test
  public void testBeforeAll() {
    Assertions.assertEquals("A mock for Stuart", mockableBean1.greet("Stuart"));
    Assertions.assertEquals("Hello Stuart", mockableBean2.greet("Stuart"));
  }

  @Test
  public void testPerTestMock() {
    QuarkusMock.installMockForInstance(new BonjorGreeter(), mockableBean2);
    Assertions.assertEquals("A mock for Stuart", mockableBean1.greet("Stuart"));
    Assertions.assertEquals("Bonjour Stuart", mockableBean2.greet("Stuart"));
  }

  @ApplicationScoped
  public static class MockableBean1 {
    public String greet(String name) {
      return "Hello " + name;
    }
  }

  @ApplicationScoped
  public static class MockableBean2 {
    public String greet(String name) {
      return "Hello " + name;
    }
  }

  public static class BonjorGreeter extends MockableBean2 {
    @Override
    public String greet(String name) {
      return "Bonjour " + name;
    }
  }
}
