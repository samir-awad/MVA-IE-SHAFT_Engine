package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Settings {

    private WebDriver driver;
    private static By PaymentMethodSetting_Button;

    public Settings(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            PaymentMethodSetting_Button = MobileBy.xpath("(//android.widget.TextView[@content-desc=\"id_account_settings_item_title\"])[3]");
        } else {
            PaymentMethodSetting_Button = MobileBy.AccessibilityId("Payment method");
        }
    }


    public void pressPaymentMethodOption() {
        ElementActions.performTouchAction(driver).tap(PaymentMethodSetting_Button);
    }
}
