package Account;

import Pages.Account;
import Pages.Home;
import Pages.Login;
import Pages.Logout;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC107_CheckOurPrivacyLinkAndLogoutButtonRedirectsForBillPay {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Account AccountPage;
    private Logout LogoutPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AccountPage = new Account(driver);
        LogoutPage = new Logout(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void CheckOurPrivacyLinkAndLogoutButtonRedirectsForBillPay() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountOverlay());
        AccountPage.pressOurPrivacyLink();
        Verifications.verifyElementExists(driver, AccountPage.getCheckOurPrivacyHeaderWithCloseButton());
        AccountPage.pressCloseButtonInPrivacy();
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountOverlay());
        LogoutPage.pressLogoutButton();
        Verifications.verifyElementExists(driver, LogoutPage.getCheckLogoutOverlay());
        LogoutPage.pressLogoutNoButton();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountOverlay());
        LogoutPage.pressLogoutButton();
        Verifications.verifyElementExists(driver, LogoutPage.getCheckLogoutOverlay());
        LogoutPage.pressLogoutYesButton();
        Assertions.assertElementExists(driver, LoginPage.getLoginVf_Logo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
