package SmartLinks;

import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC096_AccessDashboardSmartLinkWithBillPayUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SmartLinks SmartLinksPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
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
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckAccessDashboardSmartLinkBeforeLogin")
    public void CheckAccessDashboardSmartLinkAfterLogin() {
        String DashboardLink = links.getTestData("Dashboard.link");
        SmartLinksPage.accessSmartLink(DashboardLink);
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

}
