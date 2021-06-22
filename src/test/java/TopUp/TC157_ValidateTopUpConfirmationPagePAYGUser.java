package TopUp;

import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC157_ValidateTopUpConfirmationPagePAYGUser {
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
    public void CheckTopUpPage() {
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayTopUpButton();
        Assertions.assertElementExists(driver, TopUpPage.getTopUpHeader_text());
    }

    @Test(dependsOnMethods = "CheckTopUpPage")
    public void ValidateConfirmationPage() {
        TopUpPage.pressNextBtn();
        Verifications.verifyElementExists(driver, TopUpPage.getTopUpHeader_text());
        Verifications.verifyElementExists(driver, TopUpPage.getConfirmYourTopUpDetails());
    }

    @Test(dependsOnMethods = "ValidateConfirmationPage")
    public void ValidateCloseButton() {
        TopUpPage.pressCloseBtn();
        Verifications.verifyElementExists(driver, HomePage.getBalanceTitle());
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
