package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    public void testGreetingEndPoint() {
        given()
            .pathParam("name", "Khang")
            .when().get("/hello/greeting/{name}")
            .then()
                .statusCode(200)
                .body(is("hello Khang"));
    }
}