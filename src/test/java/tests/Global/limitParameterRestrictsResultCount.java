package tests.Global;

import io.restassured.http.ContentType;
import org.example.base.TestBase;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class limitParameterRestrictsResultCount extends TestBase {

    @Test
    void verifyLimitRestrictsResultCountTo200() {
        given()
                .spec(spec)
                .queryParam("limit", 200)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("products.size()", lessThanOrEqualTo(200));
    }
}
