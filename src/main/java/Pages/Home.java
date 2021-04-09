package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    private WebDriver driver;
    private By Discover_text = new MobileBy.ByAccessibilityId("id_dashboard_discover_title");
    private By BuyAndManageAddOns_button = new MobileBy.ByAccessibilityId("id_dashboard_essentials_addons_clickable");
    private By GetMoreAddOns_button = new MobileBy.ByAccessibilityId("id_addons_get_addons_button");

    public By getEssentials_text() {
        return Essentials_text;
    }

    public By getDiscover_text() {
        return Discover_text;
    }

    private By Essentials_text = new MobileBy.ByAccessibilityId("id_dashboard_essentials_title");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkEssentialsSection() {
        //ScrollDown to element Action shall be here
        return ElementActions.isElementDisplayed(driver, Essentials_text);
    }

    public void openAddOnsPage() {
        ElementActions.performTouchAction(driver).tap(BuyAndManageAddOns_button);
        ElementActions.performTouchAction(driver).tap(GetMoreAddOns_button);
    }


}
