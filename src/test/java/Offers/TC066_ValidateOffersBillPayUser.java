package Offers;


import Pages.Home;
import Pages.Login;
import Pages.Offers;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC066_ValidateOffersBillPayUser {
    private AppiumDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Offers OffersPage;
    private JSONFileManager users;


    @BeforeClass
    public void beforeClass() {
        driver = (AppiumDriver) BrowserFactory.getBrowser();
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        OffersPage = new Offers(driver);
        String username = users.getTestData("BillPayUserWithoutAddOns.username");
        String password = users.getTestData("BillPayUserWithoutAddOns.password");
        LoginPage.login(username, password).acceptPermissions();
    }

    @Test
    public void CheckDiscoverySection() {
        HomePage.checkDiscoverySection();
    }

    @Test(dependsOnMethods = "CheckDiscoverySection")
    public void ValidateSeeAllOffersLink() {
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementExists(driver, OffersPage.getOffersHeader_text());
    }

    @Test(dependsOnMethods = "ValidateSeeAllOffersLink")
    public void ValidateHeaderCloseButton() {
        OffersPage.pressHeaderCloseButton();
        Assertions.assertElementExists(driver, HomePage.getSeeAllOffers_button());
    }

    @Test(dependsOnMethods = "ValidateHeaderCloseButton")
    public void CheckOffersPageContent() {
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementExists(driver, OffersPage.getFindOutMore_button());
    }

    @Test(dependsOnMethods = "CheckOffersPageContent")
    public void CheckAnotherOffers() {
        OffersPage.swipeToAnotherOffer();
        Verifications.verifyElementExists(driver, OffersPage.getOffersHeader_text());
        Assertions.assertElementExists(driver, OffersPage.getFindOutMore_button());
    }

    @Test(dependsOnMethods = "CheckAnotherOffers")
    public void CheckExternalPage() {
        OffersPage.pressOffersButton();
        if (OffersPage.isExternalWebpageOpened()) {
            OffersPage.goBackToAppFromExternalPage();
            Assertions.assertElementExists(driver, OffersPage.getOffersHeader_text());
        } else if (OffersPage.isInternalWebpageOpened()) {
            OffersPage.goBackToAppFromInternalPage();
            Assertions.assertElementExists(driver, OffersPage.getFindOutMore_button());
        }

    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

    //Maybe we will need to add additional test for fantastic friday offer
}
