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

public class TC136_PersonalDetailsManagePersonalInformationPageForBillPay {

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
    public void CheckImOnHome() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckImOnHome")
    public void CheckAccountOverlay() {
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountOverlay());
    }

    @Test(dependsOnMethods = "CheckAccountOverlay")
    public void ValidateAccountSettings() {
        AccountPage.pressAccountSettingOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckAccountSettingsPageHeader());
    }

    @Test(dependsOnMethods = "ValidateAccountSettings")
    public void ManagePersonalDetails() {
        AccountPage.pressPersonalDetailsSection();
        AccountPage.pressManagePersonalInformationSection();
        Verifications.verifyElementExists(driver, AccountPage.getCheckManagePersonalInformationPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckManagePersonalInformationPageContent());
    }

    @Test(dependsOnMethods = "ManagePersonalDetails")
    public void PressEditButtonAndCheckContent() {
        AccountPage.pressManagePersonalInformationEditButton();
        Verifications.verifyElementExists(driver, AccountPage.getCheckManagePersonalInformationEditContent());
    }

    @Test(dependsOnMethods = "PressEditButtonAndCheckContent")
    public void CheckDataRequestForm() {
        AccountPage.pressDownloadDataRequestForm();
        Verifications.verifyElementExists(driver, AccountPage.getCheckSubjectAccessRequestFormPdfIsOpened());
        driver.navigate().back();
    }

    @Test(dependsOnMethods = "CheckDataRequestForm")
    public void CheckDataDeletionForm() {
        //AccountPage.pressPdfBackButton();
        AccountPage.pressDeletionRequestForm();
        Assertions.assertTrue(AccountPage.CheckDeletionRequestFormExternalPage(), "Checking if external page is opened");
        AccountPage.goBackToTheRequestInformationPage();
    }

    @Test(dependsOnMethods = "CheckDataDeletionForm")
    public void CheckICloseManagePersonalInfoAndGoBackToHomePage() {
        AccountPage.pressBackButtonForTheRequestInformationPage();
        Verifications.verifyElementExists(driver, AccountPage.getCheckPersonalDetailsPageHeader());
        AccountPage.pressManagePersonalInformationSection();
        AccountPage.pressCloseButtonForManagePersonalInformationSection();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
