package Android.Home;

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
        //System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }
    @Test
    public void SelectAccountSubscriptionComponentValidationBillPayCustomer(){
        Verifications.verifyTrue(HomePage.checkTheVodafoneLogo());
        Verifications.verifyTrue(HomePage.checkSelectAccountAndSubscriptionComponent());
        HomePage.pressSelectAccountAndSubscriptionComponent();
        Verifications.verifyTrue(HomePage.checkSelectAccountAndSubscriptionComponentContent());
        HomePage.changeTheSelectedSubscription();
        HomePage.changeTheSelectedAccount();
        Verifications.verifyTrue(HomePage.checkAccountSuccessfullySelected());
        HomePage.pressSelectAccountAndSubscriptionCloseButton();
        HomePage.pressSelectAccountAndSubscriptionComponent();
        HomePage.changeTheSelectedSubscription();
        HomePage.pressSelectAccountAndSubscriptionSelectButton();

    }
}
