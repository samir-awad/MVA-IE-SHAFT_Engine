package SmartLinks;

import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC195_AccessAutoTopUpSmartLinkWithPAYGUser {
    private WebDriver driver;
    private Login LoginPage;
    private SmartLinks SmartLinksPage;
    private TopUp TopUpPage;
    private Home HomePage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        SmartLinksPage = new SmartLinks(driver);
        TopUpPage = new TopUp(driver);
        HomePage = new Home(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath") + "smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessAutoTopUpSmartLinkBeforeLogin() {
        String autoTopUpURL = links.getTestData("AutoTopUp.link");
        SmartLinksPage.accessSmartLink(autoTopUpURL);
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.login(username, password).acceptPermissionsPAYGUser();
        Assertions.assertElementAttribute(driver, TopUpPage.getAutoTopUpPageHeader_text(),
                "text", "Auto top up");
    }

    @Test(dependsOnMethods = "CheckAccessAutoTopUpSmartLinkBeforeLogin")
    public void CheckAutoTopUpCloseButton() {
        TopUpPage.pressCancelBtn();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckAutoTopUpCloseButton")
    public void CheckAccessAutoTopUpSmartLinkAfterLogin() {
        String autoTopUpURL = links.getTestData("AutoTopUp.link");
        SmartLinksPage.accessSmartLink(autoTopUpURL);
        Assertions.assertElementAttribute(driver, TopUpPage.getAutoTopUpPageHeader_text(),
                "text", "Auto top up");
    }
}
