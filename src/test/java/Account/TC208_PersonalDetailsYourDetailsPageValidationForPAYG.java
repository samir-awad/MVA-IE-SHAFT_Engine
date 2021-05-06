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

public class TC208_PersonalDetailsYourDetailsPageValidationForPAYG {

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
    public void PersonalDetailsYourDetailsPageValidationForPAYG(){
        Verifications.verifyElementExists(driver,HomePage.getCheckTheVodafoneLogo());
        AccountPage.pressAccountTrayMenuOption();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountOverlay());
        AccountPage.pressAccountSettingOption();
        Verifications.verifyElementExists(driver,AccountPage.getCheckAccountSettingsPageHeader());
        AccountPage.pressPersonalDetailsSection();
        AccountPage.pressYourDetailsSection();
        Verifications.verifyElementExists(driver,AccountPage.getCheckYourDetailsPageHeader());
        Verifications.verifyElementExists(driver,AccountPage.getCheckYourDetailsPageContent());
        AccountPage.pressYourDetailsEditButton();
        AccountPage.pressYourDetailsCancelButton();
        Verifications.verifyElementExists(driver,AccountPage.getCheckYourDetailsPageContent());
        AccountPage.pressBackButtonForDetailsPage();
        Verifications.verifyElementExists(driver,AccountPage.getCheckPersonalDetailsPageHeader());
        AccountPage.pressYourDetailsSection();
        AccountPage.pressCloseButtonForDetailsPage();
        Assertions.assertElementExists(driver,HomePage.getCheckTheVodafoneLogo());

    }
}