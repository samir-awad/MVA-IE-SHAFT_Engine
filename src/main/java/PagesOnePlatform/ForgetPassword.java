package PagesOnePlatform;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ForgetPassword {
    private final AppiumDriver driver;

    public static By getResetYourPasswordHeader_text() {
        return ResetYourPasswordHeader_text;
    }
    private static By ResetYourPasswordHeader_text;

    private static By HeaderBack_button;

    public static By getSendToken_button() {
        return SendToken_button;
    }
    private static By SendToken_button;
    private static By EmailOrPhone_textBox;


    public ForgetPassword(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
        ResetYourPasswordHeader_text = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");
        HeaderBack_button=MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"back_btn_accessibility_Label\"]/android.widget.ImageView");
        SendToken_button=MobileBy.AccessibilityId("forgotPasswordSendTokenButton");
            EmailOrPhone_textBox=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText");
        }
        else {

        }
    }

    public PagesOnePlatform.Login goBackToLogin() {
        ElementActions.performTouchAction(driver).tap(HeaderBack_button);
        return new PagesOnePlatform.Login(driver);
    }
    public Register goBackToRegister() {
        ElementActions.performTouchAction(driver).tap(HeaderBack_button);
        return new Register(driver);
    }

    public ForgetPassword enterPhoneNumber(String phoneOrMail){
        ElementActions.type(driver,EmailOrPhone_textBox, phoneOrMail);
        return this;
    }

}
