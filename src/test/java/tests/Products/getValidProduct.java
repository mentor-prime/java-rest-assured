package tests.Products;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class getValidProduct extends TestBase {

    @Test
    void getValidProduct() {
        given()
                .spec(spec)
                .when()
                .get("/products/1")
                .then()
                .statusCode(not(404))
                .body("error", not(equalTo("Internal Server Error")));
    }
}
