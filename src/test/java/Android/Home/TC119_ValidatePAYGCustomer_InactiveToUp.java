package Android.Home;

import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC119_ValidatePAYGCustomer_InactiveToUp {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }
    @Test
    public void ValidatePAYGCustomer_InactiveToUp(){
        Verifications.verifyElementExists(driver,HomePage.getCheckTheVodafoneLogo());
        Verifications.verifyTrue(HomePage.checkTopUpOfferTileInactiveTopUp());
        Verifications.verifyTrue(HomePage.checkBalanceTile());
        Verifications.verifyTrue(HomePage.checkTopUpHistoryTile());
        Verifications.verifyTrue(HomePage.checkDiscoverySection());
        Verifications.verifyTrue(HomePage.checkEssentialsSection());
        Verifications.verifyTrue(HomePage.checkOtherUsefulToolsSection());
        Assertions.assertTrue(HomePage.checkTrayMenuOptionsForPayg());

    }
}
