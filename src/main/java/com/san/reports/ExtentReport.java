package com.san.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extentReports;

    public static void initReports(){
        if(Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
            extentReports.attachReporter(spark);
            spark.config().setReportName("Automation Framework Test status");
        }
    }

    public static void flushReports() throws IOException {
        if(Objects.nonNull(extentReports)){
            extentReports.flush();
            // to open the file in Desktop default browser automatically after test execution finished.
            Desktop.getDesktop().browse(new File("target/Spark.html").toURI());
        }
    }

    public static void createTest(String testCaseName){
        ExtentTest test = extentReports.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }
}
