package Directdebits;

import FileReaders.jsonReader;
import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.Settings;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC291_PageValidationsForFixedUserWithNoPaymentMethodSetup {
    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    private Settings SettingsPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        SettingsPage = new Settings(driver);
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName(""), jsonReader.getPassword("")).acceptPermissions();
    }

    @Test
    public void DirectDebitWithNoPaymentMethodSetUp() {
        Verifications.verifyTrue(HomePage.checkDirectDebitTile());
        HomePage.pressDirectDebitTile();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        BillsPaymentsPage.checkNoPaymentMethodText();
        BillsPaymentsPage.checkThatAccountOlderAndIbanAreNotFilled();
        BillsPaymentsPage.pressSavedCardsTab();
        BillsPaymentsPage.checkThatNoneOfTheCardsAreSavedAsRecurringPayment();
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
