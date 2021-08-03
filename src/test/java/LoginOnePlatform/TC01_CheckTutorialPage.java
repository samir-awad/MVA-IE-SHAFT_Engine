package LoginOnePlatform;

import PagesOnePlatform.Login;
import PagesOnePlatform.Tutorial;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC01_CheckTutorialPage {
    private AppiumDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = (AppiumDriver) BrowserFactory.getBrowser();
    }
    @Test
    public void CheckTutorialPageContent() {
        Verifications.verifyElementAttribute(driver,
                new Tutorial(driver).getLogin_button(),
                "text",
                "Login",
                Verifications.VerificationComparisonType.CONTAINS,
                Verifications.VerificationType.POSITIVE);

        Assertions.assertElementAttribute(driver,
                new Tutorial(driver).getRegister_button(),
                "text",
                "Register");
    }

    //Swipe left and write test will be added

}
