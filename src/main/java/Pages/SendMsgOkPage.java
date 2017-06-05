package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendMsgOkPage {

    WebDriver driver;

    public SendMsgOkPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isMessageSent(){
        WebElement messageSentTitle = driver.findElement(By.xpath("//*[@id=\"b-compose__sent\"]/div/div[1]/div"));
        String text = messageSentTitle.getText();
        Boolean isOk;
        if  (text.contains("отправлено"))
            isOk = true;
        else isOk = false;
        return isOk;
    }
}
