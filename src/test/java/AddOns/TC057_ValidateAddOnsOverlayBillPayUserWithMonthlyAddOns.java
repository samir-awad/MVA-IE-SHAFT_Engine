package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC057_ValidateAddOnsOverlayBillPayUserWithMonthlyAddOns {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();
    }

    @Test
    public void CheckEssentialsSection() {
        Assertions.assertTrue(HomePage.checkEssentialsSection());
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsOverlayText() {
        HomePage.opedAddOnsOverlay();
        Assertions.assertElementAttribute(driver, AddOnsPage.getAddOnsExpiresOverlay_text(), "text",
                "Expires", Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection","ValidateAddOnsOverlayText"})
    public void ValidateAddOnsOverlayCloseButton() {
        AddOnsPage.closeAddOnsOverlay();
        Assertions.assertElementAttribute(driver, HomePage.getEssentials_text(),
                "text", "Essentials");
    }

}
