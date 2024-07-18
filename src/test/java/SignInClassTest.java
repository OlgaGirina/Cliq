import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MainPage;
import org.example.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import java.time.Duration;

public class SignInClassTest extends TestBase {

    @Test
    public void signInTest(){
        MainPage mainpage = signInPage.SignInSuccessful("olga", "Dimapovrez123");
        String heading = mainpage.getText();
        Assert.assertEquals("CLIQ Admin", heading);
    }
    @After
    public void TearDown(){
        webDriver.quit();
    }
}
