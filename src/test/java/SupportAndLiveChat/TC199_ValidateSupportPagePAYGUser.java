package SupportAndLiveChat;

import FileReaders.GetUserFromJson;
import Pages.Home;
import Pages.Login;
import Pages.SupportAndLiveChat;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC199_ValidateSupportPagePAYGUser {
    private WebDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private SupportAndLiveChat SupportAndLiveChatPage;

    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        SupportAndLiveChatPage=new SupportAndLiveChat(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test
    public void CheckSupportSection(){
    Assertions.assertElementAttribute(driver,HomePage.getSupportTrayMenuPAYG(),
            "text","Support");
    }

    @Test(dependsOnMethods = "CheckSupportSection")
    public void CheckSupportHeader(){
        HomePage.pressSupportTrayView();
        Assertions.assertElementAttribute(driver,SupportAndLiveChatPage.getSupportHeader_text(),
                "text","Support");
    }

    @Test(dependsOnMethods = "CheckSupportHeader")
    public void CheckSupportCloseBtn(){
        SupportAndLiveChatPage.pressSupportHeaderCloseButton();
        Assertions.assertElementAttribute(driver,HomePage.getSupportTrayMenuPAYG(),
                "text","Support");
    }

    @Test(dependsOnMethods = "CheckSupportCloseBtn")
    public void CheckSupportPageTitleAndSubTitle(){
        HomePage.pressSupportTrayView();

        Verifications.verifyElementExists(driver,SupportAndLiveChatPage.getFirstSupportTitle_textPAYG(),
                "Checking first support title");
        Verifications.verifyElementExists(driver,SupportAndLiveChatPage.getSecondSupportTitle_textPAYG(),
                "Checking second support title");
        Assertions.assertElementExists(driver,SupportAndLiveChatPage.getSupportListFirstItem_textPAYG(),
                "Checking first item in support topic list");
    }
}
