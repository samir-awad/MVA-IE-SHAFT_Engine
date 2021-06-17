package OtherUsefulTools;

import Pages.Home;
import Pages.Login;
import Pages.OtherUsefulTools;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC086A_ValidateWebtextWithOnlyTheMessageAndCheckThatSendButtonStillDisabledUsingBillPayUser {
    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private OtherUsefulTools OtherUsefulToolsPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        OtherUsefulToolsPage = new OtherUsefulTools(driver);
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData("BillPayUserWithWebText.username");
        String password = users.getTestData("BillPayUserWithWebText.password");
        LoginPage.acceptTermsAndConditions().login(username, password).acceptPermissions();
    }

    @Test
    public void checkTheVodafoneLogo() {
        Assertions.assertElementExists(driver, HomePage.getCheckTheVodafoneLogo());
    }

    @Test(dependsOnMethods = {"checkTheVodafoneLogo"})
    public void checkOtherUsefulToolsSection() {
        HomePage.checkOtherUsefulToolsSection();
    }

    @Test(dependsOnMethods = {"checkOtherUsefulToolsSection"})
    public void pressSendWebtextOption() {
        //HomePage.pressSendWebtextOption();
        Assertions.assertTrue(OtherUsefulToolsPage.checkWebTextForm());
        Verifications.verifyTrue(OtherUsefulToolsPage.checkWebtextPageHeader());
        OtherUsefulToolsPage.fillInRecipient();
        OtherUsefulToolsPage.checkSendButtonStillDisabled();
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }

}

