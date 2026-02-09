package tests.Global;

import io.restassured.http.ContentType;
import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.example.base.TestBase.spec;

public class validateResponseTypeJSON extends TestBase {

    @Test
    void verifyBaseUrlShouldBeReachable() {

        given()
                .spec(spec)
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .contentType(ContentType.HTML);
    }

}
