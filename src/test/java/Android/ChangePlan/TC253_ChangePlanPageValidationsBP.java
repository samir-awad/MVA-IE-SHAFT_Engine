package Android.ChangePlan;

import Pages.BillsPayments;
import Pages.ChangePlan;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.cucumber.java.nl.Stel;
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
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        ChangePlanPage=new ChangePlan(driver);
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }
    @Test
    public void ChangePlanPageValidationsBP(){
        Verifications.verifyElementExists(driver,HomePage.getCheckTheVodafoneLogo());
        Verifications.verifyTrue(HomePage.checkEssentialsSection());
        HomePage.pressViewOrChangePlan();
        Verifications.verifyTrue(ChangePlanPage.checkYourPlanOverlay());
        ChangePlanPage.pressYourPlanOverlayCloseButton();
        HomePage.pressViewOrChangePlan();
        ChangePlanPage.pressYourPlanOverlayChangePlanButton();
        Verifications.verifyTrue(ChangePlanPage.checkChangePlanPageHeader());
        ChangePlanPage.pressViewCurrentPlanDetails();
      //  Verifications.verifyTrue(ChangePlanPage.checkCurrentPlanDetailsOverlay());
        ChangePlanPage.pressPlanDetailsOverlayCloseButton();
       // ChangePlanPage.pressViewAvailablePlansDetails();
        ChangePlanPage.checkAvailablePlanDetailsOverlay();
        ChangePlanPage.pressPlanDetailsOverlayCloseButton_2();
        ChangePlanPage.changeFromBillPayPlansToSimOnlyPlans();
        ChangePlanPage.pressCloseButton();


    }
}
