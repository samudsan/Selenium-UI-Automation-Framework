package com.san.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private final static ThreadLocal<ExtentTest> threadLocalExtentTest =  new ThreadLocal<>();

    public static void  setExtentTest(ExtentTest test){
        threadLocalExtentTest.set(test);
    }
    public static ExtentTest getExtentTest(){
        return threadLocalExtentTest.get();
    }

    public static void unload(){
        threadLocalExtentTest.remove();
    }
}
