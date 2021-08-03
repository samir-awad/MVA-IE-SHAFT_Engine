package PagesOnePlatform;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class Tutorial {
    private final AppiumDriver driver;

    public static By getLogin_button() {
        return Login_button;
    }

    private static By Login_button;

    public static By getRegister_button() {
        return Register_button;
    }

    private static By Register_button;

    public Tutorial(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            Login_button= MobileBy.AccessibilityId("loginLoginTutorial");
            Register_button=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[6]/android.widget.TextView");
        }
        else {}
    }

    public Login openLoginPage(){
        ElementActions.performTouchAction(driver).tap(Login_button);
        return new Login(driver);
    }

    public Register openRegisterPage(){
        ElementActions.performTouchAction(driver).tap(Register_button);
        return new Register(driver);
    }





}
