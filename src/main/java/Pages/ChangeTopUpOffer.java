package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeTopUpOffer {
    private final WebDriver driver;
    private By ChangeTopUpOfferHeader_text;
    private By ChangeTopUpOfferClose_button;

    public By getChangeTopUpOfferHeader_text() {
        return ChangeTopUpOfferHeader_text;
    }

    public ChangeTopUpOffer(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            ChangeTopUpOfferHeader_text= new MobileBy.ByAccessibilityId("id_header_title_Change_top_up_offer");
            ChangeTopUpOfferClose_button= new MobileBy.ByAccessibilityId("id_header_close_icon");
        }

        else{
            //IOS locators
        }
    }

    public void pressCloseBtn() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferClose_button);
    }
}
