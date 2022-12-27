package com.san.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.san.constants.FrameworkConstants;
import com.san.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {}

    private static ExtentReports extentReports;
    private static final String extentReportPath;

    static {
        extentReportPath = FrameworkConstants.getExtentreportpath();
    }

    public static void initReports() {
        if(Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(extentReportPath);
            extentReports.attachReporter(spark);
            spark.config().setReportName("Automation Framework Test status");
        }
    }

    public static void flushReports() {
        if(Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        ExtentManager.unload();
        // to open the file in Desktop default browser automatically after test execution finished.
        try {
            Desktop.getDesktop().browse(new File(extentReportPath).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTest(String testCaseName){
        ExtentTest test = extentReports.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }

    public static void addAuthors(String[] authors){
        for(String author:authors) {
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategory(CategoryType[] categories){
        for (CategoryType category: categories) {
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }
}
