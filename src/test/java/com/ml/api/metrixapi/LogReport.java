package com.ml.api.metrixapi;

import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

public class LogReport extends  Listeners {


    public static void responseCodeValidation( Response response, int statusCode) {

            try {
                Assert.assertEquals(statusCode, response.getStatusCode());
                test.log(Status.PASS, "Successfully validated status code, status code is :: " + response.getStatusCode());
            } catch (AssertionError e) {
                test.log(Status.FAIL, e.fillInStackTrace());
                test.log(Status.FAIL,
                        "Expected status code is :: " + statusCode + " , Actual Status Code is :: " + response.getStatusCode());
            } catch (Exception e) {
                test.log(Status.FAIL, e.fillInStackTrace());
            }
        }



        public static void logResponse(Response response) {
            try {

                test.log(Status.INFO, "<b>Api response is :</b>\n" + response.prettyPrint());
            } catch (Exception e) {
                test.log(Status.FAIL, e.fillInStackTrace());
            }
        }

        public static void validateValue(String Description, String ExpectedValue, String ActualValue){

            test.log(Status.INFO, Description + ExpectedValue + ActualValue);


        }

        public static void logDescriptionPass(String Description){

            test.log(Status.PASS, Description );


        }
        public static void logDescriptionFail(String Description){

            test.log(Status.PASS,Description);


        }

    public  void responseJsonObjectValidation( String ActualValue,String ExpectedValue) {
        try {
            Assert.assertEquals(ActualValue,ExpectedValue);
            test.log(Status.PASS, "Successfully validated value of the key is, ExpectedValue  is :: "+ExpectedValue +"::" +ActualValue);
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.fillInStackTrace());
            test.log(Status.FAIL,
                    "Expected validated value of the key is :: " + ActualValue + " , Actual validated value of the key is :: " + ExpectedValue);
        } catch (Exception e) {
            test.log(Status.FAIL, e.fillInStackTrace());
        }
    }
  }

