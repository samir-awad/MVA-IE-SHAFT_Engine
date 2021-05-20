package Home;

import FileReaders.jsonReader;
import Pages.Home;
import Pages.Login;
import Pages.Logout;
import com.shaft.cli.FileActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC024_CheckThatTheTutorialTileBecomesUnavailableAfter5loginWithBillPay {

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Logout LogoutPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("executionAddress", "0.0.0.0:4723");
        System.setProperty("targetOperatingSystem", "iOS");
        System.setProperty("mobile_platformVersion", "13.5.1");
        System.setProperty("mobile_deviceName", "iPhone");
        System.setProperty("mobile_automationName", "XCUITest");
        System.setProperty("mobile_udid", "00008030-001C4D5C1E33802E");
        System.setProperty("mobile_bundleId", "com.VodafoneIreland.MyVodafone");
        System.setProperty("mobile_derivedDataPath", "/Users/mva-ireland/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
        System.setProperty("mobile_app",System.getProperty("user.dir")+"//App//97_AUTO.ipa");
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        LogoutPage = new Logout(driver);
        HomePage = new Home(driver);
    }

    @Test
    public void FirstLogin() {
        LoginPage.acceptPermissions();
        //.acceptTermsAndConditions().login(jsonReader.getUserName("BillPay.username"), jsonReader.getPassword("BillPay.password"))
//        Assertions.assertElementExists(driver,HomePage.getTakeQuickTour_Tile());
//        LogoutPage.LogOut();
    }
//
//    @Test(dependsOnMethods = "FirstLogin")
//    public void SeconedLogin() {
//        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPay.password")).acceptPermissions();
//        Assertions.assertElementExists(driver,HomePage.getTakeQuickTour_Tile());
//        LogoutPage.LogOut();
//    }
//
//    @Test(dependsOnMethods = "SeconedLogin")
//    public void TherdLogin() {
//        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPay.password")).acceptPermissions();
//        Assertions.assertElementExists(driver,HomePage.getTakeQuickTour_Tile());
//        LogoutPage.LogOut();
//    }
//
//    @Test(dependsOnMethods = "TherdLogin")
//    public void FourthLogin() {
//        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPay.password")).acceptPermissions();
//        Assertions.assertElementExists(driver,HomePage.getTakeQuickTour_Tile());
//        LogoutPage.LogOut();
//    }
//
//    @Test(dependsOnMethods = "FourthLogin")
//    public void FifthLogin() {
//        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPay.password")).acceptPermissions();
//        Assertions.assertElementExists(driver,HomePage.getTakeQuickTour_Tile());
//        LogoutPage.LogOut();
//    }
//
//    @Test(dependsOnMethods = "FifthLogin")
//    public void CheckThatTheTutorialTileBecomesUnavailableAfter5login() {
//        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPay.password"));
//        Assertions.assertElementExists(driver,HomePage.getTakeQuickTour_Tile(), Assertions.AssertionType.NEGATIVE);
//
//    }
}
