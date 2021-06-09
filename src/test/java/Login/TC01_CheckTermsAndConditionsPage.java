package Login;

import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC01_CheckTermsAndConditionsPage {

    //TC001 - Check Terms & Conditions Page Android
    //TC013 - Check Terms & Conditions page iOS

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Check_Terms_And_Conditions_Header_Is_Displayed() {
        Assertions.assertElementExists(driver, LoginPage.getTermsAndConditions_Header());
    }

    @Test()
    public void Check_Terms_And_Conditions_Text_Is_Displayed() {
        Assertions.assertElementExists(driver, LoginPage.getTermsAndConditions_Txt());
    }

    @Test()
    public void Check_Terms_And_Conditions_CheckBox_Is_Displayed() {
        Assertions.assertElementExists(driver, LoginPage.getAcceptTerms_button());
    }

    @Test
    public void Check_Terms_And_Conditions_Continue_Button_Is_Displayed() {
        Assertions.assertElementExists(driver, LoginPage.getContinue_button());
    }

}
