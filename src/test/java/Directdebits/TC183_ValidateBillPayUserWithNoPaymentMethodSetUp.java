package Directdebits;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.Settings;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC183_ValidateBillPayUserWithNoPaymentMethodSetUp {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    private Settings SettingsPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        SettingsPage = new Settings(driver);
       // LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
    }


    //TC183 - Page validations for a Bill Pay user with no payment method set up
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
}
