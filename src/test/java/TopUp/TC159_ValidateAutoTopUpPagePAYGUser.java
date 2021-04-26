package TopUp;

import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC159_ValidateAutoTopUpPagePAYGUser {
    private WebDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private TopUp TopUpPage;


    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        TopUpPage= new TopUp(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("PAYGUserWithTopUp.username");
        String password = users.getTestData("PAYGUserWithTopUp.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test
    public void CheckVodafoneLogoAndWelcomeGesture(){
        Assertions.assertTrue(HomePage.checkTheVodafoneLogo(),"checking vodafone logo And Welcome Gesture");
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckSetAutoTopUpOptionPage(){
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayMoreOptionsButton();
        TopUpPage.pressMoreOptionsOverlaySetAutoTopUpOption();
        Verifications.verifyElementAttribute(driver,TopUpPage.getAutoTopUpPageHeader_text(),
                "text","Auto top up","checking Auto Top Up Page Header");
        Assertions.assertElementAttribute(driver,TopUpPage.getAutoTopUpPageMyNumber_text(),
                "text","My number","Checking Auto Top Up Page Content");
    }

    @Test(dependsOnMethods = "CheckSetAutoTopUpOptionPage")
    public void ValidateSetAutoTopUpOptionPageBackBtn(){
        TopUpPage.pressAutoTopUpBackButton();
        Assertions.assertElementAttribute(driver,TopUpPage.getMoreOptionOverlayHeader_text(),
                "text","More options","checking more options overlay header");
    }

    @Test(dependsOnMethods = "ValidateSetAutoTopUpOptionPageBackBtn")
    public void ValidateSetAutoTopUpOptionPageCancelBtn(){
        TopUpPage.pressMoreOptionsOverlaySetAutoTopUpOption();
        TopUpPage.pressCancelBtn();
        Assertions.assertTrue(HomePage.checkTheVodafoneLogo(),"checking vodafone logo And Welcome Gesture");
    }
}
