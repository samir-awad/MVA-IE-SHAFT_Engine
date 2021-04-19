package AddOns;

import FileReaders.GetUserFromJson;
import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC168_ValidateAddOnsOverlayPAYGUserWithMonthlyAddOns {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        LoginPage.acceptTermsAndConditions().login(GetUserFromJson.getUsername("PAYGUser"), GetUserFromJson.getpassword("PAYGUser")).acceptPermissions();

    }

    @Test
    public void CheckEssentialsSection() {
        Assertions.assertTrue(HomePage.checkEssentialsSection());
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsOverlayText() {
        HomePage.opedAddOnsOverlay();
        Assertions.assertElementAttribute(driver,AddOnsPage.getAddOnsExpiresOverlay_text(),"text","Expires", Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = {"ValidateAddOnsOverlayText"})
    public void ValidateAddOnsOverlayCloseButton(){
        AddOnsPage.closeAddOnsOverlay();
        Assertions.assertElementAttribute(driver,HomePage.getEssentials_text(),"text","Essentials");
    }

}
