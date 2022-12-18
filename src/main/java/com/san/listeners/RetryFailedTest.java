package com.san.listeners;

import com.san.enums.ConfigProperties;
import com.san.utils.ReadPropertyFileUtils;
import lombok.SneakyThrows;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;
    private static final int retryCount = 1;
    private boolean retryFlag = false;
    @SneakyThrows
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(ReadPropertyFileUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            boolean retryFlag = count < retryCount;
            count++;
        }
        return retryFlag;
    }
}
