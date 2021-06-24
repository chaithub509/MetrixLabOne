package com.ml.api.metrixapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class swaggerdev {

    RequestSpecification responseSpec;
    @BeforeTest
    public   void  Requestspec() {
        RequestSpecBuilder reqbuilder = new RequestSpecBuilder();
        reqbuilder.setBasePath("https://swapi.dev/api/");
        reqbuilder.setBaseUri("people/1");
        responseSpec = reqbuilder.build();
    }

        @Test
        public void happycase(){
                ValidatableResponse validatableResponse = given()
                        .spec(responseSpec)
                        .contentType(ContentType.JSON)
                        .when()
                        .get()
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .body("$.name",equalTo("Luke Skywalker"));
               }
        }

