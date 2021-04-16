package Login;

import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03_CheckLoginRegisterAndResetPages {
    //TC015 - Check Login, Register and Reset pages
    //TC003 - Check Login, Register and Reset pages

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Step1_Accept_Terms_And_Conditions() {
        Assertions.assertElementExists(driver,LoginPage.getTermsAndConditions_Header(), Assertions.AssertionType.POSITIVE);
        LoginPage.acceptTermsAndConditions();
    }

    @Test()
    public void Step2_Check_That_Im_On_Login_And_Register_Page(){
        Assertions.assertElementExists(driver,LoginPage.getVodafone_Logo(),"I'm On Login Page");
    }

    @Test()
    public void  Step3_Check_Login_Page(){
        System.out.println("Step 3 : Check Login Page");
    }

    @Test()
    public void Step4_Check_Register_Page(){
        System.out.println("Step 4 : Check Register Page");
    }

    @Test()
    public void Step5_Check_Reset_Your_Password_Page(){
        System.out.println("Step 5 : Check Reset Your Password Page");
    }


}
