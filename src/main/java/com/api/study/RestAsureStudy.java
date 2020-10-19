package com.api.study;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAsureStudy {
    @Test
    public void test01(){
        given()
                .queryParam("id","1")
        .when()
                .log().all()
                .get()
        .then()
                .log().all()
                .statusCode(200);
    }
}
