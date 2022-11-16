package com.san.pages;

import com.san.driver.Driver;
import org.openqa.selenium.By;

public final class OrangeHRMLoginpage {

    private By textbox_username = By.name("username");
    private By textbox_password = By.name("password");
    private By button_login = By.xpath("//button[@type='submit']");


    public OrangeHRMLoginpage enterUserName(String username){
        Driver.getDriver().findElement(textbox_username).sendKeys(username);
        return new OrangeHRMLoginpage(); //same we can achieve through return this
    }

    public OrangeHRMLoginpage enterUserpassword(String password){
        Driver.getDriver().findElement(textbox_username).sendKeys(password);
        return this;
    }

    public OrangeHRMHomepage clickLogin(){
        Driver.getDriver().findElement(button_login).click();
        return new OrangeHRMHomepage();
    }


}
