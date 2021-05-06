package Directdebits;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.Settings;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC185_ValidateRedirectingToVestaPageAfterClickingOnUseThisCardButton {

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
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("TC181_BillPayCredentialsUser_DirectDebit.username");
        String password = users.getTestData("TC181_BillPayCredentialsUser_DirectDebit.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }


    //TC185 -  Check redirect to Vesta page after click "Use this card" button
    @Test
    public void RedirectToVestPageToUseSavedCard() {

        HomePage.pressAccountTrayMenuOption();
        Verifications.verifyTrue(HomePage.CheckAccountOverlaySettingText());
        HomePage.pressAccountSettingOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkAccountSettingsText());
        SettingsPage.pressPaymentMethodOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        BillsPaymentsPage.checkUseThisCardButton();
        BillsPaymentsPage.checkUseThisCardOverlay();
        BillsPaymentsPage.pressChangeYourCardOverlayCloseButton();
        BillsPaymentsPage.checkSavedCardsTabContent();
        BillsPaymentsPage.checkUseThisCardButton();
        BillsPaymentsPage.pressChangeYourCardOverlayNoButton();
        BillsPaymentsPage.checkSavedCardsTabContent();
        BillsPaymentsPage.checkUseThisCardButton();
        BillsPaymentsPage.pressChangeYourCardOverlayContinueButton();



    }
}

