package com.san.tests;

import com.san.driver.Driver;
import com.san.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    protected BaseTest() {
    }


    @BeforeSuite
    public void beforeSuite(){
        ExtentReport.initReports();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        Driver.inItDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReport.flushReports();
    }
}
