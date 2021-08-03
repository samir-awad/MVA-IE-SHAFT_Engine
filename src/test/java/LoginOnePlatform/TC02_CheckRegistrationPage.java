package LoginOnePlatform;

import PagesOnePlatform.ForgetPassword;
import PagesOnePlatform.Register;
import PagesOnePlatform.Tutorial;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_CheckRegistrationPage {
    private AppiumDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = (AppiumDriver) BrowserFactory.getBrowser();
    }

    @Test
    public void CheckRegistrationPageHeader() {
        var registrationHeader=new Tutorial(driver).openRegisterPage().getRegisterTitle_text();
                Assertions.assertElementAttribute(driver,
                registrationHeader,
                "text",
                "Register for My Vodafone",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "CheckRegistrationPageHeader")
    public void CheckSendToken(){
       var tokenButton= new Register(driver).enterPhoneNumber("0811111111").getSendToken_button();
        Assertions.assertElementAttribute(driver,
               tokenButton,
                "enabled",
                "true");
    }

    @Test(dependsOnMethods = "CheckSendToken")
    public void CheckRegisterHereButton(){
      var forgetPasswordHeader =new Register(driver)
              .clickRegisterHereButton()
              .getResetYourPasswordHeader_text();
      Assertions.assertElementAttribute(driver,
              forgetPasswordHeader,
             "text" ,
              "Reset your password");
    }

    @Test(dependsOnMethods = "CheckRegisterHereButton")
    public void CheckForgetPasswordBackButton(){
        var registerHeader= new ForgetPassword(driver).goBackToRegister().getRegisterTitle_text();
        Assertions.assertElementAttribute(driver,
                registerHeader,
                "text",
                "Register for My Vodafone",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

}
