package TopUp;

import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC158_ValidateMoreOptionsOverlayPAYGUser {
    private MobileDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private TopUp TopUpPage;


    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        TopUpPage = new TopUp(driver);
    }

    @Test
    public void Login() {
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("PAYGUserWithTopUp.username");
        String password = users.getTestData("PAYGUserWithTopUp.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test(dependsOnMethods = "Login")
    public void CheckVodafoneLogoAndWelcomeGesture() {
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckMoreOptionsOverlay() {
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayMoreOptionsButton();
        Assertions.assertElementExists(driver, TopUpPage.getTopUpOverlayHeader_text());
    }

    @Test(dependsOnMethods = "CheckMoreOptionsOverlay")
    public void ValidateMoreOptionsOverlayBackBtn() {
        TopUpPage.pressMoreOptionsOverlayBackButton();
        Assertions.assertElementExists(driver, HomePage.getTopUpOverlayTitle_text());
    }

    @Test(dependsOnMethods = "ValidateMoreOptionsOverlayBackBtn")
    public void ValidateMoreOptionsOverlayCloseBtn() {
        TopUpPage.pressTopUpOverlayCloseButton();
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
