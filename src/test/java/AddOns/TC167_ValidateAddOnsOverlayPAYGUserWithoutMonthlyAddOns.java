package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC167_ValidateAddOnsOverlayPAYGUserWithoutMonthlyAddOns {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("PAYGUserWithoutAddOns.username");
        String password = users.getTestData("PAYGUserWithoutAddOns.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsOverlayText() {
        HomePage.opedAddOnsOverlay();
        Verifications.verifyTrue(AddOnsPage.checkAddOnsOverlay());
        Assertions.assertElementAttribute(driver, AddOnsPage.getNoActiveAddOnsOverlay_text(),
                "text", "You have no active add ons.",
                Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = {"ValidateAddOnsOverlayText"})
    public void ValidateAddOnsOverlayCloseButton() {
        AddOnsPage.closeAddOnsOverlay();
        Assertions.assertElementExists(driver, HomePage.getEssentials_text());
    }
}
