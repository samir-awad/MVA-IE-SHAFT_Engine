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

public class TC211_PersonalDetailsMarketingPreferencesPageValidationForPAYG {

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
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();// LoginPage.acceptPermissions();
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
     public void CheckMarketingPreferencesSection() {
         AccountPage.pressPersonalDetailsSection();
         AccountPage.pressMarketingPreferencesSection();
         Verifications.verifyElementExists(driver, AccountPage.getCheckMarketingPreferencesPageHeader());
         Verifications.verifyElementExists(driver, AccountPage.getCheckMarketingPreferencesPageContent());
         AccountPage.pressMarketingPreferencesEditButton();
         Assertions.assertElementExists(driver,AccountPage.getCheckMarketingPreferencesEditContent());
     }

      @Test(dependsOnMethods = "CheckMarketingPreferencesSection")
      public void ValidateTheMarketingPreferencesPage() {
          AccountPage.pressMarketingPreferencesCancelButton();
          Verifications.verifyElementExists(driver, AccountPage.getCheckMarketingPreferencesPageContent());
          AccountPage.pressBackButtonForMarketingPreferencesPage();
          Assertions.assertElementExists(driver,AccountPage.getCheckPersonalDetailsPageHeader());
      }
       @Test(dependsOnMethods = "ValidateTheMarketingPreferencesPage")
       public void CheckDeletedDataRequest() {
           AccountPage.pressMarketingPreferencesSection();
           AccountPage.pressCloseButtonForMarketingPreferencesPage();
           Assertions.assertElementExists(driver,HomePage.getCheckTheVodafoneLogo());
       }

}
