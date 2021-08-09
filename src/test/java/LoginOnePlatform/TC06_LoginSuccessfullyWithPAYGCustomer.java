package LoginOnePlatform;

import PagesOnePlatform.Tutorial;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC06_LoginSuccessfullyWithPAYGCustomer {
    private JSONFileManager users;
    private AppiumDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = (AppiumDriver) BrowserFactory.getBrowser();
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
    }

    @Test
    public void CheckLoginWithBillPayUser(){
        String username = users.getTestData("PAYGUser.username");
        String password = users.getTestData("PAYGUser.password");
     var termsAndConditionsText=   new Tutorial(driver).openLoginPage()
                .enterCredentials(username,password)
                .clickLoginButton()
             .getTermsAndConditionsHeader_text();
        Assertions.assertElementAttribute(driver,
                termsAndConditionsText,
                "text",
                "Terms & conditions and privacy policy",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }



}
