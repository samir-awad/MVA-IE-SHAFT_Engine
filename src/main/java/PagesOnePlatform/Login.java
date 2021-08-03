package PagesOnePlatform;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class Login {
    private final AppiumDriver driver;
    private static By LoginTitle_text;

    public static By getLoginTitle_text() {
        return LoginTitle_text;
    }

    private static By Login_button;

    public static By getLogin_button() {
        return Login_button;
    }

    private static By Register_button;

    public static By getRegister_button() {
        return Register_button;
    }

    private static By ForgottenYourPassword_button;
    private By EmailOrPhone_textBox;
    private By Password_textBox;


    public Login(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            LoginTitle_text = MobileBy.xpath("//android.view.ViewGroup[@content-desc='loginView']/android.widget.TextView");
            Login_button= MobileBy.AccessibilityId("loginLoginButton");
            Register_button = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView");
            ForgottenYourPassword_button= MobileBy.AccessibilityId("loginForgetYourPassLink");
            EmailOrPhone_textBox=By.xpath("//android.view.ViewGroup[@content-desc=\"loginView\"]/android.widget.EditText[1]");
            Password_textBox=By.xpath("//android.view.ViewGroup[@content-desc=\"loginView\"]/android.widget.EditText[2]");
        } else {
        }
    }

    public Register openRegistrationScreen() {
        ElementActions.performTouchAction(driver)
                .tap(Register_button);
        return new Register(driver);
    }

    public ForgetPassword openForgetPasswordScreen(){
        ElementActions.performTouchAction(driver)
                .tap(ForgottenYourPassword_button);
        return new ForgetPassword(driver);
    }

    public Login enterCredentials(String mailOrPhone,String password){
       new ElementActions(driver)
               .type(EmailOrPhone_textBox,mailOrPhone)
               .type(Password_textBox,password);
       return this;
    }

    public OnBoarding clickLoginButton(){
        new ElementActions(driver).click(Login_button);
        return new OnBoarding(driver);
    }



}
