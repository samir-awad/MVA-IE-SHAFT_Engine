package Account;

import Pages.Account;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC228_CheckAccountNameEmailBillingDetailsPagesForBillPay {

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
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void CheckThatImOnHomePage() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckThatImOnHomePage")
    public void CheckAccountOverlay() {
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountOverlay());
    }

    @Test(dependsOnMethods = "CheckAccountOverlay")
    public void CheckAccountNameAndEmailOption() {
        AccountPage.pressAccountSettingOption();
        AccountPage.pressAccountNameAndEmailOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountNameAndEmailPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountNameAndEmailPageContent());
        AccountPage.fillEmailInputField();
        Verifications.verifyElementAttribute(driver, AccountPage.getSaveButtonBecomesEnabled(),
                "enabled", "true", "Save Button Becomes Enabled ");
    }

    @Test(dependsOnMethods = "CheckAccountNameAndEmailOption")
    public void CheckBillingOption() {
        AccountPage.pressAccountHeaderBackChevron();
        AccountPage.pressBillingDetailsOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckBillingDetailsPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckBillingDetailsBillingAddressSection());
        Verifications.verifyElementExists(driver, AccountPage.getCheckBillingDetailsBillingPreferencesSection());
    }

    @Test(dependsOnMethods = "CheckBillingOption")
    public void CheckAddAddressManuallyAndSearchForYourAddressLinks() {
        AccountPage.pressEnterAddressManuallyLink();
        Verifications.verifyElementExists(driver, AccountPage.getCheckBillingAddressSectionFieldsForManualAddress());
        AccountPage.pressSearchForYourAddressLink();
        Verifications.verifyElementExists(driver, AccountPage.getCheckBillingDetailsBillingAddressSection());
    }

    @Test(dependsOnMethods = "CheckAddAddressManuallyAndSearchForYourAddressLinks")
    public void CloseAndGoToHomePage() {
        AccountPage.pressBillingDetailsHeaderCloseButton();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }
}
