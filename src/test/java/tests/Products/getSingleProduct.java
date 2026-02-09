package tests.Products;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.example.base.TestBase.spec;
import static org.hamcrest.Matchers.*;

public class getSingleProduct extends TestBase {

    @Test
    void getSingleProduct_shouldReturnProduct1() {

        var response = given()
                .spec(spec)
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
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