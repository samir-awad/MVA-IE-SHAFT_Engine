package LoginOnePlatform;

import PagesOnePlatform.ForgetPassword;
import PagesOnePlatform.Tutorial;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC04_CheckResetPasswordPage {
    private AppiumDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = (AppiumDriver) BrowserFactory.getBrowser();
    }

    @Test
    public void CheckResetPasswordPageHeader() {
        var resetPasswordHeader=new Tutorial(driver)
                .openRegisterPage()
                .clickRegisterHereButton()
                .getResetYourPasswordHeader_text();
        Assertions.assertElementAttribute(driver,
                resetPasswordHeader,
                "text",
                "Reset your password",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "CheckResetPasswordPageHeader")
    public void CheckSendToken(){
        var tokenButton= new ForgetPassword(driver)
                .enterPhoneNumber("0811111111")
                .getSendToken_button();
        Assertions.assertElementAttribute(driver,
                tokenButton,
                "enabled",
                "true");
    }
    @Test(dependsOnMethods = "CheckSendToken")
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
