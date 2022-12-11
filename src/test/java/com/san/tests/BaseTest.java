package com.san.tests;

import com.san.driver.Driver;
import com.san.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    protected BaseTest() {
    }


    @BeforeMethod
    public void setUp() throws Exception {
        Driver.inItDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
