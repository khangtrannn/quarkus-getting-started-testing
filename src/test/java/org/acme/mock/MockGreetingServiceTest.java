package org.acme.mock;

import static org.mockito.Mockito.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@QuarkusTest
public class MockGreetingServiceTest {
  @InjectMock
  GreetingService greetingService;

  @Test
  public void testGreeting() {
    when(greetingService.greet()).thenReturn("hi");
    given()
      .when().get("/greeting")
      .then().statusCode(200)
      .body(is("hi"));
  }

  @Path("greeting")
  public static class GreetingResource {
    final GreetingService greetingService;

    public GreetingResource(GreetingService greetingService) {
      this.greetingService = greetingService;
    }

    @GET    
    @Produces("text/plain")
    public String greet() {
      return greetingService.greet();
    }
  }

  @ApplicationScoped
  public static class GreetingService {
    public String greet() {
      return "hello";
    }
  }
}
