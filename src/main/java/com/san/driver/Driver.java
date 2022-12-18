package com.san.driver;

import com.san.constants.FrameworkConstants;
import com.san.enums.ConfigProperties;
import com.san.utils.ReadPropertyFileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private final static ThreadLocal<WebDriver> threadLocalDriver =  new ThreadLocal<>();

    public static void  inItDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
        threadLocalDriver.set(new ChromeDriver());
        getDriver().get(ReadPropertyFileUtils.getValue(ConfigProperties.URL));
    }
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void quitDriver(){
        getDriver().quit();
    }
}
