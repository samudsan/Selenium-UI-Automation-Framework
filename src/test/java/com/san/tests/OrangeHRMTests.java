package com.san.tests;

import com.san.pages.OrangeHRMHomepage;
import com.san.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest{
    private  OrangeHRMTests() {
    }

    @Test(dataProvider = "loginDataProvider")
    public void loginTest(String username, String password) throws Exception {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        boolean landedHomePage = loginPage.enterUserName(username)
                .enterUserPassword(password).clickLogin().isLandedHomePage();
        Assertions.assertThat(landedHomePage).isTrue();

    }

    @Test(dataProvider = "loginDataProvider")
    public void logoutTest(String username, String password) throws Exception {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        OrangeHRMHomepage homepage = loginPage.enterUserName(username).enterUserPassword(password).clickLogin();
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
