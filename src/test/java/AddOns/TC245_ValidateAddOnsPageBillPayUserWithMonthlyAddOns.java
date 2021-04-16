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

public class TC245_ValidateAddOnsPageBillPayUserWithMonthlyAddOns {
    private WebDriver driver;
    private Home HomePage;
    private AddOns AddOnsPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        Login loginPage = new Login(driver);
        HomePage = new Home(driver);
        AddOnsPage = new AddOns(driver);
        //loginPage.acceptTermsAndConditions().login().acceptPermissions();
    }

    @Test
    public void CheckEssentialsSection() {
        Assertions.assertTrue(HomePage.checkEssentialsSection());
    }

    @Test(dependsOnMethods = "CheckEssentialsSection")
    public void ValidateAddOnsPageFirstTab() {
        HomePage.opedAddOnsOverlay();
        AddOnsPage.openAddOnsPage();

        Verifications.verifyElementAttribute(driver, AddOnsPage.getAddOnsHeader_text(),
                "text", "Buy add ons");

        Verifications.verifyTrue(AddOnsPage.checkBuyAddOnsFirstTab(),"Checking One Off tab");

        Verifications.verifyTrue(AddOnsPage.checkBuyAddOnsSecondTab(),"Checking recurring tab");

        Verifications.verifyTrue(AddOnsPage.checkOneOffListFirstItem(),"Checking first list item in one off tab");

        Verifications.verifyElementAttribute(driver, AddOnsPage.getOneOff_tab(),
                "text", "One off");

        Verifications.verifyTrue(AddOnsPage.checkAddOnsContinueBtn(),"Checking continue button");

        Verifications.verifyTrue(AddOnsPage.checkManageAddOnsBtn(),"Checking Manage add ons button");


    }

    @Test(dependsOnMethods = {"CheckEssentialsSection","ValidateAddOnsPageFirstTab"})
    public void ValidateAddOnsPageSecondTab() {
        AddOnsPage.openRecurringTab();

        Verifications.verifyElementAttribute(driver, AddOnsPage.getRecurring_tab_text(),
                "text", "Recurring",
                Verifications.VerificationComparisonType.CONTAINS, Verifications.VerificationType.POSITIVE);

        Verifications.verifyTrue(AddOnsPage.checkRecurringListFirstItem(),"Checking first list item in recurring tab");

        Verifications.verifyTrue(AddOnsPage.checkAddOnsContinueBtn(),"Checking continue button");

        Verifications.verifyTrue(AddOnsPage.checkManageAddOnsBtn(),"Checking manage add ons button");

    }

    @Test(dependsOnMethods = {"CheckEssentialsSection","ValidateAddOnsPageFirstTab", "ValidateAddOnsPageSecondTab"})
    public void ValidateRecurringActions(){
        AddOnsPage.clickSelectBtn();
        Verifications.verifyElementAttribute(driver,AddOnsPage.getSelect_text(),
                "text","Selected","Checking selected text");

    }




}
