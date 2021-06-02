package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC057_ValidateAddOnsOverlayBillPayUserWithMonthlyAddOns {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsOverlayText() {
        HomePage.opedAddOnsOverlay();
        Assertions.assertElementExists(driver, AddOnsPage.getAddOnsExpiresOverlay_text());
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection", "ValidateAddOnsOverlayText"})
    public void ValidateAddOnsOverlayCloseButton() {
        AddOnsPage.closeAddOnsOverlay();
        Assertions.assertElementExists(driver, HomePage.getEssentials_text());
    }

}
