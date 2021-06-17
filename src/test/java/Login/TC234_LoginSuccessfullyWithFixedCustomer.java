package Login;

import FileReaders.jsonReader;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC234_LoginSuccessfullyWithFixedCustomer {

    private MobileDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test
    public void Step1_Accept_Terms_And_Conditions() {
        Assertions.assertElementExists(driver, LoginPage.getTermsAndConditions_Header());
        LoginPage.acceptTermsAndConditions();
    }

    @Test(dependsOnMethods = "Step1_Accept_Terms_And_Conditions")
    public void Check_Vodafone_Logo() {
        Assertions.assertElementExists(driver, LoginPage.getVodafone_Logo());
    }

    @Test(dependsOnMethods = "Check_Vodafone_Logo")
    public void Step2_Login_With_Fixed_User() {
        LoginPage.login(jsonReader.getUserName("FixedUser.username"), jsonReader.getPassword("FixedUser.password"));
        Assertions.assertElementExists(driver, LoginPage.getLetsGo_Button());
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
