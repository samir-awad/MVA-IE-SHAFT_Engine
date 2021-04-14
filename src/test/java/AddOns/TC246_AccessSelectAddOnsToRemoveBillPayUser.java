package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC246_AccessSelectAddOnsToRemoveBillPayUser {
    private WebDriver driver;
    private Home HomePage;
    private AddOns AddOnsPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        Login loginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        loginPage.acceptTermsAndConditions().login().acceptPermissions();
    }

    @Test
    public void CheckEssentialsSection() {
        Assertions.assertTrue(HomePage.checkEssentialsSection());
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void CheckAccessToAddOnsPage() {
    HomePage.opedAddOnsOverlay();
    AddOnsPage.openAddOnsPage();
    Assertions.assertElementAttribute(driver,AddOnsPage.getAddOnsHeader_text(),
            "text","Buy add ons","Check add ons page is loaded");
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection","CheckAccessToAddOnsPage"})
    public void CheckAccessToSelectAddOns(){
    AddOnsPage.openManageAddOnsOverlay();
    Assertions.assertElementAttribute(driver,AddOnsPage.getManageAddOnsOverlayHeader_text(),
            "text","Select add ons to remove","checking manage add ons header");
    }

}
