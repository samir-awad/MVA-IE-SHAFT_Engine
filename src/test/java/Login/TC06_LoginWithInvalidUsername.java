package Login;

import FileReaders.jsonReader;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC06_LoginWithInvalidUsername {


    private MobileDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Accept_And_Continue_In_Terms_And_Conditions() {
        Assertions.assertElementExists(driver, LoginPage.getTermsAndConditions_Header(), Assertions.AssertionType.POSITIVE);
        LoginPage.acceptTermsAndConditions();
    }

    @Test(dependsOnMethods = "Accept_And_Continue_In_Terms_And_Conditions")
    public void EnterInvalidUserNameAndCheckInlineErrorMsg() {
        LoginPage.enterInvalidUserName(jsonReader.getUserName("WrongUsername.username"));
        Assertions.assertElementAttribute(driver,
                LoginPage.getLogin_Inline_Error(),
                "text",
                "Email is not valid",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

  /*  @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }*/

}
