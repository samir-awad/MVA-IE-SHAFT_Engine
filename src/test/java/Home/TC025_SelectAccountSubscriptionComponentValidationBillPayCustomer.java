package Home;

import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC025_SelectAccountSubscriptionComponentValidationBillPayCustomer {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("executionAddress", "0.0.0.0:4723");
        System.setProperty("targetOperatingSystem", "iOS");
        System.setProperty("mobile_platformVersion", "14.4");
        System.setProperty("mobile_deviceName", "iPhone");
        System.setProperty("mobile_automationName", "XCUITest");
        System.setProperty("mobile_udid", "00008030-001C4D5C1E33802E");
        System.setProperty("mobile_bundleId", "com.VodafoneIreland.MyVodafone");
        System.setProperty("mobile_derivedDataPath", "/Users/mva-ireland/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        //LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
    }

    @Test
    public void CheckThatImOnHomePageAndSelectAccountAndSubscriptionComponentContentAreDisplayed() {
        Verifications.verifyElementExists(driver, HomePage.getVodafoneLogo());
        Assertions.assertElementExists(driver, HomePage.getChange_button());
    }

    @Test(dependsOnMethods = "CheckThatImOnHomePageAndSelectAccountAndSubscriptionComponentContentAreDisplayed")
    public void checkSelectAccountAndSubscriptionComponentContent() {
        HomePage.pressSelectAccountAndSubscriptionComponent();
        Assertions.assertElementExists(driver,HomePage.getSelectAccountAndSubscriptionTitle());
    }

    @Test(dependsOnMethods = "checkSelectAccountAndSubscriptionComponentContent")
    public void changeTheSelectedSubscription() {
        HomePage.changeTheSelectedSubscription();
    }

    @Test(dependsOnMethods = "changeTheSelectedSubscription")
    public void checkAccountSuccessfullySelected() {
        HomePage.changeTheSelectedAccount();
        Verifications.verifyTrue(HomePage.checkAccountSuccessfullySelected());
        HomePage.pressSelectAccountAndSubscriptionCloseButton();
    }

    @Test(dependsOnMethods = "checkAccountSuccessfullySelected")
    public void check() {
        HomePage.pressSelectAccountAndSubscriptionComponent();
        HomePage.changeTheSelectedSubscription();
        HomePage.pressSelectAccountAndSubscriptionSelectButton();
    }

}