package com.san.pages;

import com.san.constants.FrameworkConstants;
import com.san.driver.Driver;
import com.san.enums.WaitStrategy;
import com.san.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected void click(By by, WaitStrategy waitStrategy){
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        webElement.click();
    }

    protected void sendKeys(By by, String str,  WaitStrategy waitStrategy){
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        webElement.sendKeys(str);
    }
}
