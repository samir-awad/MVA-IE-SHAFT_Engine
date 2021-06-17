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

public class TC198_ConfirmAccessAutoTopUpSmartLinkWithBillPayWillRedirectUserToTheDashboard {
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
    public void CheckAccessYourAutoTopUpSmartLinkBeforeLogin() {
        String yourAutoTopUpURL = links.getTestData("AutoTopUp.link");
        SmartLinksPage.accessSmartLink(yourAutoTopUpURL);
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckAccessYourAutoTopUpSmartLinkBeforeLogin")
    public void CheckAccessYourAutoTopUpSmartLinkAfterLogin() {
        String yourAutoTopUpURL = links.getTestData("AutoTopUp.link");
        SmartLinksPage.accessSmartLink(yourAutoTopUpURL);
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }
}
