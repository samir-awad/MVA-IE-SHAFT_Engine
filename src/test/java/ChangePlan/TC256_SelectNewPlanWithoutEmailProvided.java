package ChangePlan;

import Pages.ChangePlan;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC256_SelectNewPlanWithoutEmailProvided {

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

    @Test
    public void CheckThatImOnHomeScreen() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test
    public void checkEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test
    public void CheckViewOrChangeYourPlan() {
        HomePage.pressViewOrChangePlan();
        ChangePlanPage.pressYourPlanOverlayCloseButton();
    }

    @Test
    public void SelectNewPlanWithoutEmailProvided() {
        HomePage.pressViewOrChangePlan();
        ChangePlanPage.pressYourPlanOverlayChangePlanButton();
        Verifications.verifyTrue(ChangePlanPage.checkChangePlanPageHeader());
        ChangePlanPage.pressSelectPlanButton();
        // need to complete it
    }
}
