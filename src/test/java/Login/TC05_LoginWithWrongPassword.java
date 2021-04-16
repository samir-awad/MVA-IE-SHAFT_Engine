package Login;

import FileReaders.GetUserFromJson;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC05_LoginWithWrongPassword{

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Accept_And_Continue_In_Terms_And_Conditions(){
        Assertions.assertElementExists(driver,LoginPage.getTermsAndConditions_Header(), Assertions.AssertionType.POSITIVE);
        LoginPage.acceptTermsAndConditions();
    }

    @Test()
    public void Login_With_Invalid_Password_FirstTime() throws  IOException, ParseException {
        LoginPage.login(GetUserFromJson.getUsername("Wrong Password"),GetUserFromJson.getpassword("Wrong Password"));
        Assertions.assertEquals("Sorry, you have entered the wrong password. Please try again. This is your 1/5 attempt. If you enter your password incorrectly 5 times your account will be temporarily locked. If you don’t know your password, you can reset it below.",LoginPage.getInvalid_UserName_PWD_title());
    }

    @Test()
    public void Step3() throws IOException, ParseException{
        LoginPage.EnterPasswordAndLogin(GetUserFromJson.getpassword("Wrong Password"));
        Assertions.assertEquals("Sorry, you have entered the wrong password. Please try again. This is your 2/5 attempt. If you enter your password incorrectly 5 times your account will be temporarily locked. If you don’t know your password, you can reset it below.",LoginPage.getInvalid_UserName_PWD_title());
    }

    @Test()
    public void Step4(){
        ElementActions.performTouchAction(driver).tap(LoginPage.getInvalid_UserName_PWD_UpdatePWD_button());
        Assertions.assertElementExists(driver,LoginPage.getRestPassword_Title(), Assertions.AssertionType.POSITIVE,"Im On Reset Password Page");
    }
}
