package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private String url = "https://mail.ru";
    private String userLogin = "testmaillk";
    private String userPass = "Qwerty4";

    WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void openMainPage(){
        driver.get(url);
    }

    public void login(){
        driver.findElement(By.id("mailbox__login")).clear();
        driver.findElement(By.id("mailbox__login")).sendKeys(userLogin);
        driver.findElement(By.id("mailbox__password")).clear();
        driver.findElement(By.id("mailbox__password")).sendKeys(userPass);
        driver.findElement(By.id("mailbox__auth__button")).click();
    }
}
