package SmartLinks;

import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import Pages.SpeedChecker;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC097_AccessNetPerformSmartLinkWithBillPayUser {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SmartLinks SmartLinksPage;
    private SpeedChecker SpeedCheckerPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage= new Home(driver);
        SmartLinksPage= new SmartLinks(driver);
        SpeedCheckerPage=new SpeedChecker(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessNetPerformSmartLinkBeforeLogin(){
        //Link is not working
        String netPerformLink= links.getTestData("NetPerform.link");
        SmartLinksPage.accessOffersSmartLink(netPerformLink);
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        SpeedCheckerPage.pressOkGrantPermissionButton();
        Verifications.verifyElementMatches(driver,HomePage.getVodafoneLogo());
        Assertions.assertElementAttribute(driver,SpeedCheckerPage.getSpeedCheckerHeader_text(),
                "text","Speed checker","Checking speed header");
    }

    @Test(dependsOnMethods = "CheckAccessNetPerformSmartLinkBeforeLogin")
    public void CheckNetPerformCloseButton(){
        SpeedCheckerPage.pressSpeedCheckerHeaderCloseButton();
        Assertions.assertElementMatches(driver,HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods ="CheckNetPerformCloseButton")
    public void CheckAccessNetPerformSmartLinkAfterLogin(){
        String netPerformLink= links.getTestData("NetPerform.link");
        SmartLinksPage.accessOffersSmartLink(netPerformLink);
        Assertions.assertElementAttribute(driver,SpeedCheckerPage.getSpeedCheckerHeader_text(),
                "text","Speed checker","Checking speed header");    }
}
