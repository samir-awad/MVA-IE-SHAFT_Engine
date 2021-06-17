package SmartLinks;

import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC273_AccessSupportSmartLinkWithFixedUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SupportAndLiveChat SupportAndLiveChatPage;
    private SmartLinks smartLinksPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        SupportAndLiveChatPage = new SupportAndLiveChat(driver);
        smartLinksPage = new SmartLinks(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath") + "smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessSupportSmartLinkBeforeLogin() {
        String supportURL = links.getTestData("Support.link");
        smartLinksPage.accessSmartLink(supportURL);
        String username = users.getTestData("FixedUser.username");
        String password = users.getTestData("FixedUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementAttribute(driver, SupportAndLiveChatPage.getSupportHeader_text(),
                "text", "Support");
    }

    @Test(dependsOnMethods = "CheckAccessSupportSmartLinkBeforeLogin")
    public void CheckSupportHeaderCloseButton() {
        SupportAndLiveChatPage.pressSupportHeaderCloseButton();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckSupportHeaderCloseButton")
    public void CheckAccessSupportSmartLinkAfterLogin() {
        String supportURL = links.getTestData("Support.link");
        smartLinksPage.accessSmartLink(supportURL);
        Assertions.assertElementAttribute(driver, SupportAndLiveChatPage.getSupportHeader_text(),
                "text", "Support");
    }

}
