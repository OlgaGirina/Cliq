import org.example.CreateIndustry;
import org.example.CreateSite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
                .inputSiteName("NewMobileSiteTest")
                .inputDomainNew("autoTest.cliq-track-master.sb.cliqonline.com")
                .inputTrackDomainNew("autoTest.cliq-track-master.sb.cliqonline.com")
                .inputCdnDomainNew("autoTest.cliq-track-master.sb.cliqonline.com")
                .clickSaveButton();
        Thread.sleep(5000);
        assertTrue(createSite.checkResultPhrase());
        createSite.changeTab();
        Thread.sleep(3000);
        createSite.activateCheckboxEnabledPushNotifications()
                //.activateCheckboxBackLink()
                .inputPushApplication("Joker Lucky Wheel")
                .clickSaveButton();
        Thread.sleep(3000);
        assertTrue(createSite.checkResultPhrase());
        Thread.sleep(3000);
        mainPage.chooseSiteForCreateFromMenu();
        Thread.sleep(3000);
        mainPage.selectSiteName("NewMobileSiteTest")
                .clickSubmitButton();
        assertTrue(mainPage.checkFinalResultCreateMobileAppSite());
        Thread.sleep(3000);
        mainPage.deleteCreatedSiteAndIndustry();
    }

    @After
    public void TearDown() {
        webDriver.quit();
    }

}
