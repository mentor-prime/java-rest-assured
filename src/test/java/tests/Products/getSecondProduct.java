package tests.Products;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class getSecondProduct extends TestBase {
    @Test
    void getSecondProduct_shouldReturnProduct2() {

        var response = given()
                .spec(spec)
                .when()
                .get("/products/2")
                .then()
                .statusCode(200)
                .body("id", equalTo(2))
                .body("title", not(isEmptyOrNullString()))
                .body("price", greaterThan(0f))
                .body("category", not(isEmptyOrNullString()))
                .extract()
                .response();

        System.out.println("=== PRODUCT ===");
        System.out.println("ID: " + response.jsonPath().getInt("id"));
        System.out.println("TITLE: " + response.jsonPath().getString("title"));
    }
}
