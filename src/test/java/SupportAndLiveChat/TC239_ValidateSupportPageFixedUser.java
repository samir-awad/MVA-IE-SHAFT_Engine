package SupportAndLiveChat;

import Pages.Home;
import Pages.Login;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC239_ValidateSupportPageFixedUser {
    private WebDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private SupportAndLiveChat SupportAndLiveChatPage;

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("executionAddress", "0.0.0.0:4723");
//        System.setProperty("targetOperatingSystem", "iOS");
//        System.setProperty("mobile_platformVersion", "13.5.1");
//        System.setProperty("mobile_automationName", "XCUITest");
//        System.setProperty("mobile_udid", "00008030-001C4D5C1E33802E");
//        System.setProperty("mobile_bundleId", "com.VodafoneIreland.MyVodafone");
//        System.setProperty("mobile_derivedDataPath","/Users/mva-ireland/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
//        System.setProperty("mobile_app",System.getProperty("user.dir")+"//App//98_AUTO.ipa");
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        SupportAndLiveChatPage = new SupportAndLiveChat(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("FixedUser.username");
        String password = users.getTestData("FixedUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void CheckSupportSection() {
        Assertions.assertElementAttribute(driver, HomePage.getSupportTrayMenuPAYG(),
                "text", "Support");
    }

    @Test(dependsOnMethods = "CheckSupportSection")
    public void CheckSupportHeader() {
        HomePage.pressSupportTrayView();
        Assertions.assertElementAttribute(driver, SupportAndLiveChatPage.getSupportHeader_text(),
                "text", "Support");
    }

    @Test(dependsOnMethods = "CheckSupportHeader")
    public void CheckSupportCloseBtn() {
        SupportAndLiveChatPage.pressSupportHeaderCloseButton();
        Assertions.assertElementAttribute(driver, HomePage.getSupportTrayMenuPAYG(),
                "text", "Support");
    }

    @Test(dependsOnMethods = "CheckSupportCloseBtn")
    public void CheckSupportPageTitleAndSubTitle() {
        HomePage.pressSupportTrayView();
        Verifications.verifyElementExists(driver, SupportAndLiveChatPage.getSupport_title(), Verifications.VerificationType.NEGATIVE);
        Assertions.assertElementExists(driver, SupportAndLiveChatPage.getSupport_Subtitle(), Assertions.AssertionType.NEGATIVE);
    }
}
