package com.san.pages;

import com.san.driver.Driver;
import com.san.enums.WaitStrategy;
import com.san.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {
    protected void click(By by, WaitStrategy waitStrategy){
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        webElement.click();
    }

    protected void sendKeys(By by, String str,  WaitStrategy waitStrategy){
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        webElement.sendKeys(str);
    }

    protected String getTitle(){
        return Driver.getDriver().getTitle();
    }
}
