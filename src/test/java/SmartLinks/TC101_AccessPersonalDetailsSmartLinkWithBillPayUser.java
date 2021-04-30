package SmartLinks;

import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC101_AccessPersonalDetailsSmartLinkWithBillPayUser {
    private WebDriver driver;
    private WebDriver nativeDriver;
    private Login LoginPage;
    private Home HomePage;
    private JSONFileManager links;
    private JSONFileManager users;
    ChromeOptions options = new ChromeOptions();

    @BeforeClass
    public void beforeClass(){
        nativeDriver = BrowserFactory.getBrowser();
        LoginPage = new Login(nativeDriver);
        HomePage= new Home(nativeDriver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        LoginPage.acceptTermsAndConditions();
        //close app
    }

    @Test
    public void CheckAccessPersonalDetailsSmartLinkBeforeLogin(){
        //accessPersonalDetailsSmartLink
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        //checkPersonalDetailsPageHeader

    }

    @Test(dependsOnMethods = "CheckAccessPersonalDetailsSmartLinkBeforeLogin")
    public void CheckPersonalDetailsCloseButton(){
        //pressCloseButton
        Assertions.assertElementExists(nativeDriver,HomePage.getVodafoneLogo());

    }

    @Test(dependsOnMethods ="CheckPersonalDetailsCloseButton")
    public void CheckAccessPersonalDetailsSmartLinkAfterLogin(){
        //close app
        //accessPersonalDetailsSmartLink
        //checkPersonalDetailsPageHeader
    }
}
