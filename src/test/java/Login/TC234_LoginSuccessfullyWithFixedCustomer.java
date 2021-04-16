package Login;

import FileReaders.GetUserFromJson;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC234_LoginSuccessfullyWithFixedCustomer{

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Step1_Accept_Terms_And_Conditions() {
        Assertions.assertElementExists(driver,LoginPage.getTermsAndConditions_Header());
        LoginPage.acceptTermsAndConditions();
    }

    @Test()
    public void Check_Vodafone_Logo(){
        Assertions.assertElementExists(driver,LoginPage.getVodafone_Logo());
    }

    @Test()
    public void Step2_Login_With_Fixed_User() throws IOException, ParseException {
        LoginPage.login(GetUserFromJson.getUsername("FixedUser"), GetUserFromJson.getpassword("FixedUser"));
        Assertions.assertElementExists(driver,LoginPage.getLetsGo_Button());
    }
}
