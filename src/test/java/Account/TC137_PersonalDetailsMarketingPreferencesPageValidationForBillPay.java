package Account;

import Pages.Account;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC137_PersonalDetailsMarketingPreferencesPageValidationForBillPay {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Account AccountPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AccountPage = new Account(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void CheckAccountView() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Assertions.assertElementExists(driver, AccountPage.getCheckAccountOverlay());
    }

    @Test(dependsOnMethods = "CheckAccountView")
    public void CheckAccountSetting() {
        AccountPage.pressAccountSettingOption();
        Assertions.assertElementExists(driver, AccountPage.getCheckAccountSettingsPageHeader());
    }

    @Test(dependsOnMethods = "CheckAccountSetting")
    public void CheckMarketingPreferencesSection() {
        AccountPage.pressPersonalDetailsSection();
        AccountPage.pressMarketingPreferencesSection();
        Verifications.verifyElementExists(driver, AccountPage.getCheckMarketingPreferencesPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckMarketingPreferencesPageContent());
        AccountPage.pressMarketingPreferencesEditButton();
        Assertions.assertElementExists(driver, AccountPage.getCheckMarketingPreferencesEditContent());
    }

    @Test(dependsOnMethods = "CheckMarketingPreferencesSection")
    public void ValidateTheMarketingPreferencesPage() {
        AccountPage.pressMarketingPreferencesCancelButton();
        Verifications.verifyElementExists(driver, AccountPage.getCheckMarketingPreferencesPageContent());
        AccountPage.pressBackButtonForMarketingPreferencesPage();
        Assertions.assertElementExists(driver, AccountPage.getCheckPersonalDetailsPageHeader());
    }

    @Test(dependsOnMethods = "ValidateTheMarketingPreferencesPage")
    public void ValidateBackToDashBoard() {
        AccountPage.pressMarketingPreferencesSection();
        AccountPage.pressCloseButtonForMarketingPreferencesPage();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
