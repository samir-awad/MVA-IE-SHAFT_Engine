package SmartLinks;

import Pages.Account;
import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC101_AccessPersonalDetailsSmartLinkWithBillPayUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SmartLinks smartLinksPage;
    private Account AccountPage;
    private JSONFileManager links;
    private JSONFileManager users;


    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage= new Home(driver);
        smartLinksPage = new SmartLinks(driver);
        AccountPage= new Account(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessPersonalDetailsSmartLinkBeforeLogin(){
        String personalDetailsURL= links.getTestData("PersonalDetails.link");
        smartLinksPage.accessSmartLink(personalDetailsURL);
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementAttribute(driver,AccountPage.getCheckPersonalDetailsPageHeader(),
                "text","Personal details");
    }

    @Test(dependsOnMethods = "CheckAccessPersonalDetailsSmartLinkBeforeLogin")
    public void CheckPersonalDetailsCloseButton(){
        AccountPage.pressCloseButtonForPersonalDetails();
        Assertions.assertElementMatches(driver,HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods ="CheckPersonalDetailsCloseButton")
    public void CheckAccessPersonalDetailsSmartLinkAfterLogin(){
        String personalDetailsURL= links.getTestData("PersonalDetails.link");
        smartLinksPage.accessSmartLink(personalDetailsURL);
        Assertions.assertElementAttribute(driver,AccountPage.getCheckPersonalDetailsPageHeader(),
                "text","Personal details");
    }
}
