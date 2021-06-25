package com.ml.api.metrixapi;

import com.aventstack.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

   static ExtentReports extent=ExtentReporterNg.extentReportGenerator();
    static ExtentTest test;

    @Override
    public void onTestStart( ITestResult result ) {
        test=extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess( ITestResult result ) {




    }

    public void onTestFailure( ITestResult result) {
             test.fail(result.getThrowable());
////        WebDriver driver=null;
//        String testMethodName=result.getMethod().getMethodName();
//        test=extent.createTest(result.getMethod().getMethodName());

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    public void onFinish( ITestContext context) {
        extent.flush();
    }

}
