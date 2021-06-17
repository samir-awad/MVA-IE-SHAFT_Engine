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

public class TC159_ValidateAutoTopUpPagePAYGUser {
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
    public void CheckSetAutoTopUpOptionPage() {
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayMoreOptionsButton();
        TopUpPage.pressMoreOptionsOverlaySetAutoTopUpOption();
        Verifications.verifyElementExists(driver, TopUpPage.getAutoTopUpPageHeader_text());
        Assertions.assertElementExists(driver, TopUpPage.getAutoTopUpPageMyNumber_text());
    }

    @Test(dependsOnMethods = "CheckSetAutoTopUpOptionPage")
    public void ValidateSetAutoTopUpOptionPageBackBtn() {
        TopUpPage.pressAutoTopUpBackButton();
        Assertions.assertElementExists(driver, TopUpPage.getTopUpOverlayHeader_text());
    }

    @Test(dependsOnMethods = "ValidateSetAutoTopUpOptionPageBackBtn")
    public void ValidateSetAutoTopUpOptionPageCancelBtn() {
        TopUpPage.pressMoreOptionsOverlaySetAutoTopUpOption();
        TopUpPage.pressCancelBtn();
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
