package AddOns;


import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC248_ValidateAddOnsPagePAYGUserWithMonthlyAddOns {
    private WebDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("PAYGUserWithTopUp.username");
        String password = users.getTestData("PAYGUserWithTopUp.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsPage() {
        HomePage.opedAddOnsOverlay();
        AddOnsPage.openAddOnsPage();
        Verifications.verifyElementExists(driver, AddOnsPage.getAddOnsHeader_text());
        Verifications.verifyElementExists(driver, AddOnsPage.getOneOff_tab());
        Verifications.verifyElementExists(driver, AddOnsPage.getAddOneFirstListPAYG_text());
        Verifications.verifyElementExists(driver, AddOnsPage.getAddOnsContinue_button());
        Assertions.assertElementExists(driver, AddOnsPage.getManageAddOns_button());
    }

    @Test(dependsOnMethods = "ValidateAddOnsPage")
    public void CheckBuyAddOnsSelectButton() {
        AddOnsPage.pressFirstAddOnSelectButton();
        Assertions.assertElementExists(driver, AddOnsPage.getSelect_text());
    }

    @Test(dependsOnMethods = "CheckBuyAddOnsSelectButton")
    public void CheckBuyAddOnsOverlay() {
        AddOnsPage.pressBuyAddOnsContinueButton();
        Assertions.assertElementExists(driver, AddOnsPage.getBuyAddOnsHeaderOverlay_text());
    }

    @Test(dependsOnMethods = "CheckBuyAddOnsOverlay")
    public void CheckBuyAddOnsCloseButton() {
        AddOnsPage.pressBuyAddOnsOverlayCloseButton();
        AddOnsPage.closeAddOnsPage();
        Assertions.assertElementExists(driver, HomePage.getBuyAndManageAddOns_text());
    }

}
