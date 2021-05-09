package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC023_TutorialValidationsBillPayCustomer {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
    }

    @Test
    public void AcceptTermsAndConditionsAndLogin() {
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("BillPay.username"), jsonReader.getPassword("BillPay.password"));
    }

    @Test
    public void AcceptPermissionsAndGoToTutorialFromHome() {
        LoginPage.acceptPermissions();
        Assertions.assertElementExists(driver, LoginPage.getSkip_button());
    }
}
