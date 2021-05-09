package Home;

import FileReaders.jsonReader;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC031_VerifySkipTutorialButtonsBillPayCustomer {

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test
    public void AcceptTermsAndConditionsAndLogin() {
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName(""), jsonReader.getPassword(""));
    }

    @Test
    public void AcceptPermissionsAndCheckSkipButton() {
        LoginPage.acceptPermissionsWithoutSkipingTutorials();
        Assertions.assertElementExists(driver, LoginPage.getSkip_button());
    }
}
