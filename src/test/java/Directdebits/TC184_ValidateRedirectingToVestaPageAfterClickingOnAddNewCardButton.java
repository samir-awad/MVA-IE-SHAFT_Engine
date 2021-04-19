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

public class TC184_ValidateRedirectingToVestaPageAfterClickingOnAddNewCardButton {

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


    //TC184 -  Check redirect to Vesta page after click "Add new card" button
    @Test

    public void RedirectToVestPageToAddNewCard() {
        Verifications.verifyTrue(HomePage.checkDirectDebitTile());
        HomePage.pressDirectDebitTile();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
        BillsPaymentsPage.pressSavedCardsTab();
        BillsPaymentsPage.pressAndNewCardButton();
        Verifications.verifyTrue(BillsPaymentsPage.checkAddNewCardOverlay());
        BillsPaymentsPage.pressAddNewCardOverlayCloseButton();
        BillsPaymentsPage.pressAndNewCardButton();
        BillsPaymentsPage.pressAddNewCardOverlayNoButton();
        BillsPaymentsPage.pressAddNewCardOverlayCloseButton();
        BillsPaymentsPage.pressAddNewCardOverlayContinueButton();



    }
}

