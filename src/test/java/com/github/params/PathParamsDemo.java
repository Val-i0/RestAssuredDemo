package com.github.params;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Map;

public class PathParamsDemo {
    static final String REPO_EP = "https://api.github.com/repos";

    @Test
    void withoutParamHardcoded() {
        RestAssured.get(REPO_EP + "/dermenji/SeleniumDemo")
                .then()
                .statusCode(200);
        https://api.github.com/repos
        RestAssured.get(String.format("https://api.github.com/repos/%s/%s"), "dermenji", "SeleniumDemo")
                .then()
                .statusCode(200);
    }

    @Test
    void withOverloadedGet() {
        RestAssured.get(REPO_EP + "/dermenji/SeleniumDemo")
                .then()
                .statusCode(200);
        https://api.github.com/repos
        RestAssured.get(String.format("https://api.github.com/repos/{user}/{repo}"), "dermenji", "SeleniumDemo")
                .then()
                .statusCode(200);
    }

    @Test
    void withParams() {
        RestAssured
                .given()
                .pathParam("user", "dermenji")
                .pathParam("repo", "SeleniumDemo")
                .get(REPO_EP + "/{user}/{repo}")
                .then()
                .statusCode(200);
    }

    @Test
    void withParamsMap() {
        Map<String, String> reusableMap = Map.of("user", "dermenji",
                "repo", "SeleniumDemo");
        RestAssured
                .given()
                .pathParams(reusableMap)
                .get(REPO_EP + "/{user}/{repo}")
                .then()
                .statusCode(200);
    }
}
