package Pages;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SmartLinks {
    private final MobileDriver driver;

    public SmartLinks(WebDriver driver) {
        this.driver = (MobileDriver) driver;
    }

    public void accessOffersSmartLink(String URL){
        ElementActions.performTouchAction(driver).sendAppToBackground(-1);
        //driver.runAppInBackground(Duration.ofSeconds(-1));
        //BrowserActions.navigateToURL(driver,URL);
        driver.get(URL);
    }

}
