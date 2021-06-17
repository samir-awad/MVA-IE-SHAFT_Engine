package SmartLinks;

import Pages.Account;
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

public class TC193_AccessYourDetailsSmartLinkWithPAYGUser {
    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SmartLinks SmartLinksPage;
    private Account AccountPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        SmartLinksPage = new SmartLinks(driver);
        AccountPage = new Account(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath") + "smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessYourDetailsSmartLinkBeforeLogin() {
        String yourDetailsURL = links.getTestData("YourDetails.link");
        SmartLinksPage.accessSmartLink(yourDetailsURL);
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementAttribute(driver, AccountPage.getCheckYourDetailsPageHeader(),
                "text", "Your details");
    }

    @Test(dependsOnMethods = "CheckAccessYourDetailsSmartLinkBeforeLogin")
    public void CheckPersonalDetailsCloseButton() {
        AccountPage.pressCloseButtonForPersonalDetails();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo());

    }

    @Test(dependsOnMethods = "CheckPersonalDetailsCloseButton")
    public void CheckAccessYourDetailsSmartLinkAfterLogin() {
        String yourDetailsURL = links.getTestData("YourDetails.link");
        SmartLinksPage.accessSmartLink(yourDetailsURL);
        Assertions.assertElementAttribute(driver, AccountPage.getCheckYourDetailsPageHeader(),
                "text", "Your details");
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
