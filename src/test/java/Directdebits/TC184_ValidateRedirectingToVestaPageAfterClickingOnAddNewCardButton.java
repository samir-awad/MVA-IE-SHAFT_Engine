package Directdebits;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.Settings;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC184_ValidateRedirectingToVestaPageAfterClickingOnAddNewCardButton {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    private Settings SettingsPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        SettingsPage = new Settings(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("TC183_BillPayCredentialsUser_DirectDebit.username");
        String password = users.getTestData("TC183_BillPayCredentialsUser_DirectDebit.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }


    //TC184 -  Check redirect to Vesta page after click "Add new card" button
    @Test
    public void RedirectToVestPageToAddNewCard() {
        Verifications.verifyTrue(HomePage.checkDirectDebitTile());
    }

    @Test
    public void step2() {
        HomePage.pressDirectDebitTile();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        BillsPaymentsPage.pressSavedCardsTab();
    }

    @Test
    public void step3() {
        BillsPaymentsPage.pressAndNewCardButton();
        Verifications.verifyTrue(BillsPaymentsPage.checkAddNewCardOverlay());
        BillsPaymentsPage.pressAddNewCardOverlayCloseButton();
    }

    @Test
    public void step4() {
        BillsPaymentsPage.pressAndNewCardButton();
        BillsPaymentsPage.pressAddNewCardOverlayNoButton();
        BillsPaymentsPage.pressAddNewCardOverlayCloseButton();
        BillsPaymentsPage.pressAddNewCardOverlayContinueButton();
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}

