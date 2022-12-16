package com.san.pages;

import com.san.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage{

    private final By textBoxUsername = By.name("username");
    private final By textBoxPassword = By.name("password");
    private final By buttonLogin = By.xpath("//button[@type='submit']");


    public OrangeHRMLoginPage enterUserName(String username) throws Exception {
        sendKeys(textBoxUsername, username, WaitStrategy.PRESENSE, "username");
        return new OrangeHRMLoginPage(); //same we can achieve through return this
    }

    public OrangeHRMLoginPage enterUserPassword(String password) throws Exception {
        sendKeys(textBoxPassword, password, WaitStrategy.PRESENSE, "password");
        return this;
    }

    public OrangeHRMHomepage clickLogin() throws Exception {
        click(buttonLogin, WaitStrategy.CLICKABLE, "login button");
        return new OrangeHRMHomepage();
    }

    public boolean isLandedLoginPage(){
        return isLandedCorrectPage(textBoxUsername, WaitStrategy.PRESENSE);
    }
}
