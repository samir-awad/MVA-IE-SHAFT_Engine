package BillsPayments;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import com.shaft.cli.FileActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC282_MakePaymentValidationsFixedUserSavedAndSelectedCreditCard {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }

    @Test
    public void MakePaymentValidationsFixedUserSavedAndSelectedCreditCard() {
        HomePage.pressBillsPaymentsTrayMenuOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkBillsPaymentsHeader());
        BillsPaymentsPage.pressMakeAPaymentButton();
        BillsPaymentsPage.checkMakeAPaymentOverlayHeader();
        BillsPaymentsPage.checkMakeAPaymentOverlayAmountField();
        BillsPaymentsPage.checkMakeAPaymentOverlayPaymentMethod();
        BillsPaymentsPage.pressMakePaymentButton();
        Assertions.assertElementAttribute(driver, BillsPaymentsPage.getVestaField(), "text", "Name on Card");
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
