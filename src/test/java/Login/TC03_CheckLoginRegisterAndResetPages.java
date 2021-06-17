package Login;

import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03_CheckLoginRegisterAndResetPages {
    //TC015 - Check Login, Register and Reset pages
    //TC003 - Check Login, Register and Reset pages

    private MobileDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Step1_Accept_Terms_And_Conditions() {
        Assertions.assertElementExists(driver, LoginPage.getTermsAndConditions_Header(), Assertions.AssertionType.POSITIVE);
        LoginPage.acceptTermsAndConditions();
    }

    @Test()
    public void Step2_Check_That_Im_On_Login_And_Register_Page() {
        Assertions.assertElementExists(driver, LoginPage.getVodafone_Logo(), "I'm On Login and Register Page");
        LoginPage.PressReg_LoginButton();
    }

    @Test()
    public void Step3_Check_Login_Page() {
        Verifications.verifyElementExists(driver, LoginPage.getLoginVf_Logo());
        Verifications.verifyElementExists(driver, LoginPage.getLoginVf_title());
        Verifications.verifyElementExists(driver, LoginPage.getPhoneOrEmail_TxtField());
        Verifications.verifyElementExists(driver, LoginPage.getPassword_TxtField());
        Verifications.verifyElementExists(driver, LoginPage.getNeedToRegister_link());
        Verifications.verifyElementExists(driver, LoginPage.getForgotPWD_link());
        Assertions.assertElementExists(driver, LoginPage.getLoginOurPrivacy_link());
    }

    @Test()
    public void Step4_Check_Register_Page() {
        ElementActions.performTouchAction(driver).tap(LoginPage.getNeedToRegister_link());
        Verifications.verifyElementExists(driver, LoginPage.getReg_Register_Txt());
        Verifications.verifyElementExists(driver, LoginPage.getReg_Register_Txt());
    }

    @Test()
    public void Step5_Check_Reset_Your_Password_Page() {
        System.out.println("Step 5 : Check Reset Your Password Page");
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
