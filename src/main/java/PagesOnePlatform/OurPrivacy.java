package PagesOnePlatform;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class OurPrivacy {
    private final AppiumDriver driver;

    public By getOurPrivacyTitle_text() {
        return OurPrivacyTitle_text;
    }

    private By OurPrivacyTitle_text;


    public OurPrivacy(AppiumDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            //OurPrivacyTitle_text= MobileBy.AccessibilityId(""); // will be added
        }
        else {

        }
    }



}
