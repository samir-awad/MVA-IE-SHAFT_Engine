package PagesOnePlatform;

import com.shaft.gui.element.ElementActions;
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


    public OnBoarding(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
        TermsAndConditionsHeader_text= MobileBy.AccessibilityId("TermsTermsTitle");
        TermsAndConditionsAgree_checkbox=MobileBy.id("TermsToggle");
        TermsAndConditionsContinue_button=MobileBy.AccessibilityId("TermsContinueButton");
        }
        else {}
    }

    public OnBoarding acceptTermsAndConditions(){
        new ElementActions(driver).performTouchAction()
                .tap(TermsAndConditionsAgree_checkbox)
                .tap(TermsAndConditionsContinue_button);
        return this;
    }


}
