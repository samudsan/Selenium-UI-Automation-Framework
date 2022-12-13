package com.san.tests;

import com.san.pages.OrangeHRMHomepage;
import com.san.pages.OrangeHRMLoginpage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class OrangeHRMTests extends BaseTest{
    private  OrangeHRMTests() {
    }

    @Test(dataProvider = "loginDataProvider")
    public void loginTest(Map<String, String> map) throws Exception {
        OrangeHRMLoginpage loginPage = new OrangeHRMLoginpage();
        boolean landedHomePage = loginPage.enterUserName(map.get("username"))
                .enterUserpassword(map.get("password")).clickLogin().isLandedHomePage();
        Assertions.assertThat(landedHomePage).isTrue();

    }

    @Test()
    public void logoutTest() throws Exception {
        OrangeHRMLoginpage loginPage = new OrangeHRMLoginpage();
        OrangeHRMHomepage homepage = loginPage.enterUserName("admin").enterUserpassword("admin123").clickLogin();
        boolean landedLoginPage = homepage.clickWelcome().clickLogout().isLandedLoginPage();
        Assertions.assertThat(landedLoginPage).isTrue();
    }


    @DataProvider(name="loginDataProvider", parallel = true)
    private Object[] loginDataProvider() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("testdata_login");
        int row = sheet.getLastRowNum();
        System.out.println("row = " + row);
        int colomn = sheet.getRow(0).getLastCellNum();
        Object[] data =   new Object[row];
        Map<String, String> map;

        for (int i=1; i<=row; i++){
            map = new HashMap<>();
            for (int j=0; j<colomn; j++){
                System.out.println("row:column = " + i+":"+j);
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i-1] = map;
            }
        }
        return data;
    }
}
