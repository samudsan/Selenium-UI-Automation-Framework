package com.san.constants;

import com.san.enums.ConfigProperties;
import com.san.utils.ReadPropertyFileUtils;

import java.time.Duration;

public final class FrameworkConstants {  // final because we do not want anybody to extend this class.

    private FrameworkConstants() { // to avoid creating objects for this class. as it just having static member we can access it by class name.
    }

    private static final Duration EXPLICITWAIT = Duration.ofSeconds(10);
    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
    private static final String CONFIGPROPERTYFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private static final String EXTENTREPORTPATH = System.getProperty("user.dir")+"/extent-test-output";

    private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String EXCELPATH = RESOURCEPATH+"/testdata/testdata.xlsx";
    private static final String loginDataSheetName = "testdata_login";
    private static final String runManagerSheetName = "RunManager";


    public static String getExtentreportpath() throws Exception{
        if(ReadPropertyFileUtils.getValue(ConfigProperties.OVERRIDEREPORT).equalsIgnoreCase("yes"))
            return EXTENTREPORTPATH+"/"+"index.html";
        else
            return EXTENTREPORTPATH+"/"+System.currentTimeMillis()+"index.html";

    }
    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }

    public static String getConfigPropertyFilePath(){
        return CONFIGPROPERTYFILEPATH;
    }

    public static Duration getExplicitwait(){
        return EXPLICITWAIT;
    }

    public static String getExcelpath(){
        return EXCELPATH;
    }

    public static String getLoginDataSheetName(){
        return loginDataSheetName;
    }

    public static String getRunManagerSheetName(){
        return runManagerSheetName;
    }
}
