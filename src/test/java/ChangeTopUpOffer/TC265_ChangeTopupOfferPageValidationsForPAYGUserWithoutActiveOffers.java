package ChangeTopUpOffer;

import FileReaders.jsonReader;
import Pages.ChangeTopUpOffer;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC265_ChangeTopupOfferPageValidationsForPAYGUserWithoutActiveOffers {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private ChangeTopUpOffer ChangeTopUpOfferPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        ChangeTopUpOfferPage = new ChangeTopUpOffer(driver);

    }
    @Test
    public void Login(){
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("PAYGWithoutTopUpOffer.username"), jsonReader.getUserName("PAYGWithoutTopUpOffer.password")).acceptPermissionsPAYGUser();
    }

    @Test(dependsOnMethods = "Login")
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = "CheckEssentialsSection")
    public void pressChangeTopUpOfferOptionAndTopUpOfferPageHeader() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferPage.getChangeToUpOfferDashboard_button());
        Assertions.assertElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferHeader_text());
    }

    @Test(dependsOnMethods = "pressChangeTopUpOfferOptionAndTopUpOfferPageHeader")
    public void checkTextForUserWithoutActiveOffersAndAvailableOffersComponent() {
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getChangeTopUpOfferClose_button());
        Assertions.assertElementExists(driver, ChangeTopUpOfferPage.getNoTopUpOffer_text());
    }

    @Test(dependsOnMethods = "checkTextForUserWithoutActiveOffersAndAvailableOffersComponent")
    public void checkAvailableOffersComponent() {
        Verifications.verifyElementExists(driver, ChangeTopUpOfferPage.getFirstOfferComponent());
        Assertions.assertElementExists(driver, ChangeTopUpOfferPage.getSecondOfferComponent());
    }
}
