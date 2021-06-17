package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC023_TutorialValidationsBillPayCustomer {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
    }

    @Test
    public void AcceptTermsAndConditionsAndLogin() {
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("BillPayUser.username"), jsonReader.getPassword("BillPayUser.password"));
    }

    @Test(dependsOnMethods = "AcceptTermsAndConditionsAndLogin")
    public void AcceptPermissionsAndGoToTutorialFromHome() {
        LoginPage.acceptPermissions();
        Assertions.assertElementExists(driver, HomePage.getTakeQuickTour_Tile());
        ElementActions.performTouchAction(driver).tap(HomePage.getTakeQuickTour_Tile());
        Assertions.assertElementExists(driver, LoginPage.getSkip_button());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
