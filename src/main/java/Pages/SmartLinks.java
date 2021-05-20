package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;

public class SmartLinks {
    private final MobileDriver driver;

    public SmartLinks(WebDriver driver) {
        this.driver = (MobileDriver) driver;
    }

    public void accessSmartLink(String URL) {
        ElementActions.performTouchAction(driver).sendAppToBackground(-1);
        if (System.getProperty("targetOperatingSystem").equals("iOS")) {
            driver.findElementByAccessibilityId("Chrome").click();
            driver.findElementByAccessibilityId("kToolbarNewTabButtonIdentifier").click();
            driver.findElementByAccessibilityId("NTPHomeFakeOmniboxAccessibilityID").click();
            driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Search or type URL\"])[2]").sendKeys(URL);
            driver.findElementByAccessibilityId("Go").click();
            driver.terminateApp("com.google.chrome.ios");
        } else {
            driver.get(URL);
        }
    }

}
