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

public class TC117_LoginSuccessfullyWithPAYGCustomer {

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }


    @Test()
    public void Check_And_Accept_And_Continue_In_Terms_And_Conditions() {
        Assertions.assertElementExists(driver, LoginPage.getTermsAndConditions_Header());
        LoginPage.acceptTermsAndConditions();
    }

    @Test(dependsOnMethods = {"Check_And_Accept_And_Continue_In_Terms_And_Conditions"})
    public void Check_That_Im_On_Registration_And_Login_Page() {
        Assertions.assertElementExists(driver, LoginPage.getVodafone_Logo(), "I'm on Register And Login Page");

    }

    @Test(dependsOnMethods = {"Check_That_Im_On_Registration_And_Login_Page"})
    public void LoginWithPAYGCustomer() {
        LoginPage.login(jsonReader.getUserName("PAYGUser.username"), jsonReader.getPassword("PAYGUser.password"));
        Assertions.assertElementExists(driver, LoginPage.getLetsGo_Button());
    }
}
