package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC022_ValidateBillPayCustomer {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
    }

    @Test
    public void LoginWithBillPayUser() {
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("BillPayUserWithWebText.username"), jsonReader.getPassword("BillPayUserWithWebText.password")).acceptPermissions();
    }

    @Test(dependsOnMethods = "LoginWithBillPayUser")
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
        Verifications.verifyElementExists(driver, HomePage.getDirectDebitTile());
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

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
