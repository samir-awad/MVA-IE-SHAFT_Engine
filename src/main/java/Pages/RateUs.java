package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RateUs {
    private WebDriver driver;
    private By CheckRateUsOverlay;
    private By NoInRateUsPage_Button;
    private By SorryToHearOverlayClose_Button;


    public RateUs(WebDriver driver) {

        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {

            CheckRateUsOverlay = new MobileBy.ByAccessibilityId("error_pop_up_title");
            NoInRateUsPage_Button = new MobileBy.ByAccessibilityId("id_error_pop_up_close_button");
        } else {
            CheckRateUsOverlay = MobileBy.AccessibilityId("error_pop_up_title");
            NoInRateUsPage_Button = MobileBy.AccessibilityId("No");
            SorryToHearOverlayClose_Button = MobileBy.AccessibilityId("Close");
        }
    }


    public By getCheckRateUsOverlay() {
        return CheckRateUsOverlay;
    }

    public By getCheckSorryToHearOverlay() {
        return CheckRateUsOverlay;
    }

    public void pressSorryToHearOverlayCloseButton() {
        ElementActions.performTouchAction(driver).tap(SorryToHearOverlayClose_Button);
    }

    public void PressNoInRateUsPage() {
        ElementActions.performTouchAction(driver).tap(NoInRateUsPage_Button);
    }
}
