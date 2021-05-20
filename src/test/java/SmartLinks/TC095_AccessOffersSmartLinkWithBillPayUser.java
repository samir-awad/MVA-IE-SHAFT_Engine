package SmartLinks;
import Pages.Home;
import Pages.Login;
import Pages.Offers;
import Pages.SmartLinks;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC095_AccessOffersSmartLinkWithBillPayUser
{
    private WebDriver driver;
    private Login LoginPage;
    private SmartLinks smartLinksPage;
    private Offers OffersPage;
    private Home HomePage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("executionAddress", "0.0.0.0:4723");
        System.setProperty("targetOperatingSystem", "iOS");
        System.setProperty("mobile_platformVersion", "13.5.1");
        System.setProperty("mobile_automationName", "XCUITest");
        System.setProperty("mobile_udid", "00008030-001C4D5C1E33802E");
        System.setProperty("mobile_bundleId", "com.VodafoneIreland.MyVodafone");
        System.setProperty("mobile_derivedDataPath","/Users/mva-ireland/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
       // System.setProperty("mobile_app",System.getProperty("user.dir")+"//App//97_AUTO.ipa");
        driver = BrowserFactory.getBrowser();
        smartLinksPage = new SmartLinks(driver);
        LoginPage = new Login(driver);
        OffersPage= new Offers(driver);
        HomePage = new Home(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessOffersSmartLinkBeforeLogin(){
        String OffersURL= links.getTestData("Offers.link");
        smartLinksPage.accessSmartLink(OffersURL);
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementAttribute(driver,OffersPage.getOffersHeader_text(),
                "text","Offers","Checking offers header");
    }

    @Test(dependsOnMethods = "CheckAccessOffersSmartLinkBeforeLogin")
    public void ValidateHeaderCloseButton(){
        OffersPage.pressHeaderCloseButton();
        Assertions.assertElementMatches(driver,HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "ValidateHeaderCloseButton")
    public void CheckAccessOffersSmartLinkAfterLogin(){
        String OffersURL= links.getTestData("Offers.link");
        smartLinksPage.accessSmartLink(OffersURL);
        Assertions.assertElementAttribute(driver,OffersPage.getOffersHeader_text(),
                "text","Offers","Checking offers header");
    }





}
