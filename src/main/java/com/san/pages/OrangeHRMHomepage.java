package com.san.pages;

import com.san.driver.Driver;
import org.openqa.selenium.By;

public final class OrangeHRMHomepage {

    private final By link_welcome = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By link_logout =  By.xpath("//a[contains(text(), 'Logout')]");

    public OrangeHRMHomepage clickWelcome(){
        Driver.getDriver().findElement(link_welcome).click();
        return this;
    }

    public OrangeHRMLoginpage clickLogout(){
        Driver.getDriver().findElement(link_logout).click();
        return new OrangeHRMLoginpage();
    }
}
