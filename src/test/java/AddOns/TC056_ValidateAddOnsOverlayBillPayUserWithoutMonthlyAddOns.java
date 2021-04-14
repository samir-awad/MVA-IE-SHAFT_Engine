package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC056_ValidateAddOnsOverlayBillPayUserWithoutMonthlyAddOns {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage=new AddOns(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
    }

    @Test
    public void CheckEssentialsSection() {
        Assertions.assertTrue(HomePage.checkEssentialsSection());
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsOverlayText() {
    HomePage.opedAddOnsOverlay();
        Verifications.verifyTrue(AddOnsPage.checkAddOnsOverlay());
        Assertions.assertElementAttribute(driver,AddOnsPage.getNoActiveAddOnsOverlayTxt(),"text","No active Add Ons");
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection","ValidateAddOnsOverlay"})
    public void ValidateAddOnsOverlayCloseButton(){
        AddOnsPage.closeAddOnsOverlayBtn();
        Assertions.assertElementAttribute(driver,HomePage.getEssentials_text(),"text","Essentials");
    }


}
