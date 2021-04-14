package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private final WebDriver driver;
    private final By AcceptTerms_button = new MobileBy.ByAccessibilityId("id_TC_switch_accept_terms");
    private final By Continue_button = new MobileBy.ByAccessibilityId("id_tc_agree_button");
    private final By Vodafone_Logo = new MobileBy.ByAccessibilityId("id_login_and_register_logo");
    private final By Reg_Login_Button = new MobileBy.ByAccessibilityId("signup_signin_login_btn");
    private final By PhoneOrEmail_TxtField = new MobileBy.ByAccessibilityId("id_login_edittext_username");
    private final By Password_TxtField = new MobileBy.ByAccessibilityId("id_login_edittext_password");
    private final By Login_button = new MobileBy.ByAccessibilityId("id_login_button_login");
    private final By LetsGo_Button = By.xpath("//android.widget.TextView[@content-desc=\"OBstartButton\"]");
    private final By PrivacyContinue_button = new MobileBy.ByAccessibilityId("id_privacy_policy_continue_button");
    private final By PersonalPreferencesContinue_button = new MobileBy.ByAccessibilityId("id_onboarding_personal_preferences_continue_button");
    private final By OnboardingPersonalDetailsContinue_button = new MobileBy.ByAccessibilityId("id_onboarding_personal_details_continue_button");
    private final By PermissionsContinue_button = new MobileBy.ByAccessibilityId("id_onboarding_permissions_continue_button");
    private final By GoToTheApp_button = new MobileBy.ByAccessibilityId("OBgetStartedButton");
    private final By GoToMyVodafone_button = new MobileBy.ByAccessibilityId("id_tutorials_dismiss_button");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public Login acceptTermsAndConditions() {
        ElementActions.performTouchAction(driver).tap(AcceptTerms_button);
        ElementActions.performTouchAction(driver).tap(Continue_button);
        return this;
    }

    public Login login() {
        ElementActions.performTouchAction(driver).tap(Reg_Login_Button);
        ElementActions.type(driver, PhoneOrEmail_TxtField, "0876352242");
        ElementActions.type(driver, Password_TxtField, "Mountainview01!");
        ElementActions.performTouchAction(driver).tap(Login_button);
        return this;
    }

    public void acceptPermissions() {
        ElementActions.performTouchAction(driver).tap(LetsGo_Button);
        ElementActions.performTouchAction(driver).tap(PrivacyContinue_button);
        //ElementActions.performTouchAction(driver).swipeElementIntoView(PersonalPreferencesContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(PersonalPreferencesContinue_button);
        ElementActions.performTouchAction(driver).tap(OnboardingPersonalDetailsContinue_button);
        // ElementActions.performTouchAction(driver).swipeElementIntoView(PermissionsContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(PermissionsContinue_button);
        ElementActions.performTouchAction(driver).tap(GoToTheApp_button);
        ElementActions.performTouchAction(driver).tap(GoToMyVodafone_button);
    }

    public By getLetsGo_Button() {
        return LetsGo_Button;
    }

    public By getVodafone_Logo() {
        return Vodafone_Logo;
    }

}
