package Offers;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import Pages.Offers;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC287_ValidateOffersFixedUser {
    private WebDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private Offers OffersPage;


    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        OffersPage=new Offers(driver);
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("FixedUser.username"), jsonReader.getPassword("FixedUser.password")).acceptPermissions();
    }

    @Test
    public void CheckDiscoverySection(){
       HomePage.checkDiscoverySection();
    }

    @Test(dependsOnMethods = "CheckDiscoverySection")
    public void ValidateSeeAllOffersLink(){
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementExists(driver,OffersPage.getOffersHeader_text());
    }

    @Test(dependsOnMethods = "ValidateSeeAllOffersLink")
    public void ValidateHeaderCloseButton(){
        OffersPage.pressHeaderCloseButton();
        Assertions.assertElementExists(driver,HomePage.getSeeAllOffers_button());
    }

    @Test(dependsOnMethods = "ValidateHeaderCloseButton")
    public void CheckOffersPageContent(){
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementExists(driver,OffersPage.getFindOutMore_button());
    }

    @Test(dependsOnMethods = "CheckOffersPageContent")
    public void CheckAnotherOffers(){
        //OffersPage.swipeToAnotherOffer();
        ElementActions.waitForElementToBePresent(driver,OffersPage.getSwipeLeft_button(),5,true);
        //ElementActions.performTouchAction(driver).tap(SwipeLeft_button);
        ElementActions.click(driver,OffersPage.getSwipeLeft_button());
        Verifications.verifyElementExists(driver,OffersPage.getOffersHeader_text());
        Assertions.assertElementExists(driver,OffersPage.getFindOutMore_button());
    }

    @Test(dependsOnMethods = "CheckAnotherOffers")
    public void CheckExternalPage(){
        OffersPage.pressOffersButton();
        if (OffersPage.isExternalWebpageOpened()){
            OffersPage.goBackToAppFromExternalPage();
            Assertions.assertElementExists(driver,OffersPage.getOffersHeader_text());
        }
        else if(OffersPage.isInternalWebpageOpened()){
            OffersPage.goBackToAppFromInternalPage();
            Assertions.assertElementExists(driver,OffersPage.getFindOutMore_button());
        }

    }

    //Maybe we will need to add additional test for fantastic friday offer
}
