package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC119_ValidatePAYGCustomer_InactiveToUp {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("PAYGUserWithoutAddOns.username"), jsonReader.getPassword("PAYGUserWithoutAddOns.password")).acceptPermissions();
    }

    @Test
    public void CheckImOnHome() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        Assertions.assertElementExists(driver, HomePage.getInactiveToUp());
        Assertions.assertElementExists(driver, HomePage.getBalanceTitle());
        Assertions.assertElementExists(driver, HomePage.getTopUpHistoryTile());
        HomePage.checkDiscoverySection();
        HomePage.checkEssentialsSection();
        HomePage.checkOtherUsefulToolsSection();
        Assertions.assertElementExists(driver, HomePage.getPAYG_Tray());
    }

//    @Test(dependsOnMethods = "CheckImOnHome")
//    public void CheckInactiveTopup() {
//
//    }
//
//    @Test(dependsOnMethods = "CheckInactiveTopup")
//    public void CheckBalanceTile() {
//
//    }
//
//    @Test(dependsOnMethods = "CheckBalanceTile")
//    public void CheckTopUpHistoryTile() {
//
//    }
//
//    @Test(dependsOnMethods = "CheckTopUpHistoryTile")
//    public void checkDiscoverySection() {
//
//    }
//
//    @Test(dependsOnMethods = "checkDiscoverySection")
//    public void checkEssentialsSection() {
//
//    }
//
//    @Test(dependsOnMethods = "checkEssentialsSection")
//    public void checkOtherUsefulToolsSection() {
//
//    }
//
//    @Test(dependsOnMethods = "CheckTopupInTrayMenu")
//    public void CheckTopupInTrayMenu() {
//
//    }
}
