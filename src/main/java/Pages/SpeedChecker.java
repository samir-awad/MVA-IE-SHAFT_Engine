package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpeedChecker {
    private final WebDriver driver;
    private static By SpeedCheckerHeader_text;
    private static By SpeedCheckerClose_button;
    private static By GrantPermission_button;
    private static By OnlyThisTime_button;
    private static By PleaseProceed_button;
    private static By NoThanks_button;
    private static By Allow_button;

    public By getSpeedCheckerHeader_text() {
        return SpeedCheckerHeader_text;
    }

    public SpeedChecker(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            SpeedCheckerHeader_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
            SpeedCheckerClose_button = new MobileBy.ByAccessibilityId("NPcloseIcon");
            GrantPermission_button = new MobileBy.ByAccessibilityId("id_error_pop_up_main_button");
            PleaseProceed_button = new MobileBy.ByAccessibilityId("NPgrantPermissionOkActionButton");
            NoThanks_button = new MobileBy.ByAccessibilityId("NPgrantPermissionNoButton");
            Allow_button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]");
        } else {
            //IOS locators
        }
    }

    public void pressSpeedCheckerHeaderCloseButton() {
        ElementActions.performTouchAction(driver).tap(SpeedCheckerClose_button);
    }

    public void pressOkGrantPermissionButton() {
        ElementActions.performTouchAction(driver).tap(GrantPermission_button);
        ElementActions.performTouchAction(driver).tap(Allow_button);
        ElementActions.performTouchAction(driver).tap(PleaseProceed_button);
    }

    public void pressNoThanksButton() {
        ElementActions.performTouchAction(driver).tap(NoThanks_button);

    }
}
