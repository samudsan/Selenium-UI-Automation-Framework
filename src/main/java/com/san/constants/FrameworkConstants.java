package com.san.constants;

import org.openqa.selenium.json.JsonOutput;

import java.time.Duration;

public final class FrameworkConstants {  // final because we do not want anybody to extend this class.

    private FrameworkConstants() { // to avoid creating objects for this class. as it just having static member we can access it by class name.
    }

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
    private static final String CONFIGPROPERTYFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    private static final Duration EXPLICITWAIT = Duration.ofSeconds(10);
    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }

    public static String getConfigPropertyFilePath(){
        return CONFIGPROPERTYFILEPATH;
    }

    public static Duration getExplicitwait(){
        return EXPLICITWAIT;
    }


}
