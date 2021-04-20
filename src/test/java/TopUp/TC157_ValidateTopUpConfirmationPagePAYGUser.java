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
    public void beforeClass() throws IOException, ParseException {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        TopUpPage= new TopUp(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("PAYGUserWithTopUp.username");
        String password = users.getTestData("PAYGUserWithTopUp.password");
        LoginPage.acceptTermsAndConditions().login(username, password);
        // LoginPage.acceptPermissions();
    }

    @Test
    public void CheckVodafoneLogoAndWelcomeGesture(){
        Assertions.assertTrue(HomePage.checkTheVodafoneLogo(),"checking vodafone logo And Welcome Gesture");
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckTopUpPage(){
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayTopUpButton();
        Assertions.assertElementAttribute(driver,TopUpPage.getTopUpHeader_text(),
                "text","Top up","checking top up header");
    }

    @Test(dependsOnMethods = "CheckTopUpPage")
    public void ValidateConfirmationPage(){
        TopUpPage.pressNextBtn();
        Verifications.verifyElementAttribute(driver,TopUpPage.getTopUpHeader_text(),
                "text","Top up","checking top up header");
        Verifications.verifyElementAttribute(driver,TopUpPage.getConfirmYourTopUpDetails(),
                "text","Confirm your top up details",
                Verifications.VerificationComparisonType.CONTAINS, Verifications.VerificationType.POSITIVE,
                "checking content");
    }

    @Test(dependsOnMethods = "ValidateConfirmationPage")
    public void ValidateCloseButton(){
        TopUpPage.pressCloseBtn();
        Verifications.verifyElementAttribute(driver,HomePage.getBalanceTitle(),
                "text","Balance","checking you are on home page");
        Assertions.assertTrue(HomePage.checkTheVodafoneLogo(),"checking vodafone logo And Welcome Gesture");
    }


}
