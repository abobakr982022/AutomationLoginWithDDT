package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    public static WebDriver driver;

    public LogoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void Logout() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.linkText("Log out")).click();
        Thread.sleep(1000);
    }
    public boolean IsEnabled(){
        return driver.findElement(By.linkText("Log out")).isDisplayed();
    }

    public String InvalidValidation(){
        return driver.findElement(By.id("error")).getText();
    }
    public boolean ValidateLogoutURL(){
        return driver.getCurrentUrl() == "https://practicetestautomation.com/logged-in-successfully/";
    }

}
