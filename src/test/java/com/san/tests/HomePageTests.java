package com.san.tests;


import com.san.constants.FrameworkConstants;
import com.san.driver.Driver;
import com.san.utils.ReadPropertyFile;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public final class HomePageTests extends BaseTest{

    private HomePageTests() {
    }

    // let us assume we have to validate Title contains amazon, title is not null, not empty, contains letters >5 and less 100 etc.
    @Test
    public void test1WithoutAssertJ() throws Exception {
        Driver.getDriver().get(ReadPropertyFile.getValue("url"));
        String title  = Driver.getDriver().getTitle();
        System.out.println("our Title is : "+title);

        Assert.assertTrue(title.contains("Amazon"));
        Assert.assertTrue(title != null && !title.isEmpty());
        Assert.assertTrue(title.length() > 10);
        Assert.assertTrue(title.length() < 100);
    }


    @Test
    public void test2WithAssertJ() throws Exception {
        Driver.getDriver().get(ReadPropertyFile.getValue("url"));
        String title  = Driver.getDriver().getTitle();
        System.out.println("our Title is : "+title);

        Assertions.assertThat(title)
                .contains("Amazon")
                .isNotNull()
                .isNotEmpty()
                .hasSizeGreaterThan(5)
                .hasSizeLessThan(100);
    }
}
