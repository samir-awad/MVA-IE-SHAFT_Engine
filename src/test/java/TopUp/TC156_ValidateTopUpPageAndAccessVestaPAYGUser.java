package TopUp;

import FileReaders.GetUserFromJson;
import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC156_ValidateTopUpPageAndAccessVestaPAYGUser {
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
        Assertions.assertTrue(HomePage.checkTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckTopUpOverlay(){
        HomePage.pressBalanceTitle();
        Assertions.assertElementExists(driver,HomePage.getTopUpOverlayTitle_text(),
                "text","Top Up","checkTopUpOverlay");
    }

    @Test(dependsOnMethods = "CheckTopUpOverlay")
    public void CheckTopUpOverlayCloseBtn(){
        TopUpPage.pressTopUpOverlayCloseButton();
        Assertions.assertTrue(HomePage.checkTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckTopUpOverlayCloseBtn")
    public void CheckTopUpOverlayContent(){
        HomePage.pressTopUpTrayMenu();
        TopUpPage.pressTopUpOverlayTopUpButton();
        Verifications.verifyElementAttribute(driver,TopUpPage.getTopUpHeader_text(),
                "text","Top up","checking top up header");
        Verifications.verifyElementAttribute(driver,TopUpPage.getChooseANumber_text(),
                "text","Choose a number","checking top up page first title");
        Verifications.verifyElementAttribute(driver,TopUpPage.getChooseATopUpAmount_text(),
                "text","Choose a top up amount","checking top up page second title");
        Assertions.assertElementAttribute(driver,TopUpPage.getChooseAPaymentMethod_text(),
                "text","Choose a payment method","checking top up page third title");
    }

    @Test(dependsOnMethods = "CheckTopUpOverlayContent")
    public void CheckChangePaymentMethodPage(){
        TopUpPage.pressChangePaymentMethodButton();
        Verifications.verifyElementAttribute(driver,TopUpPage.getPaymentCard_text(),
                "text","Payment Card","checking payment card ");
        Assertions.assertElementExists(driver,TopUpPage.getChangePaymentMethodCancel_button(),"checking cancel button");
    }

    @Test(dependsOnMethods = "CheckChangePaymentMethodPage")
    public void CheckingVestaPaymentExternalPage(){
        TopUpPage.pressAddPaymentCardButton();
        Verifications.verifyTrue(TopUpPage.isVestaWebpageOpened());
        
        //This assertion is not working as expected
        Assertions.assertElementAttribute(driver,TopUpPage.getAddEditCard(),
                "text","Add/Edit card", Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "CheckingVestaPaymentExternalPage")
    public void CheckingVestaPageCancelButton(){
        TopUpPage.scrollDownToCancelBtn();
        TopUpPage.pressVestaCancelBtn();
        Verifications.verifyElementAttribute(driver,TopUpPage.getTopUpHeader_text(),
                "text","Top up","checking top up header");
        Verifications.verifyElementAttribute(driver,TopUpPage.getPaymentCard_text(),
                "text","Payment Card","checking payment card ");
        Assertions.assertElementExists(driver,TopUpPage.getChangePaymentMethodCancel_button(),"checking cancel button");
    }





}