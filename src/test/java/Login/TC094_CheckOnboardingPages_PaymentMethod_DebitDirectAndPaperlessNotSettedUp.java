package Login;

import FileReaders.jsonReader;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC094_CheckOnboardingPages_PaymentMethod_DebitDirectAndPaperlessNotSettedUp {

    private MobileDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Check_And_Accept_And_Continue_In_Terms_And_Conditions() {
        Assertions.assertElementExists(driver, LoginPage.getTermsAndConditions_Header());
        LoginPage.acceptTermsAndConditions();
    }

    @Test(dependsOnMethods = {"Check_And_Accept_And_Continue_In_Terms_And_Conditions"})
    public void Check_That_Im_On_Registration_And_Login_Page() {
        Assertions.assertElementExists(driver, LoginPage.getVodafone_Logo(), "I'm on Register And Login Page");

    }

    @Test(dependsOnMethods = {"Check_That_Im_On_Registration_And_Login_Page"})
    public void LoginAndCheckThatAmOnOnboardingPage() {
        LoginPage.login(jsonReader.getUserName("IE.username"), jsonReader.getPassword("IE.password"));
        Assertions.assertElementExists(driver, LoginPage.getLetsGo_Button());
        ElementActions.performTouchAction(driver).tap(LoginPage.getLetsGo_Button());
    }

    @Test(dependsOnMethods = {"LoginAndCheckThatAmOnOnboardingPage"})
    public void CheckYourPrivacyIsDisplayed() {
        Assertions.assertElementExists(driver, LoginPage.getPrivacyContinue_button());
        ElementActions.performTouchAction(driver).tap(LoginPage.getPrivacyContinue_button());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
