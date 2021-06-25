package com.ml.api.metrixapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;


public class SwaggerDev {
    public static Logger logger = LogManager.getLogger(SwaggerDev.class);

    LogReport report = new LogReport();
    @BeforeClass
    static RequestSpecification getrequestSpec() {

        RequestSpecBuilder reqbuilder = new RequestSpecBuilder();
        reqbuilder.setBaseUri("https://swapi.dev/api/");
        reqbuilder.setBasePath("people/1");
        RequestSpecification requestSpec = reqbuilder.build();
        return requestSpec;

    }

    @AfterClass
    static ResponseSpecification getresponseSpec() {
        ResponseSpecBuilder reqbuilder = new ResponseSpecBuilder();
        reqbuilder.expectStatusCode(200);
        reqbuilder.expectStatusLine("HTTP/1.1 200 OK");
        reqbuilder.expectContentType("application/json");
        ResponseSpecification responeSpec = reqbuilder.build();
        return responeSpec;
    }
      @Test(priority = 0)
    public void happyCase() {
                   ValidatableResponse validatableResponse = given()
                  .spec(getrequestSpec())
                  .contentType(ContentType.JSON)
                  .when()
                  .get()
                  .then()
                  .log().all()
                   .assertThat().spec(getresponseSpec());
                   logger.info("Happy path test case is executed");


      }

    @Test(priority = 1)
    public void edgeCase() {
                Response response = given()
                .spec(getrequestSpec())
                .queryParam("page", "2")
                .contentType(ContentType.JSON)
                .when()

                .get();
        JsonPath jsonPathEvaluator = response.jsonPath();
        JSONObject json = new JSONObject(response.getBody().asString());
        String value = jsonPathEvaluator.get("name").toString();
        Assert.assertEquals(value,"Luke Skywalker");
        report.responseJsonObjectValidation(value,"Luke Skywalker");
        logger.info("Edge path test case is executed");


    }
}



