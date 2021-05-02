package SmartLinks;
import Pages.Login;
import Pages.SmartLinks;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC095_AccessOffersSmartLinkWithBillPayUser
{
    //private MobileDriver driver;
    private WebDriver driver;
    private WebDriver nativeDriver;
    private Login LoginPage;
   // private SmartLinks smartLinksPage;
    private JSONFileManager links;
    private JSONFileManager users;
    ChromeOptions options = new ChromeOptions();

    @BeforeClass
    public void beforeClass(){
        nativeDriver = BrowserFactory.getBrowser();
        //smartLinksPage = new SmartLinks(driver);
        LoginPage = new Login(nativeDriver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
        //BrowserActions.closeCurrentWindow(nativeDriver);

        System.setProperty("mobile_appPackage","");
        System.setProperty("mobile_appActivity","");
        System.setProperty("mobile_browserName","Chrome");
        System.setProperty("MobileBrowserVersion","90.0.4430.24");
        options.addArguments("user-data-dir=/data/user/0/com.android.chrome/app_chrome");
        //driver= BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME, options);
       // driver=BrowserFactory.getBrowser();
        String OffersURL= links.getTestData("Offers.link");
        BrowserActions.navigateToURL(driver,OffersURL);
        //driver.runAppInBackground(Duration.ofSeconds(-1));
        //driver.closeApp();
    }

    @Test
    public void CheckOffersSmartLink(){
        //String OffersURL= links.getTestData("Offers.link");
       //driver.get(OffersURL);
       //smartLinksPage.accessOffersSmartLink(OffersURL);
    }





}
