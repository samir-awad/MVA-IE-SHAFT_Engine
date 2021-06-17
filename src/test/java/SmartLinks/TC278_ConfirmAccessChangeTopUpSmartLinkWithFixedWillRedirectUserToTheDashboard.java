package SmartLinks;

import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC278_ConfirmAccessChangeTopUpSmartLinkWithFixedWillRedirectUserToTheDashboard {
    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SmartLinks SmartLinksPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        SmartLinksPage = new SmartLinks(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath") + "smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessChangeTopUpSmartLinkBeforeLogin() {
        String changeTopUpURL = links.getTestData("ChangeTopUp.link");
        SmartLinksPage.accessSmartLink(changeTopUpURL);
        String username = users.getTestData("FixedUser.username");
        String password = users.getTestData("FixedUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckAccessChangeTopUpSmartLinkBeforeLogin")
    public void CheckAccessChangeTopUpSmartLinkAfterLogin() {
        String changeTopUpURL = links.getTestData("ChangeTopUp.link");
        SmartLinksPage.accessSmartLink(changeTopUpURL);
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
