package TCs;

import Data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class TC_Login_FileProperties extends Base {
    Base base = new Base();
    LoginPage loginPage = new LoginPage(base.driver);
    LogoutPage logoutPage = new LogoutPage(base.driver);

//    @DataProvider(name = "loginDDT")
//    public static Object[][] Cradintals(){
//        return new Object[][]{
//                {"student","Password123"},{"Password123","student"}
//        };
//    }
    String username = LoadProperties.loginData.getProperty("Username");
    String password = LoadProperties.loginData.getProperty("password");



    @Test()
    public void T1_Login() throws InterruptedException {

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
