package Home;

import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC120_ValidatePAYGCustomer_ActiveToUp {

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
    public void CheckThatImOnHome() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test
    public void CheckActiveTopupIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getActiveToUp());
    }

    @Test
    public void CheckBalanceTileIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getBalanceTitle());
    }

    @Test
    public void CheckTopUpHistoryTileIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getTopUpHistoryTile());
    }

    @Test
    public void CheckDiscoverySection() {
        HomePage.checkDiscoverySection();
    }

    @Test
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test
    public void CheckOtherUsefulToolsSection() {
        HomePage.checkOtherUsefulToolsSection();
    }

    @Test
    public void CheckTopupInTrayMenu() {
        Assertions.assertElementExists(driver, HomePage.getPAYG_Tray());
    }
}
