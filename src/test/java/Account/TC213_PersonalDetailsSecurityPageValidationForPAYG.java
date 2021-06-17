package Account;

import Pages.Account;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC213_PersonalDetailsSecurityPageValidationForPAYG {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Account AccountPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AccountPage = new Account(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
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
    public void CheckSecuritySection() {
        AccountPage.pressPersonalDetailsSection();
        AccountPage.pressSecuritySection();
        Verifications.verifyElementExists(driver, AccountPage.getCheckSecurityPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckSecurityPageContent());
        AccountPage.pressSecurityEditPasswordButton();
        Verifications.verifyElementExists(driver, AccountPage.getCheckChangePasswordPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckChangePasswordPageContent());
        AccountPage.pressChangePasswordCancelButton();
        Assertions.assertElementExists(driver, AccountPage.getCheckSecurityPageHeader());
    }

    @Test(dependsOnMethods = "CheckSecuritySection")
    public void ValidateChangePinView() {
        AccountPage.pressSecurityEditPinButton();
        Verifications.verifyElementExists(driver, AccountPage.getCheckChangePinPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckChangePinPageContent());
        AccountPage.pressChangePinCancelButton();
        Assertions.assertElementExists(driver, AccountPage.getCheckSecurityPageHeader());
    }

    @Test(dependsOnMethods = "ValidateChangePinView")
    public void ValidateBackToDashBoard() {
        AccountPage.pressBackButtonForSecurityPage();
        Verifications.verifyElementExists(driver, AccountPage.getCheckPersonalDetailsPageHeader());
        AccountPage.pressSecuritySection();
        AccountPage.pressCloseButtonForSecurityPage();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
