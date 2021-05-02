package Pages;

import com.shaft.gui.browser.BrowserActions;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SmartLinks {
    private final MobileDriver driver;

    public SmartLinks(WebDriver driver) {
        this.driver = (MobileDriver) driver;
    }

    public void accessOffersSmartLink(String URL){
        driver.runAppInBackground(Duration.ofSeconds(-1));
        driver.get(URL);
        //BrowserActions.navigateToURL(driver,URL);
    }
}
