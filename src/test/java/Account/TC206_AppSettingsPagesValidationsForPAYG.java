package Account;

import Pages.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC206_AppSettingsPagesValidationsForPAYG {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Account  AccountPage;
    private Permission PermissionPage;
    private RateUs RateUsPage;

    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AccountPage=new Account(driver);
        PermissionPage = new Permission(driver);
        RateUsPage = new RateUs(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
        // LoginPage.acceptPermissions();
    }
    @Test
    public void AppSettingsPagesValidationsForPAYG(){
        Verifications.verifyElementExists(driver,HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountOverlay());
        AccountPage.pressAccountSettingOption();
        AccountPage.pressAppPermissionsOption();
        Verifications.verifyElementExists(driver,PermissionPage.getCheckAppPermissionsPageHeader());
        Verifications.verifyElementExists(driver,PermissionPage.getCheckAppPermissionsPageContent());
        PermissionPage.pressAccountHeaderBackChevron();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountSettingsPageHeader());
        AccountPage.pressRateUsOption();
        Verifications.verifyElementExists(driver,RateUsPage.getCheckRateUsOverlay());
        RateUsPage.PressNoInRateUsPage();
        Verifications.verifyElementExists(driver,RateUsPage.getCheckSorryToHearOverlay());
        RateUsPage.pressSorryToHearOverlayCloseButton();
        Assertions.assertElementExists(driver, AccountPage.getCheckAccountSettingsPageHeader());
        }
}
