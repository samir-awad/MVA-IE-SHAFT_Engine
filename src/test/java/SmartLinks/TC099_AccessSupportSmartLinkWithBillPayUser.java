package SmartLinks;

import Pages.Home;
import Pages.Login;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC099_AccessSupportSmartLinkWithBillPayUser {
    private WebDriver driver;
    private WebDriver nativeDriver;
    private Login LoginPage;
    private Home HomePage;
    private SupportAndLiveChat SupportAndLiveChatPage;
    private JSONFileManager links;
    private JSONFileManager users;
    ChromeOptions options = new ChromeOptions();

    @BeforeClass
    public void beforeClass(){
        nativeDriver = BrowserFactory.getBrowser();
        LoginPage = new Login(nativeDriver);
        HomePage= new Home(nativeDriver);
        SupportAndLiveChatPage=new SupportAndLiveChat(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        LoginPage.acceptTermsAndConditions();
        //close app
    }

    @Test
    public void CheckAccessSupportSmartLinkBeforeLogin(){
        //accessSupportSmartLink
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementAttribute(driver,SupportAndLiveChatPage.getSupportHeader_text(),
                "text","Support");
    }

    @Test(dependsOnMethods = "CheckAccessSupportSmartLinkBeforeLogin")
    public void CheckSupportHeaderCloseButton(){
        SupportAndLiveChatPage.pressSupportHeaderCloseButton();
        Assertions.assertTrue(HomePage.checkSupportSection());
    }

    @Test(dependsOnMethods ="CheckSupportHeaderCloseButton")
    public void CheckAccessSupportSmartLinkAfterLogin(){
        //close app
        //accessSupportSmartLink
        Assertions.assertElementAttribute(driver,SupportAndLiveChatPage.getSupportHeader_text(),
                "text","Support");
    }

}
