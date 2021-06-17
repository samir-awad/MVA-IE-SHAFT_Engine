package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC246_AccessSelectAddOnsToRemoveBillPayUser {
    private MobileDriver driver;
    private JSONFileManager users;
    private Home HomePage;
    private AddOns AddOnsPage;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
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
    public void CheckAccessToAddOnsPage() {
        HomePage.opedAddOnsOverlay();
        AddOnsPage.openAddOnsPage();
        Assertions.assertElementAttribute(driver, AddOnsPage.getAddOnsHeader_text(),
                "text", "Buy add ons", "Check add ons page is loaded");
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection", "CheckAccessToAddOnsPage"})
    public void CheckAccessToSelectAddOns() {
        AddOnsPage.openManageAddOnsOverlay();
        Assertions.assertElementAttribute(driver, AddOnsPage.getManageAddOnsOverlayHeader_text(),
                "text", "Select add ons to remove", "checking manage add ons header");
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
