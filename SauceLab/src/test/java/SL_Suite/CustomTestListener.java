package SL_Suite;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import SL_Resources.ExtentReportUtil;
import SL_Suite.LoginPageTest;

public class CustomTestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite finished: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test method started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
        System.out.println("Test method passed: " + result.getName());
       
        //LoginPageTest aa1=new LoginPageTest();
        //aa.test;
        // Access ExtentTest instance from the test class
        ExtentTest extentTest = ((LoginPageTest) result.getInstance()).test;

        // Log pass status using ExtentTest instance
        extentTest.pass("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test method failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test method skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }
}
