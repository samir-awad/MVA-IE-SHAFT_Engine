package Home;

import FileReaders.jsonReader;
import Pages.Account;
import Pages.Home;
import Pages.Login;
import Pages.Logout;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC024_CheckThatTheTutorialTileBecomesUnavailableAfter5loginWithBillPay {

    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private Logout LogoutPage;
    private Account AccountPage;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        LogoutPage = new Logout(driver);
        HomePage = new Home(driver);
        AccountPage = new Account(driver);
    }

    @Test
    public void FirstLogin() {
        LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("BillPayUser.username"), jsonReader.getPassword("BillPayUser.password")).acceptPermissions();
        Assertions.assertElementExists(driver, HomePage.getTakeQuickTour_Tile());
        AccountPage.pressAccountTrayMenuOption();
        LogoutPage.pressLogoutButton();
        LogoutPage.pressLogoutYesButton();
    }

    @Test(dependsOnMethods = "FirstLogin")
    public void SecondLogin() {
        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPayUser.password"));
        Assertions.assertElementExists(driver, HomePage.getTakeQuickTour_Tile());
        AccountPage.pressAccountTrayMenuOption();
        LogoutPage.pressLogoutButton();
        LogoutPage.pressLogoutYesButton();
    }

    @Test(dependsOnMethods = "SecondLogin")
    public void ThirdLogin() {
        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPayUser.password"));
        Assertions.assertElementExists(driver, HomePage.getTakeQuickTour_Tile());
        AccountPage.pressAccountTrayMenuOption();
        LogoutPage.pressLogoutButton();
        LogoutPage.pressLogoutYesButton();
    }

    @Test(dependsOnMethods = "ThirdLogin")
    public void FourthLogin() {
        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPayUser.password"));
        Assertions.assertElementExists(driver, HomePage.getTakeQuickTour_Tile());
        AccountPage.pressAccountTrayMenuOption();
        LogoutPage.pressLogoutButton();
        LogoutPage.pressLogoutYesButton();
    }

    @Test(dependsOnMethods = "FourthLogin")
    public void FifthLogin() {
        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPayUser.password"));
        Assertions.assertElementExists(driver, HomePage.getTakeQuickTour_Tile());
        AccountPage.pressAccountTrayMenuOption();
        LogoutPage.pressLogoutButton();
        LogoutPage.pressLogoutYesButton();
    }

    @Test(dependsOnMethods = "FifthLogin")
    public void CheckThatTheTutorialTileBecomesUnavailableAfter5login() {
        LoginPage.EnterPasswordAndLogin(jsonReader.getPassword("BillPayUser.password"));
        Assertions.assertElementExists(driver, HomePage.getTakeQuickTour_Tile(), Assertions.AssertionType.NEGATIVE);
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
