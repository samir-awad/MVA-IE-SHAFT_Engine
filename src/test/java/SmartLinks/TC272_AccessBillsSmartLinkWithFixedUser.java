package SmartLinks;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC272_AccessBillsSmartLinkWithFixedUser {
    private MobileDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    private SmartLinks SmartLinksPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = (MobileDriver) BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        SmartLinksPage = new SmartLinks(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath") + "smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessBillSmartLinkBeforeLogin() {
        String billLink = links.getTestData("Bill.link");
        SmartLinksPage.accessSmartLink(billLink);
        String username = users.getTestData("FixedUser.username");
        String password = users.getTestData("FixedUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementAttribute(driver, BillsPaymentsPage.getBillsPaymentTitle(),
                "text", "Bills & Payments");
    }

    @Test(dependsOnMethods = "CheckAccessBillSmartLinkBeforeLogin")
    public void CheckBillCloseButton() {
        BillsPaymentsPage.pressCloseButtonInBillsPaymentsView();
        Assertions.assertElementMatches(driver, HomePage.getVodafoneLogo(), "Checking that you are on home page");

    }

    @Test(dependsOnMethods = "CheckBillCloseButton")
    public void CheckAccessBillSmartLinkAfterLogin() {
        String billLink = links.getTestData("Bill.link");
        SmartLinksPage.accessSmartLink(billLink);
        Assertions.assertElementAttribute(driver, BillsPaymentsPage.getBillsPaymentTitle(),
                "text", "Bills & Payments");
    }

    @AfterClass
    public void CloseAllDrivers() {
        driver.quit();
    }
}
