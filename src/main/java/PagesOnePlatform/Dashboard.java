package PagesOnePlatform;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class Dashboard {
    private final AppiumDriver driver;
    private By TrayAccount;
    public By getTrayAccount() {
        return TrayAccount;
    }

    public By getDiscoverTitle_text() {
        return DiscoverTitle_text;
    }
    private By DiscoverTitle_text;

    public By getFirstUsageCard() {
        return FirstUsageCard;
    }

    private By FirstUsageCard;
    private By SecondUsageCard;

    public Dashboard(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            TrayAccount= MobileBy.AccessibilityId("trayAccount");
            DiscoverTitle_text=MobileBy.AccessibilityId("DBdiscoverTitle");
            FirstUsageCard=MobileBy.AccessibilityId("mainCard");
            SecondUsageCard=MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"mainCard\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]");
        }
        else{
            TrayAccount= MobileBy.AccessibilityId("trayAccount");
            DiscoverTitle_text=MobileBy.AccessibilityId("DBdiscoverTitle");
            FirstUsageCard=MobileBy.AccessibilityId("mainCard");
        }
    }

    public MyAccountTray openAccountTray(){
        new ElementActions(driver).
                performTouchAction().
                tap(TrayAccount);
        return new MyAccountTray(driver);
    }

    public Dashboard SwipeToSecondUsageCard(){
        new ElementActions(driver)
                .performTouchAction()
                .swipeElementIntoView(SecondUsageCard, TouchActions.SwipeDirection.LEFT);
        return this;
    }





}
