package DashboardOnePlatform;

import PagesOnePlatform.Dashboard;
import PagesOnePlatform.Tutorial;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC01_CheckMyAccountTray {
    private JSONFileManager users;
    private AppiumDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = (AppiumDriver) BrowserFactory.getBrowser();
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
    }
    @Test
    public void CheckAccountBottomTray(){
        String username = users.getTestData("BillPayUserWithoutAddOns.username");
        String password = users.getTestData("BillPayUserWithoutAddOns.password");

     var trayAccountText=   new Tutorial(driver).openLoginPage()
                .enterCredentials(username,password)
                .clickLoginButton()
                .acceptTermsAndConditions()
                .acceptPermissionsBillPay()
                .getTrayAccount();
        Assertions.assertElementAttribute(driver,
                trayAccountText,
                "text",
                "Account",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "CheckAccountBottomTray")
    public void CheckAccountOverlayTitle(){
    var AccountTitle=  new Dashboard(driver)
            .openAccountTray()
            .getAccountTitle_text();
    Assertions.assertElementAttribute(driver,
            AccountTitle,
            "text",
            "My Account",
            Assertions.AssertionComparisonType.CONTAINS,
            Assertions.AssertionType.POSITIVE);
    }


}
