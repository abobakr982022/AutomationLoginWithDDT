package TCs;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class TC_Login_CSVFile extends Base {
    Base base = new Base();
    LoginPage loginPage = new LoginPage(base.driver);
    LogoutPage logoutPage = new LogoutPage(base.driver);
    CSVReader csvReader ;
//    @DataProvider(name = "loginDDT")
//    public static Object[][] Cradintals(){
//        return new Object[][]{
//                {"student","Password123"},{"Password123","student"}
//        };
//    }

    @Test()
    public void T1_Login() throws InterruptedException, IOException, CsvValidationException, URISyntaxException {
        System.out.println(System.getProperty("user.dir"));
       String csvfile= System.getProperty("user.dir")+"\\Files\\logindata.csv";
        //File file = new File(getClass().getResource("Files/logindata.csv").toURI());
        csvReader = new CSVReader(new FileReader(csvfile));
        String[] csvcells;
        while ((csvcells=csvReader.readNext())!=null){
            String username = csvcells[0];
            String password = csvcells[1];
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
}
