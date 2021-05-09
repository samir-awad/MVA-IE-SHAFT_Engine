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

public class TC209_PersonalDetailsManagePersonalInformationPageValidationForPAYG {

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
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
        // LoginPage.acceptPermissions();
    }
    @Test
    public void CheckAccountView() {
        Verifications.verifyElementExists(driver, HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Assertions.assertElementExists(driver,AccountPage.getCheckAccountOverlay());
    }

    @Test(dependsOnMethods = "CheckAccountView")
    public void CheckAccountSetting() {
        AccountPage.pressAccountSettingOption();
        Assertions.assertElementExists(driver,AccountPage.getCheckAccountSettingsPageHeader());
    }
     @Test(dependsOnMethods = "CheckAccountSetting")
     public void CheckPersonalDetailsSection() {
         AccountPage.pressPersonalDetailsSection();
         AccountPage.pressManagePersonalInformationSection();
         Verifications.verifyElementExists(driver, AccountPage.getCheckManagePersonalInformationPageHeader());
         Verifications.verifyElementExists(driver, AccountPage.getCheckManagePersonalInformationPageContent());
         AccountPage.pressManagePersonalInformationEditButton();
         Assertions.assertElementExists(driver,AccountPage.getCheckManagePersonalInformationEditContent());
     }


      @Test(dependsOnMethods = "CheckPersonalDetailsSection")
      public void CheckDownloadDataRequest() {
          AccountPage.pressDownloadDataRequestForm();
          Verifications.verifyElementExists(driver, AccountPage.getCheckSubjectAccessRequestFormPdfIsOpened());
          AccountPage.pressPdfBackButton();
      }
       @Test(dependsOnMethods = "CheckDownloadDataRequest")
       public void CheckDeletedDataRequest() {
           AccountPage.pressDeletionRequestForm();
           Assertions.assertTrue(AccountPage.CheckDeletionRequestFormExternalPage(), "Checking if external page is opened");
           AccountPage.goBackToTheRequestInformationPage();
       }
      @Test(dependsOnMethods = "CheckDeletedDataRequest")
        public void CheckMangePersonalInformationPage() {
        AccountPage.pressBackButtonForTheRequestInformationPage();
        Verifications.verifyElementExists(driver,AccountPage.getCheckPersonalDetailsPageHeader());
        AccountPage.pressManagePersonalInformationSection();
        AccountPage.pressCloseButtonForManagePersonalInformationSection();
        Assertions.assertElementExists(driver,HomePage.getCheckTheVodafoneLogo());
    }
}
