package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

    private WebDriver driver;
    private static By Logout_Button;
    private static By LogoutOverlay;
    private static By LogoutNo_Button;
    private static By LogoutYes_Button;
    private Home HomePage;


    public Logout(WebDriver driver) {

        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            Logout_Button = MobileBy.AccessibilityId("id_account_overlay_button_logout");
            LogoutOverlay = MobileBy.AccessibilityId("error_pop_up_title");
            LogoutNo_Button = MobileBy.AccessibilityId("id_error_pop_up_close_button");
            LogoutYes_Button = MobileBy.AccessibilityId("id_error_pop_up_main_button");
        } else {
            Logout_Button = MobileBy.AccessibilityId("Log out");
            LogoutYes_Button = MobileBy.AccessibilityId("Yes");
            LogoutNo_Button = MobileBy.AccessibilityId("No");
            LogoutOverlay = MobileBy.AccessibilityId("error_pop_up_title");
        }

    }

    public void pressLogoutButton() {
        ElementActions.performTouchAction(driver).tap(Logout_Button);
    }

    public void LogOut() {
        ElementActions.performTouchAction(driver).tap(HomePage.getAccount());
        ElementActions.performTouchAction(driver).tap(Logout_Button);
        ElementActions.performTouchAction(driver).tap(LogoutYes_Button);
    }

    public By getCheckLogoutOverlay() {
        return LogoutOverlay;
    }

    public void pressLogoutNoButton() {
        ElementActions.performTouchAction(driver).tap(LogoutNo_Button);
    }

    public void pressLogoutYesButton() {
        ElementActions.performTouchAction(driver).tap(LogoutYes_Button);
    }
}
