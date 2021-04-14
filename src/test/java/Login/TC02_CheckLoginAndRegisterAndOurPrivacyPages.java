package Login;

import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TC02_CheckLoginAndRegisterAndOurPrivacyPages{
	
	//TC002 - Check Login & Register and Our Privacy pages
    //TC014 - Check Login & Register and Our Privacy pages

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

	@Test()
	public void Check_And_Accept_And_Continue_In_Terms_And_Conditions() {
        Assertions.assertElementExists(driver,LoginPage.getTermsAndConditions_Header());
        LoginPage.acceptTermsAndConditions();
	}

    @Test(dependsOnMethods = {"Check_And_Accept_And_Continue_In_Terms_And_Conditions"})
	public void Check_Vodafone_Logo(){
        Assertions.assertElementExists(driver,LoginPage.getVodafone_Logo());
    }

    @Test()
    public void Step3_check_Login_Text_And_Button(){
	
    }

    @Test()
    public void Step4_check_Register_Text_And_Button(){
	
    }

    @Test()
    public void Step5_check_Our_Privacy_Link(){
	
    }

    @Test()
    public void Step6_check_Our_Privacy_WebVie(){

    }

    @Test()
    public void Step7_check_VodafoneLogo_Is_Displayed_And_Im_On_Login_And_Register_Page(){

    }

}
