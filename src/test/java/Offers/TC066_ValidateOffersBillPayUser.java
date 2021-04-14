package Offers;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import Pages.Offers;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC066_ValidateOffersBillPayUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Offers OffersPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        OffersPage=new Offers(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();
    }

    @Test
    public void CheckDiscoverySection(){
        Assertions.assertTrue(HomePage.checkDiscoverySection());
    }

    @Test(dependsOnMethods = "CheckDiscoverySection")
    public void ValidateSeeAllOffersLink(){
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementAttribute(driver,OffersPage.getOffersHeader_text(),
                "text","Offers");
    }

    @Test(dependsOnMethods = "ValidateSeeAllOffersLink")
    public void ValidateHeaderCloseButton(){
        OffersPage.pressHeaderCloseButton();
        Assertions.assertElementExists(driver,HomePage.getSeeAllOffers_button());
    }

    @Test(dependsOnMethods = "ValidateHeaderCloseButton")
    public void CheckOffersPageContent(){
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementAttribute(driver,OffersPage.getFindOutMore_button(),
                "text","Find out more","Checking offers content");
    }





}
