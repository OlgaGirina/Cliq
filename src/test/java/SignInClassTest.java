import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MainPage;
import org.example.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import java.time.Duration;

public class SignInClassTest {

    WebDriver webDriver;
    private SignInPage signInPage;
    static WebDriverWait wait;
    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        webDriver.get("http://short:short@cliq-backend-master.sb.cliqonline.com");
        signInPage = new SignInPage(webDriver);
    }
    @Test
    public void signInTest(){
        MainPage mainpage = signInPage.SignInSuccessful();
        String heading = mainpage.getText();
        Assert.assertEquals("CLIQ Admin", heading);
    }
    @After
    public void TearDown(){
        webDriver.quit();
    }
}
