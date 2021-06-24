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
    static RequestSpecification getresponseSpec() {

        RequestSpecBuilder reqbuilder = new RequestSpecBuilder();
        reqbuilder.setBaseUri("https://swapi.dev/api/");
        reqbuilder.setBasePath("people/1");
        RequestSpecification responseSpec = reqbuilder.build();
        return responseSpec;
    }
        @Test
        public void happycase(){
                ValidatableResponse validatableResponse = given()
                        .spec(getresponseSpec())
                         .queryParam("page","2")
                        .contentType(ContentType.JSON)
                         .when()
                        .get()
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .body("name",equalTo("Luke Skywalker"));
               }
        }

