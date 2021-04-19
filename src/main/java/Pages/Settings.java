package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Settings {

    public Settings(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;

    private By PaymentMethodSetting_Button = By.xpath("(//android.widget.TextView[@content-desc=\"id_account_settings_item_title\"])[3]");

    public void pressPaymentMethodOption()
    {
        ElementActions.performTouchAction(driver).tap(PaymentMethodSetting_Button);
    }
}
