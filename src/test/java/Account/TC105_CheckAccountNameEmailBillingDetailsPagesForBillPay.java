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

public class TC105_CheckAccountNameEmailBillingDetailsPagesForBillPay {

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
    }

    @Test
    public void Login() {
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test(dependsOnMethods = "Login")
    public void CheckAccountNameEmailBillingDetailsPagesForBillPay() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountOverlay());
        AccountPage.pressAccountSettingOption();
        AccountPage.pressAccountNameAndEmailOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountNameAndEmailPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountNameAndEmailPageContent());
        AccountPage.fillEmailInputField();
        Verifications.verifyElementAttribute(driver, AccountPage.getSaveButtonBecomesEnabled(),
                "enabled", "true", "Save Button Becomes Enabled ");
        AccountPage.pressAccountHeaderBackChevron();
        AccountPage.pressBillingDetailsOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckBillingDetailsPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckBillingDetailsPageContent());
        AccountPage.pressBillingDetailsHeaderCloseButton();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
