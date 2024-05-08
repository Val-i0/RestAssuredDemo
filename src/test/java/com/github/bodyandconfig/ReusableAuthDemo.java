package com.github.bodyandconfig;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReusableAuthDemo {
    static final String REPO_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "test empty fake token";

    // option 2
    static RequestSpecification spec = new RequestSpecBuilder()
            .setAuth(RestAssured.oauth2(TOKEN))
            .setBaseUri(REPO_EP)
            .build();

/*    @BeforeMethod
    void setup() {
        // option 1
        RestAssured.authentication = RestAssured.oauth2(TOKEN);
    }*/

    @Test
    public void methodName() {
        RestAssured.given(spec)
                //.get(REPO_EP)
                .get()
                .then()
                .statusCode(200);
    }
}
