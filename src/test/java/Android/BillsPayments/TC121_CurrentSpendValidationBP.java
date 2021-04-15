package Android.BillsPayments;

import Pages.AddOns;
import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import com.shaft.cli.FileActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC121_CurrentSpendValidationBP {

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
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }
    @Test
    public void ValidateCurrentSpendBP(){

        Verifications.verifyTrue(HomePage.checkTheVodafoneLogo());
        Verifications.verifyTrue(HomePage.checkNextBillTile());
        HomePage.pressNextBillTile();
        Verifications.verifyTrue(BillsPaymentsPage.checkCurrentSpendOverlay());
        BillsPaymentsPage.pressViewBillsAndPaymentsButton();
        Assertions.assertTrue(BillsPaymentsPage.checkBillsPaymentsHeader());

    }

}
