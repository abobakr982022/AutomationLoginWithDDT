package TCs;

import Data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

import java.io.IOException;

public class TC_Login_Excel extends Base {
    Base base = new Base();
    LoginPage loginPage = new LoginPage(base.driver);
    LogoutPage logoutPage = new LogoutPage(base.driver);

    @DataProvider(name = "loginDDTExcel")
    public static Object[][] Cradintalsfromexcel() throws IOException {
//        return new Object[][]{
//                {"student","Password123"},{"Password123","student"}
//        };
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelData();

    }

    @Test(dataProvider = "loginDDTExcel")
    public void T1_Login(String username,String password) throws InterruptedException {
        System.out.println(new LoginPage(base.driver));
        System.out.println(new LogoutPage(base.driver));
        loginPage.Login(username,password);
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().equalsIgnoreCase("https://practicetestautomation.com/logged-in-successfully/")){
            logoutPage.Logout();
        }
        else Assert.assertEquals(logoutPage.InvalidValidation(),"Your username is invalid!");
        Thread.sleep(1000);
    }
}
