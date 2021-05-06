package SmartLinks;

import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC101_AccessPersonalDetailsSmartLinkWithBillPayUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SmartLinks smartLinksPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage= new Home(driver);
        smartLinksPage = new SmartLinks(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessPersonalDetailsSmartLinkBeforeLogin(){
        String personalDetailsURL= links.getTestData("PersonalDetails.link");
        smartLinksPage.accessOffersSmartLink(personalDetailsURL);
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Verifications.verifyElementMatches(driver,HomePage.getVodafoneLogo());
        //checkPersonalDetailsPageHeader
    }

    @Test(dependsOnMethods = "CheckAccessPersonalDetailsSmartLinkBeforeLogin")
    public void CheckPersonalDetailsCloseButton(){
        //pressCloseButton
        Assertions.assertElementMatches(driver,HomePage.getVodafoneLogo());

    }

    @Test(dependsOnMethods ="CheckPersonalDetailsCloseButton")
    public void CheckAccessPersonalDetailsSmartLinkAfterLogin(){
        //close app
        //accessPersonalDetailsSmartLink
        //checkPersonalDetailsPageHeader
    }
}
