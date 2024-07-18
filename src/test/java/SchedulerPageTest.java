import org.example.CreateIndustry;
import org.example.SchedulerPage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.example.MainPage;

public class SchedulerPageTest extends TestBase {
    @Before
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }

    @Test
    public void createDeliveryScheduler() throws InterruptedException {
        mainPage.chooseFromMenu();
        mainPage.chooseScheduler();
        Thread.sleep(3000);
        schedulerPage.inputFilterIndustry("IMN Dating");
        Thread.sleep(3000);
        schedulerPage.findMessageToSent("Roman Test");
        Thread.sleep(3000);
        SchedulerPage schedulerPage1 = schedulerPage.newDelivery();
        Thread.sleep(3000);
    /*    String text = schedulerPage1.getTextSchedulerSite();
        Assert.assertEquals("sites", text);*/
        Thread.sleep(3000);
        schedulerPage.activateCheckBoxRetentionUsers();
        Thread.sleep(3000);
        schedulerPage.inputSiteName("PlentyOfFlirt (AOS) Mob pure.pentfli.click");
        Thread.sleep(3000);
        //      schedulerPage.choosePeriodForRuleScheduler();
        Thread.sleep(3000);
        schedulerPage.chooseTimeForRule();
        Thread.sleep(3000);
        String text = schedulerPage1.getTextSchedulerSite();
        Assert.assertEquals("sites", text);
        Thread.sleep(3000);
        schedulerPage.creationNewPush();
        Thread.sleep(5000);
        Assert.assertTrue(schedulerPage.checkRuleCreateCorrect());
        Thread.sleep(5000);
    }

    @After
    public void TearDown() {
        webDriver.quit();
    }
}
