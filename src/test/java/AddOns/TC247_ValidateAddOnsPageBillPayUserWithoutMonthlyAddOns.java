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

public class TC247_ValidateAddOnsPageBillPayUserWithoutMonthlyAddOns {
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
        LoginPage.acceptTermsAndConditions().login(GetUserFromJson.getUsername("BillPayUserWithoutAddOns"), GetUserFromJson.getpassword("BillPayUserWithoutAddOns")).acceptPermissions();
    }

    @Test
    public void CheckEssentialsSection() {
        Assertions.assertTrue(HomePage.checkEssentialsSection()); //Here scrolling is not working

    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsPage() {
        HomePage.opedAddOnsOverlay();
        AddOnsPage.openAddOnsPage();
        Verifications.verifyElementAttribute(driver, AddOnsPage.getAddOnsHeader_text(),
                "text", "Buy add ons");

        //Why the following assertion throw exception at the beginning then it pass?
        Assertions.assertElementExists(driver,AddOnsPage.getManageAddOns_button(),
                Assertions.AssertionType.NEGATIVE,"Check That Manage AddOns Button Is Not Displayed");
    }

}
