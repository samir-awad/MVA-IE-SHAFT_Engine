package OtherUsefulTools;

import Pages.Home;
import Pages.Login;
import Pages.OtherUsefulTools;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC082A_ValidateWebTextPageAndSuccessfulSendWebTextToOneRecipientUsingBillPayUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private OtherUsefulTools OtherUsefulToolsPage;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
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
        Assertions.assertElementExists(driver,HomePage.getCheckTheVodafoneLogo());
    }

    @Test (dependsOnMethods = {"checkTheVodafoneLogo"})
    public void checkOtherUsefulToolsSection() {
        HomePage.swipeToOtherUsefulTools();
        Assertions.assertElementAttribute(driver,HomePage.getOtherUsefulTools_text(),
                "text","Other useful tools");
    }
    @Test(dependsOnMethods = {"checkOtherUsefulToolsSection"})
    public void pressSendWebTextOption() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(HomePage.getSendWebText_button(), TouchActions.SwipeDirection.UP);
        HomePage.pressSendWebTextOption();
        Assertions.assertElementAttribute(driver,OtherUsefulToolsPage.getWebtextPageHeader_Text(),
                "text","Webtext");
    }

    @Test(dependsOnMethods = "pressSendWebTextOption")
    public void checkWebTextCloseButton(){
        OtherUsefulToolsPage.acceptAccessYourContactsPermissions();
        OtherUsefulToolsPage.pressWebTextHeaderCloseButton();
        Assertions.assertElementAttribute(driver,HomePage.getOtherUsefulTools_text(),
                "text","Other useful tools");
    }

    @Test(dependsOnMethods = "checkWebTextCloseButton")
    public void checkWebTextForm(){
        HomePage.pressSendWebTextOption();
        Verifications.verifyElementAttribute(driver,OtherUsefulToolsPage.getWebtextPageHeader_Text(),
                "text","Webtext");
        Verifications.verifyElementExists(driver,OtherUsefulToolsPage.getRecipients_Text());
        Verifications.verifyElementExists(driver,OtherUsefulToolsPage.getWebTextInputMessage_Text());
        Verifications.verifyElementExists(driver,OtherUsefulToolsPage.getSend_Button());
    }

    @Test(dependsOnMethods = "checkWebTextForm")
    public void fillOutWebTextForm(){
         OtherUsefulToolsPage.fillOutTheWebtextForm();
         OtherUsefulToolsPage.pressSendButton();
    }

    @Test(dependsOnMethods = {"fillOutWebTextForm"})
    public void WebTextInternationalVerificationOverlay(){
        Assertions.assertElementExists(driver,OtherUsefulToolsPage.getWebtextInternationalToast());
    }

}
