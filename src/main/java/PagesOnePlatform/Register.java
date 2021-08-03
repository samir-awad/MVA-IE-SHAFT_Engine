package PagesOnePlatform;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.apache.commons.codec.language.bm.Rule;
import org.openqa.selenium.By;

public class Register {
    private final AppiumDriver driver;

    public static By getRegisterTitle_text() {
        return RegisterTitle_text;
    }
    private static By RegisterTitle_text;

    private static By HeaderBack_button;
    private static By EmailOrPhone_textBox;
    private static By SendToken_button;
    private static By RegisterHere_button;

    public static By getSendToken_button() {
        return SendToken_button;
    }

    public Register(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            RegisterTitle_text = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");
            HeaderBack_button=MobileBy.AccessibilityId("back_btn_accessibility_Label");
            EmailOrPhone_textBox=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText");
            SendToken_button=MobileBy.AccessibilityId("registerSendTokenButton");
            RegisterHere_button=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");
        }
        else {}
    }

    public PagesOnePlatform.Login clickHeaderBackBtn() {
        ElementActions.performTouchAction(driver).tap(HeaderBack_button);
        return new PagesOnePlatform.Login(driver);
    }

    public Register enterPhoneNumber(String phoneOrMail){
        ElementActions.type(driver,EmailOrPhone_textBox, phoneOrMail);
        return this;
    }

    public ForgetPassword clickRegisterHereButton(){
        ElementActions.performTouchAction(driver).tap(RegisterHere_button);
        return new ForgetPassword(driver);
    }

}
