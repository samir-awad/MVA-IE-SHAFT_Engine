package Directdebits;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.Settings;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC185_ValidateRedirectingToVestaPageAfterClickingOnUseThisCardButton {

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
        String username = users.getTestData("TC181_BillPayCredentialsUser_DirectDebit.username");
        String password = users.getTestData("TC181_BillPayCredentialsUser_DirectDebit.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }


    //TC185 -  Check redirect to Vesta page after click "Use this card" button
    @Test
    public void RedirectToVestPageToUseSavedCard() {
        HomePage.pressAccountTrayMenuOption();
        Verifications.verifyTrue(HomePage.CheckAccountOverlaySettingText());
    }

    @Test
    public void step2() {
        HomePage.pressAccountSettingOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkAccountSettingsText());
    }

    @Test
    public void step3() {
        SettingsPage.pressPaymentMethodOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        ElementActions.performTouchAction(driver).tap(BillsPaymentsPage.getCreditCardAsRecurringPaymentSaved_Tab());
    }

    @Test
    public void step4() {

        BillsPaymentsPage.checkUseThisCardButton();
        BillsPaymentsPage.checkUseThisCardOverlay();
        BillsPaymentsPage.pressChangeYourCardOverlayCloseButton();
    }

    @Test
    public void step5() {
        BillsPaymentsPage.checkSavedCardsTabContent();
        BillsPaymentsPage.checkUseThisCardButton();
        BillsPaymentsPage.pressChangeYourCardOverlayNoButton();
    }

    @Test
    public void step6() {
        BillsPaymentsPage.checkSavedCardsTabContent();
        BillsPaymentsPage.checkUseThisCardButton();
        BillsPaymentsPage.pressChangeYourCardOverlayContinueButton();
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}

