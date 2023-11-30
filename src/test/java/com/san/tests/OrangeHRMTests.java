package com.san.tests;

import com.san.annotation.FrameworkAnnotation;
import com.san.enums.CategoryType;
import com.san.pages.OrangeHRMHomepage;
import com.san.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest{
    private  OrangeHRMTests() {
    }
    @FrameworkAnnotation(author = {"Sandeep", "Dileep"}, category = CategoryType.ACCEPTANCE)
    @Test
    public void loginTest(Map<String, String> data ) {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        boolean landedHomePage = loginPage.enterUserName(data.get("username"))
                .enterUserPassword(data.get("password")).clickLogin().isLandedHomePage();
        Assertions.assertThat(landedHomePage).isTrue();
    }

    @FrameworkAnnotation(category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test
    public void logoutTest(Map<String, String> data)  {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        OrangeHRMHomepage homepage = loginPage.enterUserName(data.get("username")).enterUserPassword(data.get("password")).clickLogin();
        boolean landedLoginPage = homepage.clickWelcome().clickLogout().isLandedLoginPage();
        Assertions.assertThat(landedLoginPage).isTrue();
    }

}
