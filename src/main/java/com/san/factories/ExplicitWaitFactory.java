package com.san.factories;

import com.san.constants.FrameworkConstants;
import com.san.driver.Driver;
import com.san.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
        WebElement webElement;
        if (waitStrategy == WaitStrategy.CLICKABLE){
            webElement = new WebDriverWait(Driver.getDriver(), FrameworkConstants.getExplicitwait())
                    .until(ExpectedConditions.elementToBeClickable(by));
        }

        else if(waitStrategy ==  WaitStrategy.PRESENSE) {
            webElement = new WebDriverWait(Driver.getDriver(), FrameworkConstants.getExplicitwait())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }

        else if(waitStrategy ==  WaitStrategy.VISIBLE) {
            webElement = new WebDriverWait(Driver.getDriver(), FrameworkConstants.getExplicitwait())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else
            webElement = Driver.getDriver().findElement(by);
        return webElement;
    }
}
