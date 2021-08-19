package PagesOnePlatform;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class OnBoarding {
    private final AppiumDriver driver;

    public static By getTermsAndConditionsHeader_text() {
        return TermsAndConditionsHeader_text;
    }

    private static By TermsAndConditionsHeader_text;
    private By TermsAndConditionsAgree_checkbox;
    private By TermsAndConditionsContinue_button;

    //Bill Pay locators
    private By LetsGo_button;
    private By YourPrivacyContinue_button;
    private By ConfirmYourPersonalPreferences_button;
    private By PaymentMethodContinue_button;
    private By PermissionsContinue_button;
    private By GetStarted_button;

    //PAYG
    private By PersonalDetailsContinue_button;

    public OnBoarding(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
        TermsAndConditionsHeader_text= MobileBy.AccessibilityId("TermsTermsTitle");
        TermsAndConditionsAgree_checkbox=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.CheckBox");
        TermsAndConditionsContinue_button=MobileBy.AccessibilityId("TermsContinueButton");
        //BillPay
        LetsGo_button=MobileBy.xpath("//android.widget.TextView[@content-desc=\"OBstartButton\"]");
        YourPrivacyContinue_button=MobileBy.AccessibilityId("id_privacy_policy_continue_button_label");
        ConfirmYourPersonalPreferences_button=MobileBy.AccessibilityId("id_onboarding_personal_preferences_continue_button_label");
        PaymentMethodContinue_button=MobileBy.AccessibilityId("id_onboarding_payment_method_continue_button_label");
        PermissionsContinue_button=MobileBy.AccessibilityId("id_onboarding_permissions_continue_button_label");
        GetStarted_button=MobileBy.AccessibilityId("OBgetStartedButton");
        //PAYG
        PersonalDetailsContinue_button=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
        }
        else {
            YourPrivacyContinue_button=MobileBy.AccessibilityId("id_privacy_policy_continue_button_label");
            ConfirmYourPersonalPreferences_button=MobileBy.AccessibilityId("id_onboarding_personal_preferences_continue_button_label");
            PaymentMethodContinue_button=MobileBy.AccessibilityId("id_onboarding_payment_method_continue_button_label");
            PermissionsContinue_button=MobileBy.AccessibilityId("id_onboarding_permissions_continue_button_label");
            GetStarted_button=MobileBy.AccessibilityId("OBgetStartedButton");
        }
    }

    public OnBoarding acceptTermsAndConditions(){
        new ElementActions(driver).performTouchAction()
                .tap(TermsAndConditionsAgree_checkbox)
                .tap(TermsAndConditionsContinue_button);
        return this;
    }

    public Dashboard acceptPermissionsBillPay(){
       new ElementActions(driver).performTouchAction()
                .tap(LetsGo_button)
                .tap(YourPrivacyContinue_button)
                .tap(ConfirmYourPersonalPreferences_button)
                .tap(PaymentMethodContinue_button)
                .swipeElementIntoView(PermissionsContinue_button, TouchActions.SwipeDirection.UP)
                .tap(PermissionsContinue_button)
                .tap(GetStarted_button);
        return new Dashboard(driver);
    }

    public Dashboard acceptPermissionsPAYG(){
        new ElementActions(driver).performTouchAction()
                .tap(LetsGo_button)
                .tap(YourPrivacyContinue_button)
                .tap(ConfirmYourPersonalPreferences_button)
                .tap(PersonalDetailsContinue_button)
                .tap(PermissionsContinue_button);
        return new Dashboard(driver);
    }
}
