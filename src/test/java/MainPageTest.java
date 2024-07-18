import org.example.CreateIndustry;
import org.example.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageTest extends TestBase {
    @Before
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }

    @Test
    public void createIndustryTest() {
        CreateIndustry createIndustry1 = mainPage.createIndustry();
        String text = createIndustry1.getTextButton();
        Assert.assertEquals("Save", text);
        createIndustry.inputIndustryName("Industry_Example8");
        createIndustry.inputIndustryDescription("Description");
        createIndustry.selectLeadType();
        createIndustry.pressButtonSave();
        createIndustry.addFeatureToIndustry();
        createIndustry.pressAddFeatureButton();
        createIndustry.inputFeatureName("NewFeature");
        createIndustry.pressButtonSave();
        Assert.assertTrue(createIndustry.checkResultPhrase());
    }

    @After
    public void TearDown() {
        webDriver.quit();
    }
}


