package com.san.tests;

import com.san.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
