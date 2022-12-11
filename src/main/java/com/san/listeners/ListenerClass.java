package com.san.listeners;

import com.san.reports.ExtentLogger;
import com.san.reports.ExtentReport;
import org.testng.*;

import java.io.IOException;

public class ListenerClass  implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) { throw new RuntimeException(e);}
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentReport.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentLogger.pass("Test Method "+iTestResult.getMethod().getMethodName() + " is Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentLogger.fail("Test Method "+iTestResult.getMethod().getMethodName() + " is Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentLogger.skip("Test Method "+iTestResult.getMethod().getMethodName() + " is Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
