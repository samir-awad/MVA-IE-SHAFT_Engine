package TopUp;

import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC162_SubmitInvalidVoucherNumberPAYGUser {

    private WebDriver driver;
    private JSONFileManager users;
    private JSONFileManager vouchers;
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
        vouchers = new JSONFileManager(System.getProperty("testDataFolderPath") + "vouchers.json");
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
        TopUpPage.pressMoreOptionsOverlayTopUpWithVoucherOption();
        Assertions.assertElementExists(driver, TopUpPage.getChooseTheNumber_text());
    }

    @Test(dependsOnMethods = "CheckMoreOptionsOverlay")
    public void CheckInsertingInvalidVoucherCode() {
        //Can't be implemented until have PAYG user with subscription and the following code is not working as expected
        String phoneNumber = users.getTestData("PAYGUserTopup.username");
        String invalidVoucher = vouchers.getTestData("InvalidVoucherPAYGUser.voucher");
        TopUpPage.submitInvalidVoucher(phoneNumber, invalidVoucher);

    }

    @Test(dependsOnMethods = "CheckInsertingInvalidVoucherCode")
    public void ValidateCloseButton() {
        TopUpPage.pressCloseBtn();
        Verifications.verifyElementExists(driver, HomePage.getBalanceTitle());
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

}
