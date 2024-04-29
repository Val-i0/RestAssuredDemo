package com.github.params;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class QueryParamsDemo {
    static final String BASE_URL = "https://api.github.com/search/repositories";

    @Test
    void withoutParams() {
        RestAssured.get(BASE_URL + "?q=java&per_page=1")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void withParams() {
        RestAssured
                .given()
                .param("q", "java")
                .param("per_page", "1")
                .get(BASE_URL)
                .then()
                .statusCode(200);
    }
}
