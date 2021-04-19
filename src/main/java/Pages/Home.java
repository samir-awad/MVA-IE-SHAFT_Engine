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
    private final By VodafoneLogo = new MobileBy.ByAccessibilityId("id_header_vodafone_logo");
    private final By BillTile = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
    private final By ClickNextBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
    private final By Essentials_text = new MobileBy.ByAccessibilityId("id_dashboard_essentials_title");
    private final By BillAndPayment = new MobileBy.ByAccessibilityId("id_tray_menu_item_Bills & Payments");
    private final By ShowMore_button= new MobileBy.ByAccessibilityId("id_dashboard_essentials_see_more_less_label");
    private final By OtherUsefulTools_text= new MobileBy.ByAccessibilityId("id_dashboard_tools_title");
    private final By DirectDebit_Tile = new MobileBy.ByAccessibilityId("id_dashboard_direct_debit_title");
    private final By Account = new MobileBy.ByAccessibilityId("id_tray_menu_item_Account");
    private final By AccountOverlaySetting_text = new MobileBy.ByAccessibilityId("id_account_overlay_Settings_title");



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
        ElementActions.performTouchAction(driver).tap(ClickNextBillTitle);
    }
    public Boolean checkTrayMenuOptionsForBillPay(){
        return ElementActions.isElementDisplayed(driver,BillAndPayment);
    }
    public void pressBillsPaymentsTrayMenuOption(){
        ElementActions.performTouchAction(driver).tap(BillAndPayment);
    }
    //DirectDebits
    public By getDirectDebit_Tab()
    {
        return DirectDebit_Tile;
    }
    public void pressAccountTrayMenuOption(){
        ElementActions.performTouchAction(driver).tap(Account);
    }
    public Boolean CheckAccountOverlaySettingText()
    {
        return ElementActions.isElementDisplayed(driver,AccountOverlaySetting_text);
    }
    public void pressAccountSettingOption() {
        ElementActions.performTouchAction(driver).tap(AccountOverlaySetting_text);
    }

    public Boolean checkDirectDebitTile()
    {
        return ElementActions.isElementDisplayed(driver,DirectDebit_Tile);
    }

    public void pressDirectDebitTile()
    {
        ElementActions.performTouchAction(driver).tap(DirectDebit_Tile);
    }



}
