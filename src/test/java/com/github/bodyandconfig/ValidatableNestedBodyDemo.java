package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ValidatableNestedBodyDemo {
    static final String LIMIT_EP = "https://api.github.com/user/repos";
    static final String TT_EP = "https://reqres.in/api/users?page=1";

    @Test
    public void nestedBodyValidation() {
        RestAssured.get(LIMIT_EP)
                .prettyPeek()
                .then()
                .rootPath("resources.core")
                    .body("limit", equalTo(60))
                    .body("remaining", lessThanOrEqualTo(60))
                    .body("reset", Matchers.notNullValue())
                .rootPath("resources.graphql")
                    .body("limit", equalTo(0))
                    .body("remaining", Matchers.lessThan(10))
                .noRootPath()
                .body("resources.search.limit", equalTo(10));
    }

    @Test
    void repeatingItems() {
        RestAssured.get(TT_EP)
                .prettyPeek()
                .then()
                .body("data.id[0]", equalTo(1))
                .body("data.id[5]", equalTo(6))
                .body("data.first_name[2]", equalTo("Emma"))
                .body("data.first_name[3]", equalTo("Eve"))
                .body("data.first_name", hasItem("Eve"))
                .body("data.first_name", hasItems("Eve", "Emma"))
                .body("data.first_name", hasItems("Eve", "Emma"))
                .body("data.first_name", hasItems(endsWith("ma")))
                .body("data.first_name", hasItems(startsWith("Em")));
    }
}
