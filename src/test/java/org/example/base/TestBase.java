package org.example.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static RequestSpecification spec;

    @BeforeAll
    static void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        spec = new RequestSpecBuilder()
                .setBaseUri("https://dummyjson.com")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        // Useful: only prints request/response when an assertion fails
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}