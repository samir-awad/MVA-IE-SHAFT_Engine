package ChangeTopUpOffer;

import FileReaders.jsonReader;
import Pages.ChangeTopUpOffer;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC266_ChangeTopupOfferPageValidationsForPAYGUserWithActiveOffers {
    public MobileDriver driver;
    public Login LoginPage;
    public Home HomePage;
    public ChangeTopUpOffer ChangeTopUpOfferPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        ChangeTopUpOfferPage = new ChangeTopUpOffer(driver);
    }

    @Test
    public void Login() {
        LoginPage.acceptTermsAndConditions();
        LoginPage.login(jsonReader.getUserName("PAYGUserWithTopUp.username"), jsonReader.getUserName("PAYGUserWithTopUp.password")).
                acceptPermissionsPAYGUser();
    }

    @Test(dependsOnMethods = "Login")
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = "CheckEssentialsSection")
    public void pressChangeTopUpOfferOptionAndTopUpOfferOverlayComponents() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferPage.getChangeToUpOfferDashboard_button());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetails_title());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetails_OfferName());
        Assertions.assertElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetailsOffer_MuchMore());
    }

    @Test(dependsOnMethods = "pressChangeTopUpOfferOptionAndTopUpOfferOverlayComponents")
    public void ClickOnChangeTopUpOfferAndCheckHeaderAndCurrentOffer() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferPage.getChangeTopUpOffer_button());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferHeader_text());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getYourTopUpOffer_title());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getCurrentTopUpOffer_name());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getCurrentTopUpOffer_title());
        Assertions.assertElementExists(driver, ChangeTopUpOfferPage.getCurrentTopUpOffer_value());
    }

    @Test(dependsOnMethods = "ClickOnChangeTopUpOfferAndCheckHeaderAndCurrentOffer")
    public void ClickOnViewDetailsOfCurrentTopUpOfferAndCheckTheOverlay() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferPage.getViewDetailsCurrentTopUpOffer_button());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetails_title());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetails_OfferName());
        Assertions.assertElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetailsOffer_MuchMore());
    }

    @Test(dependsOnMethods = "ClickOnViewDetailsOfCurrentTopUpOfferAndCheckTheOverlay")
    public void CloseCurrentOfferDetailsAndCheckAvailableOfferComponents() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferPage.getChangeTopUpOfferOverlay_CloseButton());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getFirstOfferComponent());
        Assertions.assertElementExists(driver, ChangeTopUpOfferPage.getSecondOfferComponent());
    }

    @Test(dependsOnMethods = "ClickOnViewDetailsOfCurrentTopUpOfferAndCheckTheOverlay")
    public void ClickOnViewAvailableOfferDetailsAndCheckTheOverlay() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferPage.getViewDetailsNewTopUpOffer_button());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetails_title());
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetails_OfferName());
        Assertions.assertElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferDetailsOffer_MuchMore());
    }

    @Test(dependsOnMethods = "ClickOnViewDetailsOfCurrentTopUpOfferAndCheckTheOverlay")
    public void CloseCurrentOfferDetailsAndPressOnOptIn() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferPage.getChangeTopUpOfferOverlay_CloseButton());
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferPage.getOptIn_button());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
