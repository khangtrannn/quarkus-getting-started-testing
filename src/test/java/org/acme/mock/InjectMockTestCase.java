package org.acme.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.context.ApplicationScoped;

@QuarkusTest
public class InjectMockTestCase {
  @InjectMock
  MockableBean1 mockableBean1;

  @InjectMock
  MockableBean2 mockableBean2;

  @BeforeEach
  public void setup() {
    Mockito.when(mockableBean1.greet("Khang")).thenReturn("A mock for Khang");
  }

  @Test
  public void firstTest() {
    Assertions.assertEquals("A mock for Khang", mockableBean1.greet("Khang"));

    // Since the mockableBean2 mock has not been configured, it will return the default Mockito response
    Assertions.assertEquals(null, mockableBean2.greet("Khang"));
  }

  @Test
  public void secondTest() {
    Mockito.when(mockableBean2.greet("Khang")).thenReturn("Bonjour Khang");
    Assertions.assertEquals("A mock for Khang", mockableBean1.greet("Khang"));
    Assertions.assertEquals("Bonjour Khang", mockableBean2.greet("Khang"));
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
}
