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

public class TC289_PagevalidationsForFixedUserWithCreditCardAsRecurringPayment {


    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    private Settings SettingsPage;

    @BeforeClass
    public void beforeClass() {
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        SettingsPage = new Settings(driver);
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
    }

    @Test
    public void CreditCardAsRecurringPayment() {
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
