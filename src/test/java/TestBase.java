import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.*;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {
    WebDriver webDriver;
    SignInPage signInPage;
    MainPage mainPage;
    CreateIndustry createIndustry;
    CreateSite createSite;
    SchedulerPage schedulerPage;
    static WebDriverWait wait;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        webDriver.get("http://short:short@cliq-backend-master.sb.cliqonline.com");

        //Set Up Pages
        signInPage = new SignInPage(webDriver);
        mainPage = new MainPage(webDriver);
        createIndustry = new CreateIndustry(webDriver);
        schedulerPage = new SchedulerPage(webDriver);
        createSite = new CreateSite(webDriver);
    }
}