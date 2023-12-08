package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import io.quarkus.test.component.TestConfigProperty;
import jakarta.inject.Inject;

@QuarkusComponentTest
@TestConfigProperty(key = "bar", value = "true")
public class FooTest {
  @Inject
  Foo foo;

  @InjectMock
  Charlie charlieMock;

  @Test
  public void testPing() {
    Mockito.when(charlieMock.ping()).thenReturn("OK");
    assertEquals("OK", foo.ping());
  }
}
