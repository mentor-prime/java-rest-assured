package tests.Products;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class getProductInvalidId extends TestBase {

    @Test
    void getProductInvalidID() {
            given()
                .spec(spec)
                .when()
                .get("/products/x1")
                .then()
                .statusCode(404);
    }
}
