package Offers;

import FileReaders.GetUserFromJson;
import Pages.Home;
import Pages.Login;
import Pages.Offers;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC237_ValidateOffersPAYGUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Offers OffersPage;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        OffersPage = new Offers(driver);
        LoginPage.acceptTermsAndConditions().login(GetUserFromJson.getUsername("PAYGUser"), GetUserFromJson.getpassword("PAYGUser")).acceptPermissions();
    }

    @Test
    public void CheckDiscoverySection() {
        Assertions.assertTrue(HomePage.checkDiscoverySection());
    }

    @Test(dependsOnMethods = "CheckDiscoverySection")
    public void CheckOffersPageHeader() {
        HomePage.openOffersPageHeader();
        Assertions.assertElementAttribute(driver, OffersPage.getOffersHeader_text(),
                "text", "Offers", "Checking offers header");
    }

    @Test(dependsOnMethods = "CheckOffersPageHeader")
    public void ValidateHeaderCloseButton() {
        OffersPage.pressHeaderCloseButton();
        Assertions.assertElementExists(driver, HomePage.getSeeAllOffers_button(),
                "Checking close button from offer page header");
    }

    @Test(dependsOnMethods = "ValidateHeaderCloseButton")
    public void ValidateSeeAllOffersLink() {
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementAttribute(driver, OffersPage.getOffersHeader_text(),
                "text", "Offers");
    }

    @Test(dependsOnMethods = "ValidateSeeAllOffersLink")
    public void ValidateOffersCloseButton() {
        OffersPage.pressHeaderCloseButton();
        Assertions.assertElementExists(driver, HomePage.getSeeAllOffers_button(),
                "Checking close button from see all offers link");
    }

    @Test(dependsOnMethods = "ValidateOffersCloseButton")
    public void CheckOffersPageContent() {
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementExists(driver, OffersPage.getFirstOfferTitle_button(),
                "Check existence of first offer");
    }

    @Test(dependsOnMethods = "CheckOffersPageContent")
    public void CheckFirstOfferContent() {
        OffersPage.expandFirstOffer();
        Assertions.assertElementExists(driver, OffersPage.getFirstOfferContinue_button(), "Checking continue button of first offer");
    }

    @Test(dependsOnMethods = "CheckFirstOfferContent")
    public void CheckExternalPage() {
        OffersPage.openExternalPage();
        Assertions.assertTrue(OffersPage.isExternalWebpageOpened(), "Checking if external page is opened");
    }

    @Test(dependsOnMethods = "CheckExternalPage")
    public void CheckGoBackToAppFromExternalPage() {
        OffersPage.goBackToAppFromExternalPage();
        Assertions.assertElementAttribute(driver, OffersPage.getOffersHeader_text(),
                "text", "Offers", "Checking if you went back to offers page from external offers page");
    }


}
