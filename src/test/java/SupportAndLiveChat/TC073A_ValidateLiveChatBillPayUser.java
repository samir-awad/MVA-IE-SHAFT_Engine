package SupportAndLiveChat;

import Pages.Home;
import Pages.Login;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC073A_ValidateLiveChatBillPayUser {
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
        SupportAndLiveChatPage = new SupportAndLiveChat(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void CheckSupportSection() {
        Assertions.assertTrue(HomePage.checkSupportSection());
    }

    @Test(dependsOnMethods = "CheckSupportSection")
    public void CheckSupportHeader() {
        HomePage.pressSupportTitle();
        Assertions.assertElementAttribute(driver, SupportAndLiveChatPage.getSupportHeader_text(),
                "text", "Support");
    }

    @Test(dependsOnMethods = "CheckSupportHeader")
    public void CheckLiveChatComponent() {
        //SupportAndLiveChatPage.minimizeLiveChat();
        ElementActions.isElementDisplayed(driver, SupportAndLiveChatPage.getChatNow_button());
        Assertions.assertElementExists(driver, SupportAndLiveChatPage.getChatNow_button()); //ChatNow button can't be located
    }

    @Test(dependsOnMethods = "CheckLiveChatComponent")
    public void ValidateLiveChatComponent() {
        SupportAndLiveChatPage.pressChatNowButton();
        Verifications.verifyElementAttribute(driver, SupportAndLiveChatPage.getSupportHeader_text(),
                "text", "Support");
        Assertions.assertElementExists(driver, SupportAndLiveChatPage.getChatNow_button(),//ChatNow button can't be located
                Assertions.AssertionType.NEGATIVE, "check Live Chat Component Is No Longer Displayed");
    }

    @Test(dependsOnMethods = "ValidateLiveChatComponent")
    public void checkAndFillLiveChatForm() {
        SupportAndLiveChatPage.fillLiveChatFormAndPressStartChat();
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
