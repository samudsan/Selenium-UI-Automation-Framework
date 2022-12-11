package com.san.pages;

import com.san.enums.WaitStrategy;
import com.san.reports.ExtentLogger;
import com.san.reports.ExtentManager;
import com.san.reports.ExtentReport;
import org.openqa.selenium.By;

public final class OrangeHRMLoginpage extends BasePage{

    private By textbox_username = By.name("username");
    private By textbox_password = By.name("password");
    private By button_login = By.xpath("//button[@type='submit']");


    public OrangeHRMLoginpage enterUserName(String username){
        sendKeys(textbox_username, username, WaitStrategy.PRESENSE);
        ExtentLogger.pass("entered UserName");
        return new OrangeHRMLoginpage(); //same we can achieve through return this
    }

    public OrangeHRMLoginpage enterUserpassword(String password){
        sendKeys(textbox_password, password, WaitStrategy.PRESENSE);
        ExtentLogger.pass("entered password");
        return this;
    }

    public OrangeHRMHomepage clickLogin() throws Exception {
        click(button_login, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Clicked Login");
        return new OrangeHRMHomepage();
    }


}
