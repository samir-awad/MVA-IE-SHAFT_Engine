package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC056_ValidateAddOnsOverlayBillPayUserWithoutMonthlyAddOns {
    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUserWithoutAddOns.username");
        String password = users.getTestData("BillPayUserWithoutAddOns.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsOverlayText() {
        HomePage.opedAddOnsOverlay();
        Verifications.verifyElementExists(driver, AddOnsPage.getNoActiveAddOnsOverlay_text());
        Assertions.assertElementAttribute(driver, AddOnsPage.getNoActiveAddOnsOverlay_text(),
                "text", "You have no active add ons.",
                Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "ValidateAddOnsOverlayText")
    public void ValidateAddOnsOverlayCloseButton() {
        AddOnsPage.closeAddOnsOverlay();
        Assertions.assertElementExists(driver, HomePage.getEssentials_text());
    }


}
