package com.san.pages;

import com.san.driver.Driver;
import com.san.enums.WaitStrategy;
import com.san.factories.ExplicitWaitFactory;
import com.san.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {
    protected void click(By by, WaitStrategy waitStrategy, String elementname) throws Exception {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        webElement.click();
        ExtentLogger.pass("clicked on "+ elementname, true);
    }

    protected void sendKeys(By by, String str,  WaitStrategy waitStrategy, String elementname) throws Exception {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        webElement.sendKeys(str);
        ExtentLogger.pass("value " +str+" entered in "+ elementname, true);
    }

    protected String getTitle(){
        return Driver.getDriver().getTitle();
    }
}
