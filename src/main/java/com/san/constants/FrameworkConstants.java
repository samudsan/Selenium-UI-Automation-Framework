package com.san.constants;

import org.openqa.selenium.json.JsonOutput;

public final class FrameworkConstants {  // final because we do not want anybody to extend this class.

    private FrameworkConstants() { // to avoid creating objects for this class. as it just having static member we can access it by class name.
    }

    private final static String CHROMEDRIVERPATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
    String san = "dsfs";
    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }


}
