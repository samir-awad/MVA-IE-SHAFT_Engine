package TopUp;

import FileReaders.GetUserFromJson;
import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC158_ValidateMoreOptionsOverlayPAYGUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private TopUp TopUpPage;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        TopUpPage= new TopUp(driver);
        LoginPage.acceptTermsAndConditions().login(GetUserFromJson.getUsername("PAYGUserWithTopUp"), GetUserFromJson.getpassword("PAYGUserWithTopUp"));
        // LoginPage.acceptPermissions();
    }

    @Test
    public void CheckVodafoneLogoAndWelcomeGesture(){
        Assertions.assertTrue(HomePage.checkTheVodafoneLogo(),"checking vodafone logo And Welcome Gesture");
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckMoreOptionsOverlay(){
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayMoreOptionsButton();
        Assertions.assertElementAttribute(driver,TopUpPage.getMoreOptionOverlayHeader_text(),
                "text","More options","checking more options overlay header");
    }

    @Test(dependsOnMethods = "CheckMoreOptionsOverlay")
    public void ValidateMoreOptionsOverlayBackBtn(){

    }



}
