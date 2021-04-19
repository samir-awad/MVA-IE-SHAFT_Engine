package Directdebits;

import Pages.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TC181_ValidateBillPayUserWithCreditCardAsRecurringPayment {

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
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
    }


    //TC181 - Page validations for a Bill Pay user with Credit Card as recurring payment
    @Test
    public void CreditCardAsRecurringPayment() {
        //Assertions.assertElementExists(driver,HomePage.getDirectDebit_Tab(),Assertions.AssertionType.NEGATIVE);
        Verifications.verifyElementExists(driver,HomePage.getDirectDebit_Tab(),Verifications.VerificationType.NEGATIVE);
        HomePage.pressAccountTrayMenuOption();
        Verifications.verifyTrue(HomePage.CheckAccountOverlaySettingText());
        HomePage.pressAccountSettingOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkAccountSettingsText());
        SettingsPage.pressPaymentMethodOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        BillsPaymentsPage.pressCloseButtonInBillsPaymentsView();
        Verifications.verifyTrue(HomePage.checkTheVodafoneLogo());
        HomePage.pressAccountTrayMenuOption();
        HomePage.pressAccountSettingOption();
        SettingsPage.pressPaymentMethodOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkCreditCardAsRecurringPaymentText());
        Verifications.verifyTrue(BillsPaymentsPage.checkTheTwoExistingTabs());
        BillsPaymentsPage.pressDirectDebitTab();


    }
}

