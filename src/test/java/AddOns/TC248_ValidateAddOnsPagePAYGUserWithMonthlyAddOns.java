package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC248_ValidateAddOnsPagePAYGUserWithMonthlyAddOns {
    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private AddOns AddOnsPage;

    //Qs:Is there anyway to start from dashboard instead of login? as no reset
    //Ans:Use fluent design instead of no reset
    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }

    @Test
    public void CheckEssentialsSection() {
        //Qs:How It should be Soft or Hard assertions?
        //Note that if essentials is not existed all next steps can't be performed
        //Ans:Hard assertions depend on situation
        Assertions.assertTrue(HomePage.checkEssentialsSection()); //Here scrolling is not working
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsPage() {
        HomePage.opedAddOnsOverlay();
        HomePage.openAddOnsPage();
        //Use verify attribute to take screenshot instead of verifyEquals
        //Verifications.verifyElementAttribute(driver,AddOnsPage.getAddOnsHeader_Text(),AddOnsPage.getAddOnsHeaderText(),"Buy add ons"); //This method is not working as expected
        //element matches for visual assertions (Assert element matches)
        Verifications.verifyElementAttribute(driver, AddOnsPage.getAddOnsHeader_Text(), "text", "Buy add ons");

        //Is there a soft assertion for false existing?
        Assertions.assertElementExists(driver,
                AddOnsPage.getOneOff_tab(),
                Assertions.AssertionType.NEGATIVE,
                "Check Element Existence");
    }

}
