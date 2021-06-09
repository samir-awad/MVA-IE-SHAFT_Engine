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

public class TC106_MyRecordsPagValidationForBillPay {

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
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test(dependsOnMethods = "Login")
    public void CheckThatImOnHomePage() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckThatImOnHomePage")
    public void ValidateAccountOverlay() {
        AccountPage.pressAccountTrayMenuOption();
        Assertions.assertElementExists(driver, AccountPage.getCheckAccountOverlay());
    }

    @Test(dependsOnMethods = "ValidateAccountOverlay")
    public void GoToMyRecordsAndValidateOrderArea() {
        AccountPage.pressMyRecordsOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckMyRecordsPageHeader());
        Verifications.verifyElementExists(driver, AccountPage.getCheckAvailableTabOptions());
        Assertions.assertElementExists(driver, AccountPage.getCheckOrdersArea());
    }

    @Test(dependsOnMethods = "GoToMyRecordsAndValidateOrderArea")
    public void ValidateLetterTab() {
        AccountPage.pressLettersTabOption();
        Verifications.verifyElementExists(driver, AccountPage.getCheckThatExistsAtLeastOneLetter());
    }

    @Test(dependsOnMethods = "ValidateLetterTab")
    public void ValidateFirstLetter() {
        AccountPage.pressFirstLetter();
        Assertions.assertElementExists(driver, AccountPage.getCheckFirstLetterAttachmentsLink());
    }

    @Test(dependsOnMethods = "ValidateFirstLetter")
    public void OpenAttachmentInPDFViewer() {
        AccountPage.pressFirstLetterAttachmentsLink();
        AccountPage.chooseAppToOpenLetterWith();
        Verifications.verifyElementExists(driver, AccountPage.getCheckLetterIsOpenedAsPdfDocument());
    }

    @Test(dependsOnMethods = "OpenAttachmentInPDFViewer")
    public void GoBackToMyRecordsPageAndCloseIt() {
        driver.navigate().back();
//        AccountPage.goBackToMyRecordsPage();
        AccountPage.pressMyRecordsHeaderCloseButton();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }
}
