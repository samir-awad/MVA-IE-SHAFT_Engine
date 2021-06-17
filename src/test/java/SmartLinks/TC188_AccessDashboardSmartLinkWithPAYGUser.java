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

public class TC188_AccessDashboardSmartLinkWithPAYGUser {
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
    public void CheckAccessDashboardSmartLinkBeforeLogin() {
        String DashboardLink = links.getTestData("Dashboard.link");
        SmartLinksPage.accessSmartLink(DashboardLink);
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.login(username, password).acceptPermissionsPAYGUser();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckAccessDashboardSmartLinkBeforeLogin")
    public void CheckAccessDashboardSmartLinkAfterLogin() {
        String DashboardLink = links.getTestData("Dashboard.link");
        SmartLinksPage.accessSmartLink(DashboardLink);
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
