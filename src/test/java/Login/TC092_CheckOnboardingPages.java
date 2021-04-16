package Login;

import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TC092_CheckOnboardingPages{

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

//    @Test(priority = 1)
//    public void Step1() {
//        ExtentTestManager.startTest("TC092_CheckOnboardingPages","Check Terms And Conditions Page & Accept Terms And Conditions");
//        System.out.println("Step 1 : accept And Continue In Terms And Conditions");
//        loginPageObject = new LoginPage(GlobalDriver.appium);
//        loginPageObject.AcceptAndContinue();
//    }
//
//    @Test(priority = 2)
//    public void Step2() throws IOException, ParseException {
//        System.out.println("Step 2");
//        loginPageObject.VfLogo.isDisplayed();
//        System.out.println("I'm On Login & Register Page");
//        loginPageObject.RegLoginBtn.click();
//        loginPageObject.LoginAction(GetUserFromJson.getUsername("IE"),GetUserFromJson.getpassword("IE"));
//        loginPageObject.LetsGoBtn.isDisplayed();
//    }
//
//    @Test(priority = 3)
//    public void Step3(){
//        loginPageObject.LetsGoBtn.click();
//
//    }
}
