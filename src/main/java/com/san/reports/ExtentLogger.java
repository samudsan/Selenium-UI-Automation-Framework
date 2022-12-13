package com.san.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.san.enums.ConfigProperties;
import com.san.utils.ReadPropertyFileUtils;
import com.san.utils.ScreenshotUtils;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }

    public static void pass(String message, boolean isScreanshotneeded) throws Exception {
        if(ReadPropertyFileUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreanshotneeded)
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        else
            pass(message);
    }

    public static void fail(String message, boolean isScreanshotneeded) throws Exception {
        if(ReadPropertyFileUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreanshotneeded)
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        else
            fail(message);
    }

    public static void skip(String message, boolean isScreanshotneeded) throws Exception {
        if(ReadPropertyFileUtils.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreanshotneeded)
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        else
            skip(message);
    }
}
