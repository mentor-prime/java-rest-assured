package tests.Products;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.example.base.TestBase.spec;
import static org.hamcrest.Matchers.*;

public class getAllProducts extends TestBase {

/*    @Test
    void getAllProducts() {
        var response = given()
                        .spec(spec)
                        .get("/products")
                        .then()
                        .statusCode(200)
                        .body("")

    }
 */
    @Test
    void getAllProducts_withSpec_shouldReturn200_andHaveProductsArray() {

        var response = given()
                .spec(spec)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("products", notNullValue())
                .body("products.size()", greaterThan(0))
                .body("products[0].id", notNullValue())
                .body("products[0].title", not(isEmptyOrNullString()))
                .extract()
                .response();

        var titles = response.jsonPath().getList("products.title");
        System.out.println("=== PRODUCT TITLES (spec) ===");
        titles.forEach(System.out::println);
    }

    @Test
    void getAllProducts() {
        given()
            .spec(spec)
            .when()
            .get("/products")
            .then()
            .statusCode(not(201));
    }

    @Test
    void getAllProducts_withoutSpec_shouldReturn200_andHaveProductsArray() {

        var response = given()
                .relaxedHTTPSValidation() // temp workaround
                .baseUri("https://dummyjson.com")
                .contentType("application/json")
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("products", notNullValue())
                .body("products.size()", greaterThan(0))
                .extract()
                .response();

        var titles = response.jsonPath().getList("products.title");
        System.out.println("=== PRODUCT TITLES (no spec) ===");
        titles.forEach(System.out::println);
    }
}