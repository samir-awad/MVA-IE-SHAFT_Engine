package testCaseSample;

import Pages.Home;
import Pages.Login;
import com.shaft.cli.FileActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginToDashboardWithPAYGUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("mobile_app", FileActions.getAbsolutePath(System.getProperty("testDataFolderPath") + "apk/", "DIG18180Fix.apk"));
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage=new Home(driver);
    }

  //How can we handle this case? DependsOnMethods or one test case ? DependsOnMethods

    @Test
    public void AcceptTermsAndConditions() {
        LoginPage.acceptTermsAndConditions();
        //Use assertion by default
        Assertions.assertElementExists(driver, LoginPage.getVodafone_Logo(), "I'm On Login & Register Page");
    }

    @Test(dependsOnMethods = {"AcceptTermsAndConditions"})
    public void Login() {
        LoginPage.login();
        Assertions.assertElementExists(driver, LoginPage.getLetsGo_Button(), "I'm on Lets go page");
    }

    @Test(dependsOnMethods = {"AcceptTermsAndConditions","Login"})
    public void GoToDashboard() {
        LoginPage.acceptPermissions();
        Assertions.assertElementExists(driver, HomePage.getDiscover_text(), "I'm on home page");
    }

}
