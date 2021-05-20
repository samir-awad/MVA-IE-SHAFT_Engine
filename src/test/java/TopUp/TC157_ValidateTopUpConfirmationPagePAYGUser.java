package TopUp;

import FileReaders.GetUserFromJson;
import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC157_ValidateTopUpConfirmationPagePAYGUser {
    private WebDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private TopUp TopUpPage;

    @BeforeClass
    public void beforeClass()  {
        System.setProperty("mobile_app",System.getProperty("user.dir")+"//App//144_AUTO.apk");
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        TopUpPage = new TopUp(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("PAYGUserWithTopUp.username");
        String password = users.getTestData("PAYGUserWithTopUp.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test

    public void CheckVodafoneLogoAndWelcomeGesture() {
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckTopUpPage() {
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayTopUpButton();
        Assertions.assertElementExists(driver, TopUpPage.getTopUpHeader_text());
    }

    @Test(dependsOnMethods = "CheckTopUpPage")
    public void ValidateConfirmationPage() {
        TopUpPage.pressNextBtn();
        Verifications.verifyElementExists(driver, TopUpPage.getTopUpHeader_text());
        Verifications.verifyElementExists(driver, TopUpPage.getConfirmYourTopUpDetails());
    }

    @Test(dependsOnMethods = "ValidateConfirmationPage")
    public void ValidateCloseButton() {
        TopUpPage.pressCloseBtn();
        Verifications.verifyElementExists(driver, HomePage.getBalanceTitle());
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }


}
