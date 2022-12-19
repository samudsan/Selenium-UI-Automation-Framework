package com.san.driver;

import com.san.constants.FrameworkConstants;
import com.san.enums.ConfigProperties;
import com.san.utils.ReadPropertyFileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class Driver {

    private final static ThreadLocal<WebDriver> threadLocalDriver =  new ThreadLocal<>();

    public static void  inItDriver(String browser) throws Exception {
        if (Objects.isNull(getDriver()) && browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            threadLocalDriver.set(new ChromeDriver());
         }

        if (Objects.isNull(getDriver()) && browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
            threadLocalDriver.set(new FirefoxDriver());
        }
        getDriver().get(ReadPropertyFileUtils.getValue(ConfigProperties.URL));
        getDriver().get(ReadPropertyFileUtils.getValue(ConfigProperties.URL));
    }
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void quitDriver(){
        getDriver().quit();
    }
}
