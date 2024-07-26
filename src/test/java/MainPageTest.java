import org.example.CreateIndustry;
import org.example.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class MainPageTest extends TestBase {
    @Before
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }

    @Test
    public void createIndustryTest() throws InterruptedException {
        CreateIndustry createIndustry1 = mainPage.createIndustry();
        String text = createIndustry1.getTextButton();
        Assert.assertEquals("Save", text);
        createIndustry.inputIndustryName("Industry_AutoTest");
        createIndustry.inputIndustryDescription("Description");
        createIndustry.selectLeadType();
        createIndustry.pressButtonSave();
        createIndustry.addFeatureToIndustry();
        createIndustry.pressAddFeatureButton();
        createIndustry.inputFeatureName("NewFeature1");
        createIndustry.pressButtonSave();
        Assert.assertTrue(createIndustry.checkResultPhrase());
        mainPage.chooseIndustryFromMenu();
        Thread.sleep(3000);
        mainPage.selectIndustryName("Industry_AutoTest");
        Thread.sleep(3000);
        mainPage.deleteCreatedSiteAndIndustry();
        Thread.sleep(3000);

    }

    @After
    public void TearDown() {
        webDriver.quit();
    }
}


