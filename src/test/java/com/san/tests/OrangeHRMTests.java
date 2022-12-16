package com.san.tests;

import com.san.pages.OrangeHRMHomepage;
import com.san.pages.OrangeHRMLoginpage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest{
    private  OrangeHRMTests() {
    }

    @Test(dataProvider = "loginDataProvider")
    public void loginTest(String username, String password) throws Exception {
        OrangeHRMLoginpage loginPage = new OrangeHRMLoginpage();
        boolean landedHomePage = loginPage.enterUserName(username)
                .enterUserpassword(password).clickLogin().isLandedHomePage();
        Assertions.assertThat(landedHomePage).isTrue();

    }

    @Test(dataProvider = "loginDataProvider")
    public void logoutTest(String username, String password) throws Exception {
        OrangeHRMLoginpage loginPage = new OrangeHRMLoginpage();
        OrangeHRMHomepage homepage = loginPage.enterUserName(username).enterUserpassword(password).clickLogin();
        boolean landedLoginPage = homepage.clickWelcome().clickLogout().isLandedLoginPage();
        Assertions.assertThat(landedLoginPage).isTrue();
    }


    @DataProvider(name="loginDataProvider", parallel = true)
    public Object[][] loginDataProvider() {
        //return ExcelUtils.getTestData("testdata_login");
        return new Object[][]{
                {"Admin", "admin123"}
        };
    }

}
