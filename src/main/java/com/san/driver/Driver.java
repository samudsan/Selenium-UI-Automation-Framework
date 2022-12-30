package com.san.driver;

import com.san.constants.FrameworkConstants;
import com.san.enums.ConfigProperties;
import com.san.utils.ReadPropertyFileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class Driver {

    private final static ThreadLocal<WebDriver> threadLocalDriver =  new ThreadLocal<>();

    public static void  inItDriver(String browser) {
        if (Objects.isNull(getDriver())){
            if(browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                threadLocalDriver.set(new ChromeDriver());
            }

            else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                threadLocalDriver.set(new FirefoxDriver());
            }
         }

        getDriver().get(ReadPropertyFileUtils.getValue(ConfigProperties.URL));
    }
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void quitDriver(){
        getDriver().quit();
    }
}
