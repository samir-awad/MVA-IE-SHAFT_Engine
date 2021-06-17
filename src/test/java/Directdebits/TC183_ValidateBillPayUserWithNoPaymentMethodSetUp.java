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

public class TC183_ValidateBillPayUserWithNoPaymentMethodSetUp {

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


    //TC183 - Page validations for a Bill Pay user with no payment method set up
    @Test
    public void DirectDebitWithNoPaymentMethodSetUp() {
        Verifications.verifyTrue(HomePage.checkDirectDebitTile());
    }

    @Test
    public void step2() {
        HomePage.pressDirectDebitTile();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        BillsPaymentsPage.checkNoPaymentMethodText();
        BillsPaymentsPage.checkThatAccountOlderAndIbanAreNotFilled();
    }

    @Test
    public void step3() {
        BillsPaymentsPage.pressSavedCardsTab();
        BillsPaymentsPage.checkThatNoneOfTheCardsAreSavedAsRecurringPayment();
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}

