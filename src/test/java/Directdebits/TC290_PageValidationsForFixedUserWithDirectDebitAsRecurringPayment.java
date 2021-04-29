package Directdebits;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Verifications;
import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.Settings;

public class TC290_PageValidationsForFixedUserWithDirectDebitAsRecurringPayment {
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
        //  LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
    }

    @Test
    public void DirectDebitAsRecurringPayment() {
        Verifications.verifyElementExists(driver, HomePage.getDirectDebit_Tab(), Verifications.VerificationType.NEGATIVE);
    }

    @Test
    public void step2() {
        HomePage.pressAccountTrayMenuOption();
        Verifications.verifyTrue(HomePage.CheckAccountOverlaySettingText());
    }

    @Test
    public void step3() {
        HomePage.pressAccountSettingOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkAccountSettingsText());
    }

    @Test
    public void step4() {
        SettingsPage.pressPaymentMethodOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        Verifications.verifyTrue(BillsPaymentsPage.checkCreditCardAsRecurringPaymentText());
        Verifications.verifyTrue(BillsPaymentsPage.checkThatAccountOlderAndIbanAreFilled());
    }

    @Test
    public void step5() {
        BillsPaymentsPage.pressSavedCardsTab();
        Verifications.verifyTrue(BillsPaymentsPage.checkThatNoneOfTheCardsAreSavedAsRecurringPayment());
    }
}
