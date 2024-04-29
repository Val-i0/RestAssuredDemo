package com.github.headers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class ValidatableResponseDemo {
    static final String BASE_URL = "https://api.github.com/";

    @Test
    public void basicValidatableExample() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("x-ratelimit-limit", "60");

    }

    @Test
    public void simpleHamcrestMatchers() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .statusCode(lessThan(300))
                .header("cache-control", containsStringIgnoringCase("max-age=60"))
                .time(lessThan(2L), TimeUnit.SECONDS)
                .header("etag", notNullValue())
                .header("etag", not(emptyString()));
    }

    @Test
    public void usingMapsToTestHeaders() {
        RestAssured.get(BASE_URL)
                .then()
                .headers(
                        "content-encoding", "gzip",
                        "access-control-allow-origin", "*",
                        "cache-control" , containsString("public")
                );
    }

    Map<String, String> expectedHeaders = Map.of("content-encoding", "gzip",
            "access-control-allow-origin", "*");

    @Test
    public void usingMapsToTestHeaders2() {
        RestAssured.get(BASE_URL)
                .then()
                .headers(expectedHeaders);
    }
}
