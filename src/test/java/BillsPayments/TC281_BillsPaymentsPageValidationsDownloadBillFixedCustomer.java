package BillsPayments;

import FileReaders.jsonReader;
import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC281_BillsPaymentsPageValidationsDownloadBillFixedCustomer {

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
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("FixedUser.username"), jsonReader.getPassword("FixedUser.password")).acceptPermissions();
    }

    @Test
    public void BillsPaymentsPageValidationsDownloadBillFixedCustomer() {
        HomePage.pressNextBillTile();
        BillsPaymentsPage.checkBillsPaymentsHeader();
        BillsPaymentsPage.pressCloseButtonInBillsPaymentsView();
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        HomePage.pressBillsPaymentsTrayMenuOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkBillsPaymentsHeader());
        BillsPaymentsPage.pressDownloadBillButton();
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
