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

public class TC07_LoginWithBillPayLegacyCustomer{

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Check_And_Accept_And_Continue_In_Terms_And_Conditions() {
        Assertions.assertElementExists(driver,LoginPage.getTermsAndConditions_Header(), Assertions.AssertionType.POSITIVE);
        LoginPage.acceptTermsAndConditions();
    }

    @Test(dependsOnMethods = {"Check_And_Accept_And_Continue_In_Terms_And_Conditions"})
    public void Check_Vodafone_Logo(){
        Assertions.assertElementExists(driver,LoginPage.getVodafone_Logo(), Assertions.AssertionType.POSITIVE);
    }

    @Test()
    public void LoginWithLegacyBillPayUser() throws IOException, ParseException {
        LoginPage.login(jsonReader.getUserName("LegacyBillPay.username"), jsonReader.getPassword("LegacyBillPay.password")); // need Legacy User for Bill Pay
        Assertions.assertElementExists(driver,LoginPage.getLegacyOverlay_title(), Assertions.AssertionType.POSITIVE);
    }
}
