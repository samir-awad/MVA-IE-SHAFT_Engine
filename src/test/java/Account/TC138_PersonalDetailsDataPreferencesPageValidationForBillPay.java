package Account;

import Pages.Account;
import Pages.Home;
import Pages.Login;
import io.appium.java_client.MobileDriver;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC138_PersonalDetailsDataPreferencesPageValidationForBillPay {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Account AccountPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AccountPage = new Account(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();// LoginPage.acceptPermissions();
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
    public void CheckDataPreferencesSection() {
        AccountPage.pressPersonalDetailsSection();
        AccountPage.pressDataPreferencesSection();
        Verifications.verifyElementExists(driver, AccountPage.getCheckDataPreferencesPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckDataPreferencesPageContent());
        AccountPage.pressDataPreferencesEditButton();
        Assertions.assertElementExists(driver, AccountPage.getCheckDataPreferencesEditContent());
    }

    @Test(dependsOnMethods = "CheckDataPreferencesSection")
    public void ValidateTheDataPreferencesPage() {
        AccountPage.pressDataPreferencesCancelButton();
        Verifications.verifyElementExists(driver, AccountPage.getCheckDataPreferencesPageContent());
        AccountPage.pressBackButtonForDataPreferences();
        Assertions.assertElementExists(driver, AccountPage.getCheckPersonalDetailsPageHeader());
    }

    @Test(dependsOnMethods = "ValidateTheDataPreferencesPage")
    public void ValidateBackToDashBoard() {
        AccountPage.pressDataPreferencesSection();
        AccountPage.pressCloseButtonForDataPreference();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
