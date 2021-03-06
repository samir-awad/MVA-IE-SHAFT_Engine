package SmartLinks;

import Pages.Login;
import Pages.SmartLinks;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC194_AccessTopUpSmartLinkWithPAYGUser {
    private MobileDriver driver;
    private Login LoginPage;
    private SmartLinks SmartLinksPage;
    private TopUp TopUpPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        SmartLinksPage = new SmartLinks(driver);
        TopUpPage = new TopUp(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath") + "smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessTopUpSmartLinkBeforeLogin() {
        String topUpURL = links.getTestData("TopUp.link");
        SmartLinksPage.accessSmartLink(topUpURL);
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.login(username, password).acceptPermissionsPAYGUser();
        Assertions.assertElementAttribute(driver, TopUpPage.getTopUpOverlayHeader_text(),
                "text", "Top Up");
    }

    @Test(dependsOnMethods = "CheckAccessTopUpSmartLinkBeforeLogin")
    public void CheckAccessTopUpSmartLinkAfterLogin() {
        String topUpURL = links.getTestData("TopUp.link");
        SmartLinksPage.accessSmartLink(topUpURL);
        Assertions.assertElementAttribute(driver, TopUpPage.getTopUpOverlayHeader_text(),
                "text", "Top Up");
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
