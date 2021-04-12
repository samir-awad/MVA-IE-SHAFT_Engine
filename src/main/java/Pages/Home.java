package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private final WebDriver driver;
    private final By Discover_text = new MobileBy.ByAccessibilityId("id_dashboard_discover_title");
    private final By BuyAndManageAddOns_button = new MobileBy.ByAccessibilityId("id_dashboard_essentials_addons_clickable");
    private final By GetMoreAddOns_button = new MobileBy.ByAccessibilityId("id_addons_get_addons_button");
    private final By VodafoneLogo = new MobileBy.ByAccessibilityId("id_header_vodafone_logo");
    private final By BillTile = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
    private final By ClickNextBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
    private final By Essentials_text = new MobileBy.ByAccessibilityId("id_dashboard_essentials_title");
    private final By BillAndPayment = new MobileBy.ByAccessibilityId("id_tray_menu_item_Bills & Payments");
    //private By PressBillsPaymentsTray = new MobileBy.ByAccessibilityId("id_tray_menu_item_Bills & Payments");

    public By getEssentials_text() {
        return Essentials_text;
    }

    public By getDiscover_text() {
        return Discover_text;
    }

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkEssentialsSection() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(BuyAndManageAddOns_button, TouchActions.SwipeDirection.UP);
        return ElementActions.isElementDisplayed(driver, Essentials_text);
    }

    public void openAddOnsPage() {
        ElementActions.performTouchAction(driver).tap(GetMoreAddOns_button);
    }

    public void opedAddOnsOverlay() {
        ElementActions.performTouchAction(driver).tap(BuyAndManageAddOns_button);
    }

    public boolean checkTheVodafoneLogo() {
        return ElementActions.isElementDisplayed(driver, VodafoneLogo);
    }

    public boolean checkTheNextBillTile() {
        return ElementActions.isElementDisplayed(driver, BillTile);
    }

    public void pressNextBillTile() {
        ElementActions.performTouchAction(driver).tap(ClickNextBillTitle);
    }
    public Boolean checkTrayMenuOptionsForBillPay(){
        return ElementActions.isElementDisplayed(driver,BillAndPayment);
    }
    public void pressBillsPaymentsTrayMenuOption(){
        ElementActions.performTouchAction(driver).tap(BillAndPayment);
    }

}
