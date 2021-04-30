package TopUp;

import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC158_ValidateMoreOptionsOverlayPAYGUser {
    private WebDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private TopUp TopUpPage;


    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        TopUpPage = new TopUp(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("PAYGUserWithTopUp.username");
        String password = users.getTestData("PAYGUserWithTopUp.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test

    public void CheckVodafoneLogoAndWelcomeGesture() {
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckMoreOptionsOverlay() {
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayMoreOptionsButton();
        Assertions.assertElementExists(driver, TopUpPage.getMoreOptionOverlayHeader_text());
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
}
