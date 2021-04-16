package Login;

import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TC094_CheckOnboardingPages_PaymentMethod_DebitDirectAndPaperlessNotSettedUp {

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

//    @Test(priority = 1)
//    public void Step1() {
//        ExtentTestManager.startTest("TC094_CheckOnboardingPages_PaymentMethod_DebitDirectAndPaperlessNotSettedUp","Check Terms And Conditions Page & Accept Terms And Conditions");
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
//        loginPageObject.LoginAction(GetUserFromJson.getUsername("IE"), GetUserFromJson.getpassword("IE"));
//        loginPageObject.OnBoardingSetUpDirectDebit();
//        loginPageObject.BackBtn.click();
//        loginPageObject.SetUpDirectDebitBtn.isDisplayed();
//        System.out.println("Direct Debit Is Not Setted Up");
//    }
}
