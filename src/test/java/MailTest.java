import Pages.ComposePage;
import Pages.InboxPage;
import Pages.MainPage;
import Pages.SendMsgOkPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailTest {
    private static WebDriver driver;

    @BeforeClass
    public static void start(){
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sendLetter(){
        MainPage mainPage = new MainPage(driver);
        InboxPage inboxPage = new InboxPage(driver);
        ComposePage composePage = new ComposePage(driver);
        SendMsgOkPage sendMsgOkPage = new SendMsgOkPage(driver);

        mainPage.openMainPage();
        mainPage.login();
        inboxPage.createNewLetter();
        composePage.writeAndSendTestLetter();
        Assert.assertTrue(sendMsgOkPage.isMessageSent());
    }
}
