package com.san.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;
    private int retryCount = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean retryFlag = count < retryCount;
        count++;
        return retryFlag;
    }
}
