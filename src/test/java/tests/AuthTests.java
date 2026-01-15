package tests;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AuthTests extends TestBase {

    @Test
    void login_shouldReturnToken() {
        String payload = """
                {
                  "username": "kminchelle",
                  "password": "0lelplR"
                }
                """;

        given()
                .spec(spec)
                .body(payload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .body("username", equalTo("kminchelle"));
    }
}