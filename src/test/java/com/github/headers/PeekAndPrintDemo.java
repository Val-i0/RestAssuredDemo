package com.github.headers;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PeekAndPrintDemo {
    static final String BASE_URL = "https://api.github.com/";

    // peek returns Response Headers AND Body
    @Test
    void peek() {
        RestAssured.get(BASE_URL).peek();
    }

    @Test
    void prettyPeek() {
        RestAssured.get(BASE_URL).prettyPeek();
    }

    // print returns only Response Body
    @Test
    void print() {
        RestAssured.get(BASE_URL).print();
    }

    @Test
    void prettyPrint() {
        RestAssured.get(BASE_URL).prettyPrint();
    }
}
