package AddOns;

import FileReaders.GetUserFromJson;
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

public class TC248_ValidateAddOnsPagePAYGUserWithMonthlyAddOns {
    private WebDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;

    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection(); //Here scrolling is not working
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsPage() {
        HomePage.opedAddOnsOverlay();
        AddOnsPage.openAddOnsPage();
        Verifications.verifyElementAttribute(driver, AddOnsPage.getAddOnsHeader_text(),
                "text", "Buy add ons");
        Assertions.assertElementExists(driver,
                AddOnsPage.getOneOff_tab(),
                Assertions.AssertionType.NEGATIVE,
                "Check Element Existence");
    }

}
