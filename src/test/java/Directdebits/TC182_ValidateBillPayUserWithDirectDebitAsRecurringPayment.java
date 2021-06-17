package Directdebits;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.Settings;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC182_ValidateBillPayUserWithDirectDebitAsRecurringPayment {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    private Settings SettingsPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        SettingsPage = new Settings(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("TC182_BillPayCredentialsUser_DirectDebit.username");
        String password = users.getTestData("TC182_BillPayCredentialsUser_DirectDebit.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }


    //TC182 - Page validations for a Bill Pay user with Direct Debit as recurring payment
    @Test
    public void DirectDebitAsRecurringPayment() {
        Verifications.verifyElementExists(driver, HomePage.getDirectDebit_Tab(), Verifications.VerificationType.NEGATIVE);
    }

    @Test
    public void step2() {
        HomePage.pressAccountTrayMenuOption();
        Assertions.assertTrue(HomePage.CheckAccountOverlaySettingText());
    }

    @Test
    public void step3() {
        HomePage.pressAccountSettingOption();
        Assertions.assertTrue(BillsPaymentsPage.checkAccountSettingsText());
    }

    @Test
    public void step4() {
        SettingsPage.pressPaymentMethodOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        Verifications.verifyTrue(BillsPaymentsPage.checkCreditCardAsRecurringPaymentText());
        Assertions.assertTrue(BillsPaymentsPage.checkThatAccountOlderAndIbanAreFilled());
    }

    @Test
    public void step5() {
        BillsPaymentsPage.pressSavedCardsTab();
        Verifications.verifyTrue(BillsPaymentsPage.checkThatNoneOfTheCardsAreSavedAsRecurringPayment());
    }
}

