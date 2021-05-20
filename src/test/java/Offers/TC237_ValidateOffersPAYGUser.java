package Offers;

import FileReaders.GetUserFromJson;
import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import Pages.Offers;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC237_ValidateOffersPAYGUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Offers OffersPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("mobile_app",System.getProperty("user.dir")+"//App//144_AUTO.apk");
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        OffersPage = new Offers(driver);
    }

    @Test
    public void CheckDiscoverySection() {
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("PAYGUser.username"), jsonReader.getPassword("PAYGUser.password")).acceptPermissionsPAYGUser();
        HomePage.checkDiscoverySection();
    }

    @Test(dependsOnMethods = "CheckDiscoverySection")
    public void CheckOffersPageHeader() {
        HomePage.openOffersPageHeader();
        Assertions.assertElementExists(driver, OffersPage.getOffersHeader_text());
    }

    @Test(dependsOnMethods = "CheckOffersPageHeader")
    public void ValidateHeaderCloseButton() {
        OffersPage.pressHeaderCloseButton();
        ElementActions.performTouchAction(driver).swipeElementIntoView(HomePage.getSeeAllOffers_button(), TouchActions.SwipeDirection.UP);
        Assertions.assertElementExists(driver, HomePage.getSeeAllOffers_button());
    }

    @Test(dependsOnMethods = "ValidateHeaderCloseButton")
    public void ValidateSeeAllOffersLink() {
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementExists(driver, OffersPage.getOffersHeader_text());
    }

    @Test(dependsOnMethods = "ValidateSeeAllOffersLink")
    public void ValidateOffersCloseButton() {
        OffersPage.pressHeaderCloseButton();
        Assertions.assertElementExists(driver, HomePage.getSeeAllOffers_button());
    }

    @Test(dependsOnMethods = "ValidateOffersCloseButton")
    public void CheckOffersPageContent() {
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementExists(driver, OffersPage.getFirstOfferTitle_button());
    }

    @Test(dependsOnMethods = "CheckOffersPageContent")
    public void CheckFirstOfferContent() {
        OffersPage.expandFirstOffer();
        Assertions.assertElementExists(driver, OffersPage.getFirstOfferContinue_button());
    }

    @Test(dependsOnMethods = "CheckFirstOfferContent")
    public void CheckExternalPage() {
        OffersPage.openExternalPage();
        Assertions.assertTrue(OffersPage.isExternalWebpageOpened());
    }

    @Test(dependsOnMethods = "CheckExternalPage")
    public void CheckGoBackToAppFromExternalPage() {
        OffersPage.goBackToAppFromExternalPage();
        Assertions.assertElementExists(driver, OffersPage.getOffersHeader_text());
    }
}
