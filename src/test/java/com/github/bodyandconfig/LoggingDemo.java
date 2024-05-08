package com.github.bodyandconfig;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.Test;

public class LoggingDemo {
    public final String POSTS_EP = "https://jsonplaceholder.typicode.com/posts";

    @Test
    public void logTest() {
        RestAssured
                .given()
                    //.log().all()
                    .log().headers()
                    .log().body()
                .when()
                    .get(POSTS_EP)
                    //.prettyPeek()
                .then()
                    .log().headers()
                    .log().ifValidationFails(LogDetail.ALL)
                    .statusCode(200);
    }
}
