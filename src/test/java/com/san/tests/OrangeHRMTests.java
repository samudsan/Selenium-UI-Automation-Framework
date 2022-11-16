package com.san.tests;

import com.san.pages.OrangeHRMLoginpage;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest{
    private  OrangeHRMTests() {
    }

    @Test
    public void loginTest(){
        OrangeHRMLoginpage loginPage = new OrangeHRMLoginpage();
        loginPage.enterUserName("admin").enterUserpassword("admin123").clickLogin();
    }
}
