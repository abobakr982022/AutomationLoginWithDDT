package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void Login(String username , String password) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
    }
}
