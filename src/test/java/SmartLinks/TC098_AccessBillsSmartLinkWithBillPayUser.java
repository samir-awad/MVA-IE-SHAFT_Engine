package SmartLinks;

import Pages.BillsPayments;
import Pages.Home;
import Pages.Login;
import Pages.SmartLinks;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC098_AccessBillsSmartLinkWithBillPayUser {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    private SmartLinks SmartLinksPage;
    private JSONFileManager links;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage= new Home(driver);
        SmartLinksPage= new SmartLinks(driver);
        BillsPaymentsPage= new BillsPayments(driver);
        links = new JSONFileManager(System.getProperty("testDataFolderPath")+"smartLinks.json");
        users = new JSONFileManager(System.getProperty("testDataFolderPath")+"users.json");
        LoginPage.acceptTermsAndConditions();
    }

    @Test
    public void CheckAccessBillSmartLinkBeforeLogin(){
        String billLink= links.getTestData("Bill.link");
        SmartLinksPage.accessSmartLink(billLink);
        String username = users.getTestData("BillPayUser.username");
        String password = users.getTestData("BillPayUser.password");
        LoginPage.login(username, password).acceptPermissions();
        Assertions.assertElementAttribute(driver,BillsPaymentsPage.getBillsPaymentTitle(),
                "text","Bills & Payments");
    }

    @Test(dependsOnMethods = "CheckAccessBillSmartLinkBeforeLogin")
    public void CheckBillCloseButton(){
        BillsPaymentsPage.pressCloseButtonInBillsPaymentsView();
        Assertions.assertElementMatches(driver,HomePage.getVodafoneLogo(),"Checking that you are on home page");

    }

    @Test(dependsOnMethods ="CheckBillCloseButton")
    public void CheckAccessBillSmartLinkAfterLogin(){
        String billLink= links.getTestData("Bill.link");
        SmartLinksPage.accessSmartLink(billLink);
        Assertions.assertElementAttribute(driver,BillsPaymentsPage.getBillsPaymentTitle(),
                "text","Bills & Payments");
    }
}
