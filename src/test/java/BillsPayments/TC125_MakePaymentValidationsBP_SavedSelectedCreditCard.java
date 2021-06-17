package BillsPayments;

import FileReaders.jsonReader;
import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC125_MakePaymentValidationsBP_SavedSelectedCreditCard {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("SavedCC.username"), jsonReader.getPassword("SavedCC.password")).acceptPermissions();
    }

    @Test
    public void MakePaymentValidationsBP_SavedSelectedCreditCard() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        HomePage.pressBillsPaymentsTrayMenuOption();
        BillsPaymentsPage.pressMakeAPaymentButton();
        Verifications.verifyTrue(BillsPaymentsPage.checkMakeAPaymentOverlayHeader());
        Verifications.verifyTrue(BillsPaymentsPage.checkMakeAPaymentOverlayFirstBill());
        Verifications.verifyTrue(BillsPaymentsPage.checkMakeAPaymentOverlayAmountField());
        Verifications.verifyTrue(BillsPaymentsPage.checkMakeAPaymentOverlayPaymentMethod());
        BillsPaymentsPage.pressMakePaymentButton();
        Assertions.assertElementAttribute(driver, BillsPaymentsPage.getVestaField(), "text", "Name on Card");

    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
