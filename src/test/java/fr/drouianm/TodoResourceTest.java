package fr.drouianm;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TodoResourceTest {
    @Test
    public void testGetEndpoint() {
        given()
        .when().get("/todo")
        .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }
    
}
