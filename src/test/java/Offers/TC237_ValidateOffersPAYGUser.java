package Offers;

import Pages.Home;
import Pages.Login;
import Pages.Offers;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC237_ValidateOffersPAYGUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Offers OffersPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        OffersPage = new Offers(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();
    }

    @Test
    public void CheckDiscoverySection() {
        Assertions.assertTrue(HomePage.checkDiscoverySection());
    }

    @Test(dependsOnMethods = "CheckDiscoverySection")
    public void ValidateSeeAllOffersLink() {
        HomePage.pressSeeAllOffersLink();
        Assertions.assertElementAttribute(driver, OffersPage.getOffersHeader_text(),
                "text", "Offers");
    }

}
