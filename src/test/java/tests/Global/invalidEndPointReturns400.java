package tests.Global;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.example.base.TestBase.spec;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class invalidEndPointReturns400 extends TestBase {

    @Test
    void verifyBaseUrlShouldBeReachable() {

        given()
                .spec(spec)
                .when()
                .get("/invalid")
                .then()
                .statusCode(404)
                .statusCode(not(200));
    }

}
