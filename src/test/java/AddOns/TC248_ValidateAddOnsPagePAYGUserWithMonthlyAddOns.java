package AddOns;

import Pages.AddOns;
import Pages.Home;
import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
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
        AddOnsPage=new AddOns(driver);
        LoginPage.acceptTermsAndConditions().login().acceptPermissions();//fluent design
        //This method will be used to login before every test case to login with
        //With different users credentials must be changed
    }

    @Test
    public void CheckEssentialsSection() {
        //Qs:How It should be Soft or Hard assertions?
        //Note that if essentials is not existed all next steps can't be performed
        //Ans:Hard assertions depend on situation
        Assertions.assertTrue(HomePage.checkEssentialsSection());
    }

    @Test(dependsOnMethods = {"CheckEssentialsSection"})
    public void ValidateAddOnsPage() {
        HomePage.openAddOnsPage();
        //Use verify attribute to take screenshot instead of verifyEquals
       // Verifications.verifyElementAttribute(driver,AddOnsPage.getAddOnsHeader_Text(),AddOnsPage.getAddOnsHeaderText(),"Buy add ons");
        Verifications.verifyElementAttribute(driver,AddOnsPage.getAddOnsHeader_Text(),AddOnsPage.getAddOnsHeaderText(),"Buy add ons");
        Verifications.verifyEquals("Buy add ons",AddOnsPage.getAddOnsHeaderText());
        //Is there a soft assertion for false existing?
        Assertions.assertElementExists(driver,
                AddOnsPage.getOneOff_tab(),
                Assertions.AssertionType.NEGATIVE,
                "Element is not existed");
    }


}
