package com.san.listeners;

import com.san.annotation.FrameworkAnnotation;
import com.san.reports.ExtentLogger;
import com.san.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class ListenerClass  implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
            ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite iSuite) {
            ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //ExtentReport.createTest(iTestResult.getMethod().getMethodName());
        ExtentReport.createTest(iTestResult.getMethod().getDescription());
        ExtentReport.addAuthors(iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategory(iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentLogger.pass("Test Method "+iTestResult.getMethod().getMethodName() + " is Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentLogger.fail("Test Method "+iTestResult.getMethod().getMethodName() + " is Failed",true);
        ExtentLogger.fail(iTestResult.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(iTestResult.getThrowable().getStackTrace()));
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
