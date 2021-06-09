package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC031_VerifySkipTutorialButtonsBillPayCustomer {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
    }

    @Test
    public void AcceptTermsAndConditionsAndLogin() {
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("BillPayUser.username"), jsonReader.getPassword("BillPayUser.password")).acceptPermissions();
    }

    @Test(dependsOnMethods = "AcceptTermsAndConditionsAndLogin")
    public void CheckSkipButton() {
        Assertions.assertElementExists(driver, HomePage.getTakeQuickTour_Tile());
        ElementActions.performTouchAction(driver).tap(HomePage.getTakeQuickTour_Tile());
        Assertions.assertElementExists(driver, LoginPage.getSkip_button());
        ElementActions.performTouchAction(driver).tap(LoginPage.getSkip_button());
    }
}
