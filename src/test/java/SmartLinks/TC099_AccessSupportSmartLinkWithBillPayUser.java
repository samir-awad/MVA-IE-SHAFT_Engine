package SmartLinks;

import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC099_AccessSupportSmartLinkWithBillPayUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SupportAndLiveChat SupportAndLiveChatPage;
    private SmartLinks smartLinksPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage= new Home(driver);
        SupportAndLiveChatPage=new SupportAndLiveChat(driver);
        smartLinksPage = new SmartLinks(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessSupportSmartLinkBeforeLogin(){
        String supportURL= links.getTestData("Support.link");
        smartLinksPage.accessOffersSmartLink(supportURL);
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Verifications.verifyElementMatches(driver,HomePage.getVodafoneLogo());
        Assertions.assertElementAttribute(driver,SupportAndLiveChatPage.getSupportHeader_text(),
                "text","Support");
    }

    @Test(dependsOnMethods = "CheckAccessSupportSmartLinkBeforeLogin")
    public void CheckSupportHeaderCloseButton(){
        SupportAndLiveChatPage.pressSupportHeaderCloseButton();
        Assertions.assertElementMatches(driver,HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods ="CheckSupportHeaderCloseButton")
    public void CheckAccessSupportSmartLinkAfterLogin(){
        String supportURL= links.getTestData("Support.link");
        smartLinksPage.accessOffersSmartLink(supportURL);
        Assertions.assertElementAttribute(driver,SupportAndLiveChatPage.getSupportHeader_text(),
                "text","Support");
    }

}
