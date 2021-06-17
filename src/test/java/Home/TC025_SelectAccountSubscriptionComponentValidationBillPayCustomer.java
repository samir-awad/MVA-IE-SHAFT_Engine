package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC025_SelectAccountSubscriptionComponentValidationBillPayCustomer {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
    }

    @Test
    public void LoginWithBillPayUser() {
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("BillPayUser.username"), jsonReader.getPassword("BillPayUser.password")).acceptPermissions();
    }

    @Test(dependsOnMethods = "LoginWithBillPayUser")
    public void CheckThatImOnHomePageAndSelectAccountAndSubscriptionComponentContentAreDisplayed() {
        Verifications.verifyElementExists(driver, HomePage.getVodafoneLogo());
        Assertions.assertElementExists(driver, HomePage.getChange_button());
    }

    @Test(dependsOnMethods = "CheckThatImOnHomePageAndSelectAccountAndSubscriptionComponentContentAreDisplayed")
    public void checkSelectAccountAndSubscriptionComponentContent() {
        HomePage.pressSelectAccountAndSubscriptionComponent();
        Assertions.assertElementExists(driver, HomePage.getSelectAccountAndSubscriptionTitle());
    }

    @Test(dependsOnMethods = "checkSelectAccountAndSubscriptionComponentContent")
    public void changeTheSelectedSubscription() {
        HomePage.changeTheSelectedSubscription();
    }

    @Test(dependsOnMethods = "changeTheSelectedSubscription")
    public void checkAccountSuccessfullySelected() {
        HomePage.pressSelectAccountAndSubscriptionSelectButton();
        Verifications.verifyTrue(HomePage.checkAccountSuccessfullySelected(), Verifications.VerificationType.NEGATIVE);
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}