package BillsPayments;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC122_BillsPaymentsValidationBP {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage=new BillsPayments(driver);
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }
    @Test
    public void Bills_PaymentsValidateBP(){

        Verifications.verifyElementExists(driver,HomePage.getCheckTheVodafoneLogo());;
        Verifications.verifyTrue(HomePage.checkTrayMenuOptionsForBillPay());
        HomePage.pressBillsPaymentsTrayMenuOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkBillsPaymentsHeader());
        BillsPaymentsPage.pressCloseButtonInBillsPaymentsView();
        HomePage.pressBillsPaymentsTrayMenuOption();

    }

}
