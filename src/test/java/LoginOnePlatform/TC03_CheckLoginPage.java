package LoginOnePlatform;

import PagesOnePlatform.ForgetPassword;
import PagesOnePlatform.Login;
import PagesOnePlatform.Register;
import PagesOnePlatform.Tutorial;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03_CheckLoginPage {
    private AppiumDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = (AppiumDriver) BrowserFactory.getBrowser();
    }
    @Test
    public void CheckLoginPageContent() {
        var loginHeader= new Tutorial(driver).openLoginPage().getLoginTitle_text();
        Verifications.verifyElementAttribute(driver,
                loginHeader,
                "text",
                "My Vodafone log in",
                Verifications.VerificationComparisonType.CONTAINS,
                Verifications.VerificationType.POSITIVE);

        Verifications.verifyElementExists(driver,
                new Login(driver).getLogin_button(),
                "Check existence of login button");

        Assertions.assertElementExists(driver,
                new Login(driver).getRegister_button(),
                "Check existence of register button");
    }

    @Test(dependsOnMethods = "CheckLoginPageContent")
    public void CheckRegisterButton(){
      var registrationHeader=  new Login(driver).openRegistrationScreen().getRegisterTitle_text();
      Assertions.assertElementAttribute(driver,
              registrationHeader,
              "text",
              "Register for My Vodafone",
              Assertions.AssertionComparisonType.CONTAINS,
              Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "CheckRegisterButton")
    public void CheckForgetPassword(){
        var resetYourPasswordText = new Register(driver).
                clickHeaderBackBtn()
                .openForgetPasswordScreen()
                .getResetYourPasswordHeader_text();

        Assertions.assertElementAttribute(driver,
                resetYourPasswordText,
                "text",
                "Reset your password",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }
    @Test(dependsOnMethods = "CheckForgetPassword")
    public void CheckForgetPasswordBackButton(){
        var loginHeader= new ForgetPassword(driver).goBackToLogin().getLoginTitle_text();
        Assertions.assertElementAttribute(driver,
                loginHeader,
                "text",
                "My Vodafone log in",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

}
