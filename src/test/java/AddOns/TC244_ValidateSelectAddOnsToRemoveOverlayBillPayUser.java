package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC244_ValidateSelectAddOnsToRemoveOverlayBillPayUser {
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

    @Test(dependsOnMethods = "CheckEssentialsSection")
    public void CheckSelectAddOnsToRemoveOverlay() {
        HomePage.opedAddOnsOverlay();
        AddOnsPage.openManageAddOnsOverlay();
        Assertions.assertElementAttribute(driver, AddOnsPage.getManageAddOnsOverlayHeader_text(),
                "text", "Select add ons to remove",
                Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection","CheckSelectAddOnsToRemoveOverlay"})
    public void ValidateSelectAddOnsToRemoveOverlay(){
        AddOnsPage.closeAddOnsOverlay(); //using "X" button
        HomePage.opedAddOnsOverlay();
        AddOnsPage.openManageAddOnsOverlay();
        AddOnsPage.closeSelectAddOnsToRemoveOverlay(); //using "Cancel" button
        Verifications.verifyElementAttribute(driver, AddOnsPage.getAddOnsHeaderOverlay_text(),
                "text", "My add ons",
                Verifications.VerificationComparisonType.CONTAINS, Verifications.VerificationType.POSITIVE);

        Assertions.assertElementAttribute(driver, AddOnsPage.getAddOnsExpiresOverlay_text(),
                "text", "Expires",
                Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }


}
