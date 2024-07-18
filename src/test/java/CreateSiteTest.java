import org.example.CreateIndustry;
import org.example.CreateSite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateSiteTest extends TestBase {
    @Before
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }

    @Test
    public void createSiteTest() throws InterruptedException {
        mainPage.chooseCreateSiteFromMenu();
        mainPage.chooseSiteForCreateFromMenu();
        Thread.sleep(2000);
        CreateSite createSite1 = createSite.createSite();
        Thread.sleep(2000);
        String text3 = createSite1.getTextCancel();
        Assert.assertEquals("Cancel", text3);
        Thread.sleep(5000);
        createSite.inputSiteIndustry("IMN Dating")
                .selectSiteType()
                .inputSiteName("NewMobileSiteTest23")
                .inputDomainNew("testapp4")
                .inputTrackDomainNew("testapp4")
                .inputCdnDomainNew("testapp4")
                .clickSaveButton();
        Thread.sleep(3000);
        Assert.assertTrue(createSite.checkResultPhrase());
        createSite.changeTab();
        Thread.sleep(3000);
        createSite.activateCheckboxEnabledPushNotifications()
                //.activateCheckboxBackLink()
                .inputPushApplication("Joker Lucky Wheel")
                .clickSaveButton();
        Thread.sleep(3000);
        Assert.assertTrue(createSite.checkResultPhrase());
        Thread.sleep(3000);
        mainPage.chooseSiteForCreateFromMenu();
        Thread.sleep(3000);
        mainPage.selectSiteName("NewMobileSiteTest23")
                .clickSubmitButton();
        Assert.assertTrue(mainPage.checkFinalResultCreateMobileAppSite());
    }

    @After
    public void TearDown() {
        webDriver.quit();
    }

}
