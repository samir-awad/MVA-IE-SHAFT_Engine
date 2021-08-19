package LoginOnePlatform;

import PagesOnePlatform.Tutorial;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC08_CheckOnBoardingWithBillPayCustomer {
    private JSONFileManager users;
    private AppiumDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = (AppiumDriver) BrowserFactory.getBrowser();
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
    }

    @Test
    public void CheckLoginWithBillPayUser(){
        String username = users.getTestData("BillPayUserWithoutAddOns.username");
        String password = users.getTestData("BillPayUserWithoutAddOns.password");
        var discoverTxt=   new Tutorial(driver).openLoginPage()
                .enterCredentials(username,password)
                .clickLoginButton()
                .acceptTermsAndConditions()
                .acceptPermissionsBillPay()
                .getDiscoverTitle_text();

        Assertions.assertElementAttribute(driver,
                discoverTxt,
                "text",
                "Discover",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
        
    }
}
