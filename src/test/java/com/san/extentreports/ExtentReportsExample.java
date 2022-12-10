package com.san.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReportsExample {
    @Test
    public void exampleTest() throws IOException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

        spark.config().setReportName("Automation Framework Test status");

        ExtentTest test1 = extent.createTest("First Test");
        test1.pass("Checking the logs");

        ExtentTest test2 = extent.createTest("Second Test");
        test2.fail("Checking the logs for Second Test");

        extent.flush();
        // to open the file in Desktop default browser automatically after test execution finished.
        Desktop.getDesktop().browse(new File("target/Spark.html").toURI());
    }
}
