package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Assertions;
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
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("FixedUser.username"), jsonReader.getPassword("FixedUser.password")).acceptPermissions();
    }

    @Test
    public void ValidateFixedCustomer() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = "ValidateFixedCustomer")
    public void CheckLastBillTile() {
        Assertions.assertElementExists(driver, HomePage.getLastBileTile());
    }

    @Test(dependsOnMethods = "CheckLastBillTile")
    public void checkTvAddOnsTile() {
        Assertions.assertElementExists(driver, HomePage.getTvAddOnsTile());
    }

    @Test(dependsOnMethods = "checkTvAddOnsTile")
    public void CheckDiscoverySection() {
        HomePage.checkDiscoverySection();
    }

    @Test(dependsOnMethods = "CheckDiscoverySection")
    public void CheckEssentialsSection() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(HomePage.getEssentials_ShowMore(), TouchActions.SwipeDirection.UP);
        Assertions.assertElementExists(driver, HomePage.getEssentials_text());
    }

    @Test(dependsOnMethods = "CheckEssentialsSection")
    public void checkTrayMenuOptionsForBillPay() {
        Assertions.assertElementExists(driver, HomePage.getBillAndPayment());
    }

    @Test(dependsOnMethods = "checkTrayMenuOptionsForBillPay")
    public void ChangeSelectedSubscription() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(HomePage.getChange_button(), TouchActions.SwipeDirection.DOWN);
        HomePage.pressSelectAccountAndSubscriptionComponent();
        HomePage.changeTheSelectedSubscription();
        HomePage.pressSelectAccountAndSubscriptionSelectButton();
    }
}
