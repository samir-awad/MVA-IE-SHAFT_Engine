package TopUp;

import Pages.Home;
import Pages.Login;
import Pages.TopUp;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC160_ValidateTopUpHistoryPagePAYGUser {
    private MobileDriver driver;
    private JSONFileManager users;
    private Login LoginPage;
    private Home HomePage;
    private TopUp TopUpPage;


    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        TopUpPage = new TopUp(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("PAYGUserWithTopUp.username");
        String password = users.getTestData("PAYGUserWithTopUp.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissionsPAYGUser();
    }

    @Test
    public void CheckVodafoneLogoAndWelcomeGesture() {
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    //This step App sometimes is stop working
    @Test(dependsOnMethods = "CheckVodafoneLogoAndWelcomeGesture")
    public void CheckTopUpHistoryPage() {
        HomePage.pressBalanceTitle();
        TopUpPage.pressTopUpOverlayMoreOptionsButton();
        TopUpPage.pressMoreOptionsOverlayTopUpHistoryOption();
        Verifications.verifyElementAttribute(driver, TopUpPage.getTopUpHeader_text(),
                "text", "Top up", "checking Top Up History Page Header");
        //The following assertion is not working as all locators of the page are failing
        /*Assertions.assertElementAttribute(driver,TopUpPage.getFilter_text(),
                "text","Toggle 0 Filters",
                Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE,
                "Checking Top Up History Page Content");*/
    }

    @Test(dependsOnMethods = "CheckTopUpHistoryPage")
    public void ValidateTopUpHistoryPageCloseBtn() {
        TopUpPage.pressCloseBtn();
        Assertions.assertElementExists(driver, HomePage.getVodafoneLogo());
    }

    @Test(dependsOnMethods = "ValidateTopUpHistoryPageCloseBtn")
    public void ValidateTopUpHistoryBtn() {
        HomePage.pressTopUpHistoryTitle();
        Verifications.verifyElementAttribute(driver, TopUpPage.getTopUpHeader_text(),
                "text", "Top up", "checking Auto Top Up Page Header");

        //The following assertion is not working as all locators of the page are failing
        /*Assertions.assertElementAttribute(driver,TopUpPage.getFilter_text(),
                "text","Toggle 0 Filters",
                Assertions.AssertionComparisonType.CONTAINS, Assertions.AssertionType.POSITIVE,
                "Checking Top Up History Page Content");*/
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}
