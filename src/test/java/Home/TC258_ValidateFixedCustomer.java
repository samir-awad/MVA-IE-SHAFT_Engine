package Home;

import FileReaders.GetUserFromJson;
import Pages.Home;
import Pages.Login;
import com.shaft.cli.FileActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC258_ValidateFixedCustomer {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        //  LoginPage.login(GetUserFromJson.getUsername("FixedUser"), GetUserFromJson.getpassword("FixedUser"));
        LoginPage.acceptTermsAndConditions().login(GetUserFromJson.getUsername("FixedUser"), GetUserFromJson.getpassword("FixedUser")).acceptPermissions();
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }

    @Test
    public void ValidateFixedCustomer() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test
    public void CheckLastBillTile() {
        Assertions.assertElementExists(driver, HomePage.getLastBileTile());
    }

    @Test
    public void CheckDiscoverySection() {
        HomePage.checkDiscoverySection();
    }

    @Test
    public void CheckEssentialsSection() {
        HomePage.checkEssentialsSection();
    }

    @Test
    public void ChangeSelectedSubscription() {
        HomePage.pressSelectAccountAndSubscriptionComponent();
        HomePage.changeTheSelectedSubscription();
        HomePage.pressSelectAccountAndSubscriptionSelectButton();
    }

    @Test
    public void checkTvAddOnsTile() {
        Assertions.assertElementExists(driver, HomePage.getTvAddOnsTile());
    }

    @Test
    public void checkEssentialsSectionFixedWithTv() {
        Assertions.assertElementExists(driver, HomePage.getEssentialsSectionFixed_WithTV());
    }

    @Test
    public void checkTrayMenuOptionsForBillPay() {
        Assertions.assertElementExists(driver, HomePage.getBillAndPayment());
    }
}
