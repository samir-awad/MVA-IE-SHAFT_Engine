package Login;

import FileReaders.jsonReader;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC06_LoginWithInvalidUsername{


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

    @Test(priority = 2)
    public void Step2() {
        LoginPage.EnterUserName(jsonReader.getUserName("Wrong Password.username"));
        Assertions.assertElementExists(driver,LoginPage.getLogin_Inline_Error(), Assertions.AssertionType.POSITIVE);
    }


}
