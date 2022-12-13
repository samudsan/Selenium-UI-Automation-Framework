package com.san.utils;

import com.san.driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
    private ScreenshotUtils(){}

    public static String getBase64Image(){
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
