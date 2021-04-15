package Android.ChangePlan;

import Pages.ChangePlan;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC254_SelectNewPlanAndProceedWithAnOutOfContract {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private ChangePlan ChangePlanPage;
    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        ChangePlanPage=new ChangePlan(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }
    @Test
    public void SelectNewPlanAndProceedWithAnOutOfContract(){
        Verifications.verifyTrue(HomePage.checkTheVodafoneLogo());
        Verifications.verifyTrue(HomePage.checkEssentialsSection());
        HomePage.pressViewOrChangePlan();
        ChangePlanPage.pressYourPlanOverlayCloseButton();
        HomePage.pressViewOrChangePlan();
        ChangePlanPage.pressYourPlanOverlayChangePlanButton();
        Verifications.verifyTrue(ChangePlanPage.checkChangePlanPageHeader());
        ChangePlanPage.pressSelectPlanButton();
        ChangePlanPage.pressViewSelectedPlansDetails();
        ChangePlanPage.pressPlanDetailsOverlayCloseButton_2();


    }
}
