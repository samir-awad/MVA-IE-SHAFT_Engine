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

public class TC162_SubmitInvalidVoucherNumberPAYGUser {
    private MobileDriver driver;
    private JSONFileManager users;
    private JSONFileManager vouchers;
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
        vouchers = new JSONFileManager(System.getProperty("testDataFolderPath") + "vouchers.json");
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
        TopUpPage.pressMoreOptionsOverlayTopUpWithVoucherOption();
        Assertions.assertElementExists(driver, TopUpPage.getChooseTheNumber_text());
    }

    @Test(dependsOnMethods = "CheckMoreOptionsOverlay")
    public void GetInvalidVoucher() {
        String phoneNumber = users.getTestData("PAYGUserTopup.username");
        String invalidVoucher = vouchers.getTestData("InvalidVoucherPAYGUser.voucher");
        TopUpPage.submitInvalidVoucher(phoneNumber, invalidVoucher);
    }

    @Test(dependsOnMethods = "GetInvalidVoucher")
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
