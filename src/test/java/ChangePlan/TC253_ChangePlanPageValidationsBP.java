package ChangePlan;

import Pages.BillsPayments;
import Pages.ChangePlan;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC253_ChangePlanPageValidationsBP {


    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private ChangePlan ChangePlanPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        ChangePlanPage = new ChangePlan(driver);
    }

    @Test
    public void Login() {
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
    }

    @Test(dependsOnMethods = "Login")
    public void CheckThatImOnHomeScreen() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckThatImOnHomeScreen")
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = "CheckEssentialsSection")
    public void CheckChangePlanOverlay() {
        HomePage.pressViewOrChangePlan();
        Verifications.verifyTrue(ChangePlanPage.checkYourPlanOverlay());
        ChangePlanPage.pressYourPlanOverlayCloseButton();
    }

    @Test(dependsOnMethods = "CheckChangePlanOverlay")
    public void CheckCurrentPlanOverlay() {
        HomePage.pressViewOrChangePlan();
        ChangePlanPage.pressYourPlanOverlayChangePlanButton();
        Verifications.verifyTrue(ChangePlanPage.checkChangePlanPageHeader());
        ChangePlanPage.pressViewCurrentPlanDetails();
        //Verifications.verifyTrue(ChangePlanPage.checkCurrentPlanDetailsOverlay());
        ChangePlanPage.pressPlanDetailsOverlayCloseButton();
    }

    @Test(dependsOnMethods = "CheckCurrentPlanOverlay")
    public void CheckAvailablePlanDetailsOverlay() {
        // ChangePlanPage.pressViewAvailablePlansDetails();
        ChangePlanPage.checkAvailablePlanDetailsOverlay();
        ChangePlanPage.pressPlanDetailsOverlayCloseButton_2();
        ChangePlanPage.changeFromBillPayPlansToSimOnlyPlans();
        ChangePlanPage.pressCloseButton();
    }
}
