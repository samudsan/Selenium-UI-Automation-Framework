package com.san.listeners;

import org.testng.annotations.*;

public class Runner {
    @BeforeSuite
    public void setupSuite(){
        System.out.println("Before Suite from Runner");
    }

    @AfterSuite
    public void tearDownSuite(){
        System.out.println("After Suite from Runner");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Before Method from Runner");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method from Runner");
    }

    @Test
    public void Test1(){
        System.out.println("Test Method 1");
    }

    @Test
    public void Test2(){
        System.out.println("Test Method 2");
    }

    @Test
    public void Test3(){
        System.out.println("Test Method 3");
    }
}
