package com.san.pages;

import com.san.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class OrangeHRMHomepage extends BasePage{

    private final By link_welcome = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By link_logout =  By.xpath("//a[contains(text(), 'Logout')]");

    public OrangeHRMHomepage clickWelcome(){
        explictWait(link_welcome);
        click(link_welcome);
        return this;
    }

    public OrangeHRMLoginpage clickLogout(){
        click(link_logout);
        return new OrangeHRMLoginpage();
    }
}
