package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import restassuredobjects.Repository;

public class ObjectToJson {
//    Repository repo = new Repository("deleteme");

    static final String REPO_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "fake-token"; // DO NOT USE REAL TOKEN!
    @Test(description = "Create a repo with POST")
    void postTest() {
        var repo = new Repository("deleteme");

        RestAssured
                .given()
//                .header("Authorization", "token " + TOKEN)
                .auth()
                .oauth2(TOKEN)
                .body(repo)
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201);
    }
}
