package com.san.pages;

import com.san.driver.Driver;
import com.san.enums.WaitStrategy;
import com.san.reports.ExtentManager;
import com.san.reports.ExtentReport;
import org.openqa.selenium.By;

public final class OrangeHRMHomepage extends BasePage{

    private final By link_welcome = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By link_logout =  By.xpath("//a[contains(text(), 'Logout')]");

    public OrangeHRMHomepage clickWelcome(){
        click(link_welcome, WaitStrategy.CLICKABLE);
        ExtentManager.getExtentTest().pass("clicked on link_welcome");
        return this;
    }

    public OrangeHRMLoginpage clickLogout(){
        click(link_logout, WaitStrategy.CLICKABLE);
        ExtentManager.getExtentTest().pass("clicked on link_logout");
        return new OrangeHRMLoginpage();
    }

    public String getTittle(){
        return Driver.getDriver().getTitle();
    }
}
