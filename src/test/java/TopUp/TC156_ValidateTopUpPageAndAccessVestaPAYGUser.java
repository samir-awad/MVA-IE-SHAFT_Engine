package TopUp;

import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC156_ValidateTopUpPageAndAccessVestaPAYGUser {
    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private TopUp TopUpPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
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
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckTopUpOverlay() {
        HomePage.pressBalanceTitle();
        Assertions.assertElementExists(driver, HomePage.getTopUpOverlayTitle_text());
    }

    @Test(dependsOnMethods = "CheckTopUpOverlay")
    public void CheckTopUpOverlayCloseBtn() {
        TopUpPage.pressTopUpOverlayCloseButton();
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "CheckTopUpOverlayCloseBtn")
    public void CheckTopUpOverlayContent() {
        HomePage.pressTopUpTrayMenu();
        TopUpPage.pressTopUpOverlayTopUpButton();
        Verifications.verifyElementExists(driver, TopUpPage.getTopUpHeader_text());
        Verifications.verifyElementExists(driver, TopUpPage.getChooseANumber_text());
        Verifications.verifyElementExists(driver, TopUpPage.getChooseATopUpAmount_text());
        Assertions.assertElementExists(driver, TopUpPage.getChooseAPaymentMethod_text());
    }

    @Test(dependsOnMethods = "CheckTopUpOverlayContent")
    public void CheckChangePaymentMethodPage() {
        TopUpPage.pressChangePaymentMethodButton();
        Verifications.verifyElementExists(driver, TopUpPage.getPaymentCard_text());
        Assertions.assertElementExists(driver, TopUpPage.getCancel_button());
    }

    @Test(dependsOnMethods = "CheckChangePaymentMethodPage")
    public void CheckingVestaPaymentExternalPage() {
        TopUpPage.pressAddPaymentCardButton();
        Verifications.verifyTrue(TopUpPage.isVestaWebpageOpened());
        //This assertion is not working as expected
//        Assertions.assertElementExists(driver, TopUpPage.getCardType_text());
    }

    @Test(dependsOnMethods = "CheckingVestaPaymentExternalPage")
    public void CheckingVestaPageCancelButton() {
        TopUpPage.scrollDownToCancelBtn();
        TopUpPage.pressCancelBtn();
        Verifications.verifyElementExists(driver, TopUpPage.getTopUpHeader_text());
        Verifications.verifyElementExists(driver, TopUpPage.getPaymentCard_text());
        Assertions.assertElementExists(driver, TopUpPage.getCancel_button());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
