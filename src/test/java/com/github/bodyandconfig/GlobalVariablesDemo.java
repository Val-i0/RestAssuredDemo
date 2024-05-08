package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GlobalVariablesDemo {
    @BeforeMethod
    void setup()
    {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/users";
        RestAssured.rootPath = "data";
    }

    @Test
    public void methodName() {
        RestAssured.get()
                .prettyPeek()
                .then()
                .body("id[0]", equalTo(1));

    }
}
