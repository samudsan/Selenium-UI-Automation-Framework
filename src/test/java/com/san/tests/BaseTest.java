package com.san.tests;

import com.san.driver.Driver;
import com.san.enums.ConfigProperties;
import com.san.utils.ReadPropertyFileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() {
    }


    @BeforeMethod
    public void setUp() throws Exception {
        Driver.inItDriver(ReadPropertyFileUtils.getValue(ConfigProperties.BROWSER));
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
