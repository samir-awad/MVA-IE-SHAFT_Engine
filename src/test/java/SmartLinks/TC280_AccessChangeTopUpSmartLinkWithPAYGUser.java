package SmartLinks;

import Pages.ChangeTopUpOffer;
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

public class TC280_AccessChangeTopUpSmartLinkWithPAYGUser {
    private MobileDriver driver;
    private Login LoginPage;
    private SmartLinks SmartLinksPage;
    private ChangeTopUpOffer ChangeTopUpOfferPage;
    private Home HomePage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        SmartLinksPage = new SmartLinks(driver);
        ChangeTopUpOfferPage = new ChangeTopUpOffer(driver);
        HomePage = new Home(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath") + "smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessChangeTopUpOfferSmartLinkBeforeLogin() {
        String changeTopUpOfferURL = links.getTestData("ChangeTopUp.link");
        SmartLinksPage.accessSmartLink(changeTopUpOfferURL);
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.login(username, password).acceptPermissionsPAYGUser();
        Assertions.assertElementAttribute(driver, ChangeTopUpOfferPage.getChangeTopUpOfferHeader_text(),
                "text", "Change top up offer");
    }

    @Test(dependsOnMethods = "CheckAccessChangeTopUpOfferSmartLinkBeforeLogin")
    public void CheckChangeTopUpOfferCloseButton() {
        ChangeTopUpOfferPage.pressCloseBtn();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckChangeTopUpOfferCloseButton")
    public void CheckAccessAutoTopUpSmartLinkAfterLogin() {
        String changeTopUpOfferURL = links.getTestData("ChangeTopUp.link");
        SmartLinksPage.accessSmartLink(changeTopUpOfferURL);
        Assertions.assertElementAttribute(driver, ChangeTopUpOfferPage.getChangeTopUpOfferHeader_text(),
                "text", "Change top up offer");
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
