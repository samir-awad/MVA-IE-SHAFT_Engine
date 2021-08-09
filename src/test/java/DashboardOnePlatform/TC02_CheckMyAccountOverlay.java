package DashboardOnePlatform;

import PagesOnePlatform.MyAccountTray;
import PagesOnePlatform.Tutorial;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_CheckMyAccountOverlay {
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
                .openAccountTray()
                .getAccountTitle_text();
        Assertions.assertElementAttribute(driver,
                trayAccountText,
                "text",
                "My Account",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "CheckAccountBottomTray")
    public void CheckSettings(){
            //  new MyAccountTray(driver).openSetting();
              //Assertion should be added
    }
    @Test(dependsOnMethods = "CheckSettings")
    public void CheckMyRecords(){
        //close action should be added
       // new MyAccountTray(driver).openMyRecords();
        //Assertion should be added
    }

    @Test(dependsOnMethods = "CheckMyRecords")
    public void CheckOurPrivacy(){
        //close action should be added
        new MyAccountTray(driver).openOurPrivacy();
        //Assertion should be added
    }


    @Test(dependsOnMethods = "CheckOurPrivacy")
    public void CheckLogOut(){
        //close action should be added
        new MyAccountTray(driver).logout();
        //Assertion should be added
    }


}
