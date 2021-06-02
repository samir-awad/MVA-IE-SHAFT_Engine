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
//        System.setProperty("executionAddress", "0.0.0.0:4723");
//        System.setProperty("targetOperatingSystem", "iOS");
//        System.setProperty("mobile_platformVersion", "13.5.1");
//        System.setProperty("mobile_automationName", "XCUITest");
//        System.setProperty("mobile_udid", "00008030-001C4D5C1E33802E");
//        System.setProperty("mobile_bundleId", "com.VodafoneIreland.MyVodafone");
//        System.setProperty("mobile_derivedDataPath","/Users/mva-ireland/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
//        System.setProperty("mobile_app",System.getProperty("user.dir")+"//App//97_AUTO.ipa");
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
        SmartLinksPage.accessSmartLink(netPerformLink);
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        SpeedCheckerPage.pressOkGrantPermissionButton();
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
        SmartLinksPage.accessSmartLink(netPerformLink);
        Assertions.assertElementAttribute(driver,SpeedCheckerPage.getSpeedCheckerHeader_text(),
                "text","Speed checker","Checking speed header");    }
}
