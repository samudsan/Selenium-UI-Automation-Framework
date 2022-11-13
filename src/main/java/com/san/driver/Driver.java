package com.san.driver;

import com.san.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static ThreadLocal<WebDriver> threadLocalDriver =  new ThreadLocal<>();

    public static void  inItDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
        threadLocalDriver.set(new ChromeDriver());
        getDriver().get("https://www.adp.com");
    }
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void quitDriver(){
        getDriver().quit();
    }
}
