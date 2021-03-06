package Account;

import Pages.*;
import io.appium.java_client.MobileDriver;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC108_AppSettingsPagesValidationsForBillPay {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Account AccountPage;
    private Permission PermissionPage;
    private RateUs RateUsPage;

    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AccountPage = new Account(driver);
        PermissionPage = new Permission(driver);
        RateUsPage = new RateUs(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void AppSettingsPagesValidationsForBillPay() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountOverlay());
        AccountPage.pressAccountSettingOption();
        AccountPage.pressAppPermissionsOption();
        Verifications.verifyElementExists(driver, PermissionPage.getCheckAppPermissionsPageHeader());
        Verifications.verifyElementExists(driver, PermissionPage.getCheckAppPermissionsPageContent());
        PermissionPage.pressAccountHeaderBackChevron();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountSettingsPageHeader());
        AccountPage.pressRateUsOption();
        Verifications.verifyElementExists(driver, RateUsPage.getCheckRateUsOverlay());
        RateUsPage.PressNoInRateUsPage();
        Verifications.verifyElementExists(driver, RateUsPage.getCheckSorryToHearOverlay());
        RateUsPage.pressSorryToHearOverlayCloseButton();
        Assertions.assertElementExists(driver, AccountPage.getCheckAccountSettingsPageHeader());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
