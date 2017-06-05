package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposePage {
    WebDriver driver;
    private String mailAdress = "sizov-d@mail.ru";
    private String theme = "Test";
    private String content = "Hello World!";

    public ComposePage(WebDriver driver){
        this.driver = driver;
    }

    public void writeAndSendTestLetter(){
        driver.findElement(By.xpath("//div/textarea[2]")).sendKeys(mailAdress);
        driver.findElement(By.xpath("//div[1]/div/div[3]/div[4]/div/div/div[2]/div/input")).sendKeys(theme);
        WebElement element = driver.findElement(By.xpath("//div[contains(@class, 'compose__toolbar-external defaultSkin')]"));
        String idDefaultSkin = element.getAttribute("Id");
        String idPage = idDefaultSkin.substring(8, 23);
        String idFrame = "toolkit-" + idPage + "composeEditor_ifr";
        driver.switchTo().frame(driver.findElement(By.id(idFrame)));
        driver.findElement(By.id("tinymce")).click();
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys(content);
        driver.findElement(By.id("tinymce")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
        driver.switchTo().defaultContent();
    }
}
