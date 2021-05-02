package Home;

import Pages.ChangePlan;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC022_ValidateBillPayCustomer {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
    }

    @Test
    public void CheckVodafoneLogoIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoIsDisplayed")
    public void CheckBillTileIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getBillTile());
    }

    @Test(dependsOnMethods = "CheckBillTileIsDisplayed")
    public void CheckAmountDueTileIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getAmountDueTile());
    }

    @Test(dependsOnMethods = "CheckAmountDueTileIsDisplayed")
    public void CheckDirectDebitIsDisplayed() {
        Assertions.assertElementExists(driver, HomePage.getDirectDebitTile());
    }

    @Test(dependsOnMethods = "CheckDirectDebitIsDisplayed")
    public void CheckDiscoverySectionIsDisplayed() {
        HomePage.checkDiscoverySection();
    }

    @Test(dependsOnMethods = "CheckDiscoverySectionIsDisplayed")
    public void CheckEssentialsSectionIsDisplayed() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = "CheckEssentialsSectionIsDisplayed")
    public void CheckOtherUsefulToolsSectionIsDisplayed() {
        HomePage.checkOtherUsefulToolsSection();
    }

    @Test(dependsOnMethods = "CheckOtherUsefulToolsSectionIsDisplayed")
    public void CheckTrayMenuOptionsForBillPay() {
        Assertions.assertElementExists(driver, HomePage.getBillAndPayment());

    }
}
