package OtherUsefulTools;

import Pages.Home;
import Pages.Login;
import Pages.OtherUsefulTools;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC260_CheckNACRequestPagesAndTheReturnedErrorToasterUsingIMEIFromNotEligibleAccountWithBillPayUser {
    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private OtherUsefulTools OtherUsefulToolsPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        OtherUsefulToolsPage = new OtherUsefulTools(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("TC183_BillPayCredentialsUser_DirectDebit.username");
        String password = users.getTestData("TC183_BillPayCredentialsUser_DirectDebit.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void checkTheVodafoneLogo() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = {"checkTheVodafoneLogo"})
    public void checkOtherUsefulToolsSection() {
        HomePage.checkOtherUsefulToolsSection();
        ElementActions.performTouchAction(driver).tap(HomePage.getDevicesAndSim_button());
    }

    @Test(dependsOnMethods = {"checkOtherUsefulToolsSection"})
    public void pressNacRequestOption() {
        HomePage.pressNacRequestOption();
        OtherUsefulToolsPage.checkNacFewThingsFirstPageContent();

    }

    @Test(dependsOnMethods = {"pressNacRequestOption"})
    public void pressNacFewThingsFirstContinueButton() {
        OtherUsefulToolsPage.pressNacFewThingsFirstContinueButton();
        OtherUsefulToolsPage.checkNacRequestWithDevicePageContent();
    }

    @Test(dependsOnMethods = {"pressNacFewThingsFirstContinueButton"})
    public void checkErrorMessageAndThatNacRequestContinueButtonStillDisabled() {
        OtherUsefulToolsPage.addAnInvalidImei();
        OtherUsefulToolsPage.checkErrorMessageAndThatNacRequestContinueButtonStillDisabled();

    }

    @Test(dependsOnMethods = {"checkErrorMessageAndThatNacRequestContinueButtonStillDisabled"})
    public void checkGenericErrorToasterAndErrorTextIsReturned() {
        OtherUsefulToolsPage.clearTheNACRequestInput();
        OtherUsefulToolsPage.addAValidImeiButNotExistingInTheSystem();
        OtherUsefulToolsPage.checkErrorMessageAndThatNacRequestContinueButtonStillDisabled();

    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}

