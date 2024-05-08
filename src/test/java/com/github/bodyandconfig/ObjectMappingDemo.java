package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import restassuredobjects.User;
import restassuredobjects.UserRecord;

import static org.testng.AssertJUnit.assertEquals;

public class ObjectMappingDemo {
    static final String URL = "https://api.github.com/users/rest-assured";

    @Test
    void ObjectMappingTest() {
        User user = RestAssured.get(URL).as(User.class);

        assertEquals(user.getId(), 19369327);
        assertEquals(user.getLogin(), "rest-assured");
        assertEquals(2, user.getPublicRepos());
    }

    @Test
    void ObjectMappingRecordsTest() {
        UserRecord user = RestAssured.get(URL).as(UserRecord.class);

        assertEquals(user.id(), 19369327);
        assertEquals(user.login(), "rest-assured");
        assertEquals(2, user.publicRepos());
    }
}
