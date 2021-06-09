package OtherUsefulTools;

import Pages.Home;
import Pages.Login;
import Pages.OtherUsefulTools;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC084A_ValidateWritingWebTextWithMoreThanTheAllowedCharactersUsingBillPayUser{
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
            users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
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
            HomePage.checkOtherUsefulToolsSection();
        }
        @Test(dependsOnMethods = {"checkOtherUsefulToolsSection"})
        public void pressSendWebtextOption() {
            HomePage.pressSendWebTextOption();
            Assertions.assertTrue(OtherUsefulToolsPage.checkWebTextForm());
            Verifications.verifyTrue(OtherUsefulToolsPage.checkWebtextPageHeader());
            OtherUsefulToolsPage.fillInTheMessageWithMoreThanTheAllowedCharacters();
            OtherUsefulToolsPage.checkRemainingCharactersText();
        }


}

