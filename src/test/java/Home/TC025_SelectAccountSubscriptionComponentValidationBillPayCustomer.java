package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
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
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
    }

    @Test
    public void LoginWithBillPayUser(){
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("BillPayUser.username"),jsonReader.getPassword("BillPayUser.password")).acceptPermissions();
    }

    @Test(dependsOnMethods = "LoginWithBillPayUser")
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
        ElementActions.performTouchAction(driver).tap(HomePage.getSelect_Button());
        //Verifications.verifyTrue(HomePage.checkAccountSuccessfullySelected());
        HomePage.pressSelectAccountAndSubscriptionCloseButton();
    }

    @Test(dependsOnMethods = "checkAccountSuccessfullySelected")
    public void check() {
        HomePage.pressSelectAccountAndSubscriptionComponent();
        HomePage.changeTheSelectedSubscription();
        HomePage.pressSelectAccountAndSubscriptionSelectButton();
    }

}