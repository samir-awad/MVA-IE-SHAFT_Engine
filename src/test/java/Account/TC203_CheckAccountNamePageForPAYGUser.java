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

public class TC203_CheckAccountNamePageForPAYGUser {

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

    }

    @Test
    public void Login() {
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test(dependsOnMethods = "Login")
    public void CheckThatImOnHomePage() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckThatImOnHomePage")
    public void CheckAccountOverlayForPAYGUser() {
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountOverlay());
    }

    @Test(dependsOnMethods = "CheckAccountOverlayForPAYGUser")
    public void CheckAccountOptionPage() {
        AccountPage.pressAccountSettingOption();
        AccountPage.pressAccountNameOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountNamePageHeader());
    }

    @Test(dependsOnMethods = "CheckAccountOptionPage")
    public void FillAccountNameField() {
        AccountPage.fillAccountNameField();
        Verifications.verifyElementAttribute(driver, AccountPage.getSaveButtonBecomesEnabled(),
                "enabled", "true", "Save Button Becomes Enabled ");
        AccountPage.pressAccountHeaderBackChevron();
        AccountPage.pressAccountNameOption();
    }

    @Test(dependsOnMethods = "FillAccountNameField")
    public void BackToDashboard() {
        AccountPage.pressAccountHeaderCloseButton();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
