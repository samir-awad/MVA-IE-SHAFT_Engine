package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private final WebDriver driver;
    private By Discover_text;
    private By BuyAndManageAddOns_button;
    private By VodafoneLogo;
    private By BillTile;
    private By NextBillTitle;
    private By Essentials_text;
    private By BillAndPayment;
    private By ShowMore_button;
    private By OtherUsefulTools_text;
    private By BillsPaymentsTray;


    public Home(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")){

            Discover_text = new MobileBy.ByAccessibilityId("id_dashboard_discover_title");
            BuyAndManageAddOns_button = new MobileBy.ByAccessibilityId("id_dashboard_essentials_addons_clickable");
            VodafoneLogo = new MobileBy.ByAccessibilityId("id_header_vodafone_logo");
            BillTile = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
            NextBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
            Essentials_text = new MobileBy.ByAccessibilityId("id_dashboard_essentials_title");
            BillAndPayment = new MobileBy.ByAccessibilityId("id_tray_menu_item_Bills & Payments");
            ShowMore_button = new MobileBy.ByAccessibilityId("id_dashboard_essentials_see_more_less_label");
            OtherUsefulTools_text = new MobileBy.ByAccessibilityId("id_dashboard_tools_title");
            BillsPaymentsTray = new MobileBy.ByAccessibilityId("id_tray_menu_item_Bills & Payments");

        }else{

            Discover_text = new MobileBy.ByAccessibilityId("id_dashboard_discover_title");
            BuyAndManageAddOns_button = new MobileBy.ByAccessibilityId("id_dashboard_essentials_addons_clickable");
            VodafoneLogo = new MobileBy.ByAccessibilityId("id_header_vodafone_logo");
            BillTile = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_clickable");
            NextBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_clickable");
            Essentials_text = new MobileBy.ByAccessibilityId("id_dashboard_essentials_title");
            BillAndPayment = new MobileBy.ByAccessibilityId("id_tray_menu_item_Bills & Payments");
            ShowMore_button = new MobileBy.ByAccessibilityId("id_dashboard_essentials_see_more_less_label");
            OtherUsefulTools_text = new MobileBy.ByAccessibilityId("id_dashboard_tools_title");
            BillsPaymentsTray = new MobileBy.ByAccessibilityId("id_tray_menu_item_Bills & Payments");

        }
    }

    public By getEssentials_text() {
        return Essentials_text;
    }

    public By getDiscover_text() {
        return Discover_text;
    }

    public boolean checkEssentialsSection() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(OtherUsefulTools_text, TouchActions.SwipeDirection.DOWN, 1);
        return ElementActions.isElementDisplayed(driver, Essentials_text);
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
        ElementActions.performTouchAction(driver).tap(NextBillTitle);
    }
    public Boolean checkTrayMenuOptionsForBillPay(){
        return ElementActions.isElementDisplayed(driver,BillAndPayment);
    }
    public void pressBillsPaymentsTrayMenuOption(){
        ElementActions.performTouchAction(driver).tap(BillAndPayment);
    }

}
