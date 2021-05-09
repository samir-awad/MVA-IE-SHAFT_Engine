package Account;

import Pages.Account;
import Pages.Home;
import Pages.Login;
import Pages.Logout;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC205_CheckOurPrivacyLinkAndLogoutButtonRedirectsForPAYG {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Account  AccountPage;
    private Logout LogoutPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AccountPage=new Account(driver);
        LogoutPage = new Logout(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
        // LoginPage.acceptPermissions();
    }
    @Test
    public void CheckOurPrivacyLinkAndLogoutButtonRedirectsForPAYG(){
        Verifications.verifyElementExists(driver,HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountOverlay());
        AccountPage.pressOurPrivacyLink();
        Verifications.verifyElementExists(driver,AccountPage.getCheckOurPrivacyHeaderWithCloseButton());
        AccountPage.pressCloseButtonInPrivacy();
        Verifications.verifyElementExists(driver,HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountOverlay());
        LogoutPage.pressLogoutButton();
        Verifications.verifyElementExists(driver,LogoutPage.getCheckLogoutOverlay());
        LogoutPage.pressLogoutNoButton();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountOverlay());
        LogoutPage.pressLogoutButton();
        Verifications.verifyElementExists(driver,LogoutPage.getCheckLogoutOverlay());
        LogoutPage.pressLogoutYesButton();
        Assertions.assertElementExists(driver, LoginPage.getLoginVf_Logo(), Assertions.AssertionType.POSITIVE);
        }
}
