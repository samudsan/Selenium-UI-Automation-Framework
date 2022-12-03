package com.san.tests;

import com.san.pages.OrangeHRMHomepage;
import com.san.pages.OrangeHRMLoginpage;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest{
    private  OrangeHRMTests() {
    }

    @Test
    public void loginLogoutTest() throws Exception {
        OrangeHRMLoginpage loginPage = new OrangeHRMLoginpage();
        loginPage.enterUserName("admin").enterUserpassword("admin123").clickLogin();
    }

    @Test()
    public void logoutTest() throws Exception {
        OrangeHRMLoginpage loginPage = new OrangeHRMLoginpage();
        OrangeHRMHomepage homepage = loginPage.enterUserName("admin").enterUserpassword("admin123").clickLogin();
        Thread.sleep(5000);
        homepage.clickWelcome().clickLogout();
    }
}
