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

public class TC136_PersonalDetailsManagePersonalInformationPageForBillPay {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Account AccountPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AccountPage=new Account(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
        // LoginPage.acceptPermissions();
    }
    @Test
    public void PersonalDetailsManagePersonalInformationPageForBillPay(){
        Verifications.verifyElementExists(driver,HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountOverlay());
        AccountPage.pressAccountSettingOption();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountSettingsPageHeader());
        AccountPage.pressPersonalDetailsSection();
        AccountPage.pressManagePersonalInformationSection();
        Verifications.verifyElementExists(driver,AccountPage.getCheckManagePersonalInformationPageHeader());
        Verifications.verifyElementExists(driver,AccountPage.getCheckManagePersonalInformationPageContent());
        AccountPage.pressManagePersonalInformationEditButton();
        Verifications.verifyElementExists(driver,AccountPage.getCheckManagePersonalInformationEditContent());
        AccountPage.pressDownloadDataRequestForm();
        Verifications.verifyElementExists(driver,AccountPage.getCheckSubjectAccessRequestFormPdfIsOpened());
        AccountPage.pressPdfBackButton();
        AccountPage.pressDeletionRequestForm();
        Assertions.assertTrue(AccountPage.CheckDeletionRequestFormExternalPage(), "Checking if external page is opened");
        AccountPage.goBackToTheRequestInformationPage();
        AccountPage.pressBackButtonForTheRequestInformationPage();
        Verifications.verifyElementExists(driver,AccountPage.getCheckPersonalDetailsPageHeader());
        AccountPage.pressManagePersonalInformationSection();
        AccountPage.pressCloseButtonForManagePersonalInformationSection();
        Assertions.assertElementExists(driver,HomePage.getCheckTheVodafoneLogo());

    }
}
