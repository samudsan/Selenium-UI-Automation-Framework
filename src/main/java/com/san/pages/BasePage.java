package com.san.pages;

import com.san.enums.WaitStrategy;
import com.san.factories.ExplicitWaitFactory;
import com.san.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {
    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        webElement.click();
        ExtentLogger.pass("clicked on "+ elementName, true);
    }

    protected void sendKeys(By by, String str,  WaitStrategy waitStrategy, String elementName)  {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        webElement.sendKeys(str);
        ExtentLogger.pass("value " +str+" entered in "+ elementName, true);
    }

    // usually we validate tests with pageTitle, but for our site OrangeHRM, seems all page's titles are same. So below validation is done.

    protected boolean isLandedCorrectPage(By by, WaitStrategy waitStrategy){
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        return webElement != null;
    }
}
