package com.san.pages;

import com.san.constants.FrameworkConstants;
import com.san.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected void click(By by){
        Driver.getDriver().findElement(by).click();
    }

    protected void sendKeys(By by, String str){
        Driver.getDriver().findElement(by).sendKeys(str);
    }

    protected void explictWait(By by){
        new WebDriverWait(Driver.getDriver(), FrameworkConstants.getExplicitwait())
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
