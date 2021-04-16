package SupportAndLiveChat;

import Pages.Home;
import Pages.Login;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC073A_ValidateLiveChatBillPayUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private SupportAndLiveChat SupportAndLiveChatPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        SupportAndLiveChatPage=new SupportAndLiveChat(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();
    }

    @Test
    public void CheckSupportSection(){
        Assertions.assertTrue(HomePage.checkSupportSection());
    }

    @Test(dependsOnMethods = "CheckSupportSection")
    public void CheckSupportHeader(){
        HomePage.pressSupportTrayMenu();
        Assertions.assertElementAttribute(driver,SupportAndLiveChatPage.getSupportHeader_text(),
                "text","Support");
    }

    @Test(dependsOnMethods = "CheckSupportHeader")
    public void CheckLiveChatComponent(){
        SupportAndLiveChatPage.minimizeLiveChat();
        Assertions.assertElementExists(driver,SupportAndLiveChatPage.getChatNow_button());
    }

    @Test(dependsOnMethods = "CheckLiveChatComponent")
    public void ValidateLiveChatComponent(){
    SupportAndLiveChatPage.pressChatNowButton();
        Verifications.verifyElementAttribute(driver,SupportAndLiveChatPage.getSupportHeader_text(),
                "text","Support");
        Assertions.assertElementExists(driver,SupportAndLiveChatPage.getChatNow_button(),
                Assertions.AssertionType.NEGATIVE,"check Live Chat Component Is No Longer Displayed");
    }

    @Test(dependsOnMethods = "ValidateLiveChatComponent")
    public void checkAndFillLiveChatForm(){
    SupportAndLiveChatPage.fillLiveChatFormAndPressStartChat();
    }

    //Next steps needs SIT3 environment



}
