package SupportAndLiveChat;

import Pages.Home;
import Pages.Login;
import Pages.Offers;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC072A_ValidateSupportPageBillPayUser {
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
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();
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
    public void CheckSupportCloseBtn(){
    SupportAndLiveChatPage.pressSupportHeaderCloseButton();
        Assertions.assertTrue(HomePage.checkSupportSection());
    }

    @Test(dependsOnMethods = "CheckSupportCloseBtn")
    public void CheckSupportPageTitleAndSubTitle(){
        HomePage.pressSupportTrayMenu();
        SupportAndLiveChatPage.minimizeLiveChat();
        Verifications.verifyElementExists(driver,SupportAndLiveChatPage.getFirstSupportTitle_text(),
                "Checking first support title");
        Verifications.verifyElementExists(driver,SupportAndLiveChatPage.getSecondSupportTitle_text(),
                "Checking second support title");
        Assertions.assertElementExists(driver,SupportAndLiveChatPage.getSupportListFirstItem_text(),
                "Checking first item in support topic list");
    }

}
