package tests.Products;

import org.example.base.TestBase;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductsTests extends TestBase {


    @Test
    void getProducts_shouldReturn200_andHaveProductsArray() {
        given()
                .spec(spec)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("products", notNullValue())
                .body("products.size()", greaterThan(0))
                .body("products[0].id", notNullValue())
                .body("products[0].title", not(emptyString()));
    }

    @Test
    void getSingleProduct_shouldReturnProduct1() {
        given()
                .spec(spec)
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", not(emptyString()));
    }

    @Test
    void searchProducts_shouldReturnMatchingResults() {
        given()
                .spec(spec)
                .queryParam("q", "phone")
                .when()
                .get("/products/search")
                .then()
                .statusCode(200)
                .body("products.size()", greaterThan(0))
                .body("products.title", notNullValue());
    }

    @Test
    void listAllProducts_shouldReturnProductsList() {
        given()
                .spec(spec)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                // products array exists and is not empty
                .body("products", notNullValue())
                .body("products.size()", greaterThan(0))
                // basic sanity checks on first product
                .body("products[0].id", notNullValue())
                .body("products[0].title", not(isEmptyOrNullString()))
                .body("total", greaterThan(0))
                .body("limit", greaterThan(0));
    }

    @Test
    void listAllProducts_andPrintTitles() {

        var response =
                given()
                        .spec(spec)
                        .when()
                        .get("/products")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        // Extract titles
        var titles = response.jsonPath().getList("products.title");

        System.out.println("=== PRODUCT TITLES ===");
        titles.forEach(System.out::println);
    }

    @Test
    void getProducts_withoutSpec_shouldReturn200_andHaveProductsArray() {

        var response = given().baseUri("https://dummyjson.com")
                .baseUri("https://dummyjson.com")
                .header("Content-Type", "application/json")
                .when()
                .get("products/")
                .then()
                        .statusCode(200)
                .statusCode(200)
                .extract()
                .response();

        // Extract titles
        var titles = response.jsonPath().getList("products.title");

        System.out.println("=== PRODUCT TITLES ===");
        titles.forEach(System.out::println);
    }

}




