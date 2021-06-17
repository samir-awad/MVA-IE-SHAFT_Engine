package SupportAndLiveChat;

import Pages.Home;
import Pages.Login;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC239_ValidateSupportPageFixedUser {
    private MobileDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private SupportAndLiveChat SupportAndLiveChatPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
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

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
