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

public class TC186_ValidateWhenTheIbanIsInvalid {

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
        String username = users.getTestData("IMEI-EligibleAccountBillPayUser.username");
        String password = users.getTestData("IMEI-EligibleAccountBillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();

    }


    //TC186 - Check input validation when the IBAN is invalid
    @Test
    public void InvalidIbanErrorMessage() {
        HomePage.pressDirectDebitTile();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
    }

    @Test
    public void step2() {
        BillsPaymentsPage.insertAccountHolderAndInvalidIban();
        BillsPaymentsPage.checkErrorMessageForInvalidIban();
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}

