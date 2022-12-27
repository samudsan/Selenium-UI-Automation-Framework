package com.san.pages;

import com.san.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage{

    private final By textBoxUsername = By.name("username");
    private final By textBoxPassword = By.name("password");
    private final By buttonLogin = By.xpath("//button[@type='submit']");


    public OrangeHRMLoginPage enterUserName(String username) {
        sendKeys(textBoxUsername, username, WaitStrategy.PRESENSE, "username");
        return new OrangeHRMLoginPage(); //same we can achieve through return this
    }

    public OrangeHRMLoginPage enterUserPassword(String password) {
        sendKeys(textBoxPassword, password, WaitStrategy.PRESENSE, "password");
        return this;
    }

    public OrangeHRMHomepage clickLogin() {
        click(buttonLogin, WaitStrategy.CLICKABLE, "login button");
        return new OrangeHRMHomepage();
    }

    public boolean isLandedLoginPage(){
        return isLandedCorrectPage(textBoxUsername, WaitStrategy.PRESENSE);
    }
}
