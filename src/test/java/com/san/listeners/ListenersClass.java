package com.san.listeners;

import org.testng.*;

public class ListenersClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("Before Suite in Listeners class");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("After Suite in Listeners class");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Before method in Listeners class");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("after method in Listeners class: pass");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("after method in Listeners class: fail and I'm attaching screenshots here");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("after method in Listeners class: test skipper or ignored.");
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
