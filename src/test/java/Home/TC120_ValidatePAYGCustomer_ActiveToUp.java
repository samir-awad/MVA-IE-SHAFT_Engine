package Home;

import FileReaders.jsonReader;
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
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("PAYGVoucher.username"), jsonReader.getPassword("PAYGVoucher.password")).acceptPermissions();
    }

    @Test
    public void CheckThatImOnHome() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckThatImOnHome")
    public void CheckActiveTopupIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getActiveToUp());
    }

    @Test(dependsOnMethods = "CheckActiveTopupIsDisplayed")
    public void CheckBalanceTileIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getBalanceTitle());
    }

    @Test(dependsOnMethods = "CheckBalanceTileIsDisplayed")
    public void CheckTopUpHistoryTileIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getTopUpHistoryTile());
    }

    @Test(dependsOnMethods = "CheckTopUpHistoryTileIsDisplayed")
    public void CheckDiscoverySection() {
        HomePage.checkDiscoverySection();
    }

    @Test(dependsOnMethods = "CheckDiscoverySection")
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = "CheckEssentialsSection")
    public void CheckOtherUsefulToolsSection() {
        HomePage.checkOtherUsefulToolsSection();
    }

    @Test(dependsOnMethods = "CheckOtherUsefulToolsSection")
    public void CheckTopupInTrayMenu() {
        Assertions.assertElementExists(driver, HomePage.getPAYG_Tray());
    }
}
