package AddOns;

import FileReaders.GetUserFromJson;
import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC056_ValidateAddOnsOverlayBillPayUserWithoutMonthlyAddOns {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage=new AddOns(driver);
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions(
        LoginPage.acceptTermsAndConditions().login(GetUserFromJson.getUsername("BillPayUserWithoutAddOns"), GetUserFromJson.getpassword("BillPayUserWithoutAddOns")).acceptPermissions();
    }

    @Test
    public void CheckEssentialsSection() {
        Assertions.assertTrue(HomePage.checkEssentialsSection());
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsOverlayText() {
    HomePage.opedAddOnsOverlay();
        Verifications.verifyTrue(AddOnsPage.checkAddOnsOverlay());
        Assertions.assertElementAttribute(driver,AddOnsPage.getNoActiveAddOnsOverlay_text(),
                "text","You have no active add ons.",
                Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "ValidateAddOnsOverlayText")
    public void ValidateAddOnsOverlayCloseButton(){
        AddOnsPage.closeAddOnsOverlay();
        Assertions.assertElementAttribute(driver,HomePage.getEssentials_text(),
                "text","Essentials");
    }


}
