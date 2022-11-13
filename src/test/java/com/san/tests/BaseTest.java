package com.san.tests;

import com.san.constants.FrameworkConstants;
import com.san.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.inItDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
