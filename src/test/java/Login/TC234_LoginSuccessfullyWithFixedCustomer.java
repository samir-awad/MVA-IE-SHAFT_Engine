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

public class TC234_LoginSuccessfullyWithFixedCustomer{

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test
    public void Step1_Accept_Terms_And_Conditions() {
        Assertions.assertElementExists(driver,LoginPage.getTermsAndConditions_Header());
        LoginPage.acceptTermsAndConditions();
    }

    @Test(dependsOnMethods = "Step1_Accept_Terms_And_Conditions")
    public void Check_Vodafone_Logo(){
        Assertions.assertElementExists(driver,LoginPage.getVodafone_Logo());
    }

    @Test(dependsOnMethods = "Check_Vodafone_Logo")
    public void Step2_Login_With_Fixed_User() {
        LoginPage.login(jsonReader.getUserName("FixedUser.username"), jsonReader.getPassword("FixedUser.password"));
        Assertions.assertElementExists(driver,LoginPage.getLetsGo_Button());
    }
}
