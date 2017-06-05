package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InboxPage {
    WebDriver driver;
    public InboxPage(WebDriver driver){
        this.driver = driver;
    }

    public void createNewLetter(){
        driver.findElement(By.linkText("Написать письмо")).click();
    }
}
