package PagesOnePlatform;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MyAccountTray {
    private final AppiumDriver driver;

    public By getAccountTitle_text() {
        return AccountTitle_text;
    }
    private By AccountTitle_text;
    private By Settings_button;
    private By MyRecords_button;
    private By OurPrivacy_button;
    private By Logout_button;



    public MyAccountTray(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            AccountTitle_text = MobileBy.AccessibilityId("STaccountMainTitle");
            Settings_button =MobileBy.AccessibilityId("STaccountItem1Title");
            MyRecords_button=MobileBy.AccessibilityId("STaccountItem2Title");
            OurPrivacy_button=MobileBy.AccessibilityId("STaccountItem3Title");
            Logout_button=MobileBy.AccessibilityId("STaccountItem4Title");

        }
        else {

        }
    }

    public Settings openSetting(){
        new ElementActions(driver).performTouchAction().tap(Settings_button);
        return new Settings(driver);
    }

    public MyRecords openMyRecords(){
        new ElementActions(driver).performTouchAction().tap(MyRecords_button);
        return new MyRecords(driver);
    }

    public OurPrivacy openOurPrivacy(){
        new ElementActions(driver).performTouchAction().tap(OurPrivacy_button);
        return new OurPrivacy(driver);
    }

    public Logout logout(){
        new ElementActions(driver).performTouchAction()
                .swipeElementIntoView(Logout_button, TouchActions.SwipeDirection.LEFT)
                .tap(Logout_button);
        return new Logout(driver);
    }





}
