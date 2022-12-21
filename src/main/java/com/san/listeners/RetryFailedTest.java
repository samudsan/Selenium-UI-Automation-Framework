package com.san.listeners;

import com.san.enums.ConfigProperties;
import com.san.utils.ReadPropertyFileUtils;
import lombok.SneakyThrows;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;
    private int retryCount = 1;

    @SneakyThrows
    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean retryFlag = false;
        if(ReadPropertyFileUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            retryFlag = count < retryCount;
            count++;
        }
        return retryFlag;
    }
}
