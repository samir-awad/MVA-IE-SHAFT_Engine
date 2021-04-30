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

public class TC156_ValidateTopUpPageAndAccessVestaPAYGUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private TopUp TopUpPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        TopUpPage= new TopUp(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("PAYGUserWithTopUp.username");
        String password = users.getTestData("PAYGUserWithTopUp.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
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
                "text","Top up 2","checking top up header");
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
        Assertions.assertElementExists(driver,TopUpPage.getCancel_button(),"checking cancel button");
    }

    @Test(dependsOnMethods = "CheckChangePaymentMethodPage")
    public void CheckingVestaPaymentExternalPage(){
        TopUpPage.pressAddPaymentCardButton();
        Verifications.verifyTrue(TopUpPage.isVestaWebpageOpened());

        //This assertion is not working as expected
        Assertions.assertElementAttribute(driver,TopUpPage.getCardType_text(),
                "text","Card Type", Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "CheckingVestaPaymentExternalPage")
    public void CheckingVestaPageCancelButton(){
        TopUpPage.scrollDownToCancelBtn();
        TopUpPage.pressCancelBtn();
        Verifications.verifyElementAttribute(driver,TopUpPage.getTopUpHeader_text(),
                "text","Top up","checking top up header");
        Verifications.verifyElementAttribute(driver,TopUpPage.getPaymentCard_text(),
                "text","Payment Card","checking payment card");
        Assertions.assertElementExists(driver,TopUpPage.getCancel_button(),"checking cancel button");
    }





}
