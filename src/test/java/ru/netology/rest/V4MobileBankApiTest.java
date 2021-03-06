package ru.netology.rest;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class V4MobileBankApiTest {
    @Test
    void shouldReturnDemoAccounts() {

        given()
                .baseUri("http://localhost:9999/api/v1")

                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
        ;
    }
}
