package Login;

import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionType;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC02_CheckLoginAndRegisterAndOurPrivacyPages {

    //TC002 - Check Login & Register and Our Privacy pages
    //TC014 - Check Login & Register and Our Privacy pages

    private MobileDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Check_And_Accept_And_Continue_In_Terms_And_Conditions() {
        Assertions.assertElementExists(driver, LoginPage.getTermsAndConditions_Header(), AssertionType.POSITIVE);
        LoginPage.acceptTermsAndConditions();
    }

    @Test(dependsOnMethods = {"Check_And_Accept_And_Continue_In_Terms_And_Conditions"})
    public void Check_Vodafone_Logo_And_Login_Text_And_Button() {
        Assertions.assertElementExists(driver, LoginPage.getVodafone_Logo(), AssertionType.POSITIVE);
        Assertions.assertElementExists(driver, LoginPage.getReg_Login_Button(), AssertionType.POSITIVE);
        Assertions.assertElementExists(driver, LoginPage.getReg_Login_Txt(), AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = {"Check_Vodafone_Logo_And_Login_Text_And_Button"})
    public void check_Register_Text_And_Button() {
        Assertions.assertElementExists(driver, LoginPage.getReg_Register_button(), AssertionType.POSITIVE);
        Assertions.assertElementExists(driver, LoginPage.getReg_Register_Txt(), AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = {"check_Register_Text_And_Button"})
    public void check_Our_Privacy_Link() {
        Assertions.assertElementExists(driver, LoginPage.getReg_OurPrivacy_Link(), AssertionType.POSITIVE);
        ElementActions.performTouchAction(driver).tap(LoginPage.getReg_OurPrivacy_Link());
    }

    @Test(dependsOnMethods = {"check_Our_Privacy_Link"})
    public void check_Our_Privacy_WebView() {
        Assertions.assertElementExists(driver, LoginPage.getOurPrivacy_title(), AssertionType.POSITIVE);
        Assertions.assertElementExists(driver, LoginPage.getOurPrivacy_text(), AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = {"check_Our_Privacy_WebView"})
    public void Click_Back_And_check_VodafoneLogo_Is_Displayed_And_Im_On_Login_And_Register_Page() {
        LoginPage.PressBack();
        Assertions.assertElementExists(driver, LoginPage.getVodafone_Logo(), AssertionType.POSITIVE, "I'm On Register And Login Page");
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
