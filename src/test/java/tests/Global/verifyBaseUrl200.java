package tests.Global;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.example.base.TestBase.spec;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class verifyBaseUrl200 extends TestBase {

    @Test
    void verifyBaseUrlShouldBeReachable() {

        given()
                .spec(spec)
                .when()
                .get("/")
                .then()
                .statusCode(200);
    }

}
