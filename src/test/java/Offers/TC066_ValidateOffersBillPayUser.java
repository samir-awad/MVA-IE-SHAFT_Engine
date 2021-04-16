package Offers;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import Pages.Offers;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
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
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();
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

    @Test(dependsOnMethods = "CheckOffersPageContent")
    public void CheckAnotherOffers(){
        OffersPage.swipeToAnotherOffer();
        Verifications.verifyElementAttribute(driver,OffersPage.getOffersHeader_text(),
                "text","Offers");
        Assertions.assertElementAttribute(driver,OffersPage.getFindOutMore_button(),
                "text","Find out more","Checking offers content");
    }

    @Test(dependsOnMethods = "CheckAnotherOffers")
    public void CheckExternalPage(){
        OffersPage.pressOffersButton();
        if (OffersPage.isExternalWebpageOpened()){
            OffersPage.goBackToAppFromExternalPage();
            Assertions.assertElementAttribute(driver,OffersPage.getOffersHeader_text(),
                    "text","Offers","Checking if you went back to offers page from external offers page");
        }
        else if(OffersPage.isInternalWebpageOpened()){
            OffersPage.goBackToAppFromInternalPage();
            Assertions.assertElementAttribute(driver,OffersPage.getFindOutMore_button(),
                    "text","Find out more","Checking if you went back from internal offers page");
        }

    }

    //Maybe we will need to add additional test for fantastic friday offer
}
