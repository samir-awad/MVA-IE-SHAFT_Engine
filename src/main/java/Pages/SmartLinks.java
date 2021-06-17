package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartLinks {
    private final MobileDriver driver;

    private static By Go_button;


    public SmartLinks(WebDriver driver) {
        this.driver = (MobileDriver) driver;

        Go_button = MobileBy.AccessibilityId("Go");
    }

    public void accessSmartLink(String URL) {
        ElementActions.performTouchAction(driver).sendAppToBackground(-1);
        if (System.getProperty("targetOperatingSystem").equals("iOS")) {
            driver.findElementByAccessibilityId("Chrome").isDisplayed();
            driver.findElementByAccessibilityId("Chrome").click();
//            driver.findElementByAccessibilityId("kToolbarNewTabButtonIdentifier").isDisplayed();
//            driver.findElementByAccessibilityId("kToolbarNewTabButtonIdentifier").click();
//            driver.findElementByAccessibilityId("NTPHomeFakeOmniboxAccessibilityID]").isDisplayed();
//            driver.findElementByAccessibilityId("NTPHomeFakeOmniboxAccessibilityID]").click();
            driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Search or type URL\"])[2]").isDisplayed();
            driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Search or type URL\"])[2]").sendKeys(URL);
            driver.findElementByAccessibilityId("Go").isDisplayed();
            ElementActions.performTouchAction(driver).tap(Go_button);
            //driver.findElementByAccessibilityId("Go").click();
            driver.terminateApp("com.google.chrome.ios");
        } else {
            driver.get(URL);
        }
    }

}
