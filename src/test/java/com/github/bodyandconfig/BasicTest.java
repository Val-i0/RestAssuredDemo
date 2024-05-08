package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.Matchers;
public class BasicTest {

    @BeforeMethod
    void setup() {
        RestAssured.baseURI = "https://reqres.in/api/users?page=1";
    }

    @Test
    void basicTest() {
        RestAssured
                .given()
                    .header("name", "value")
                .when()
                    .get() // takes the URL from @BeforeMethod
                    .prettyPeek()
                .then()
                    .statusCode(200)
                    .header("Content-Type", "application/json; charset=utf-8")
                .body("page", equalTo(1))
                .body("per_page", equalTo(6))
                .rootPath("data")
                .body("first_name[0]", equalTo("George"))
                .body("first_name", hasItems("Emma", "Tracey"))
                .rootPath("")
                .body("total_pages", equalTo(2));
    }

}
