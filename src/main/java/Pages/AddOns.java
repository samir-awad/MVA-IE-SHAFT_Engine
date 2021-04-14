package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOns {
    public AddOns(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    //Element locators
    private final By AddOnsHeader_text = new MobileBy.ByAccessibilityId("id_header_title_Buy_add_ons");
    private final By AddOnsHeaderOverlay_text = new MobileBy.ByAccessibilityId("id_dashboard_manage_addons_sheet_title");
    private final By ManageAddOnsOverlayHeader_text = new MobileBy.ByAccessibilityId("id_dashboard_manage_addons_sheet_title");
    private final By OneOff_tab = new MobileBy.ByAccessibilityId("One off (Selected)");
    private final By Recurring_tab = new MobileBy.ByAccessibilityId("Recurring ");
    private final By Recurring_tab_text= new MobileBy.ByAccessibilityId("Recurring (Selected)");
    private final By NoActiveAddOnsOverlay_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView");
    private final By AddOnsCloseOverlay_button = By.xpath("//android.view.ViewGroup[@content-desc=\"id_dashboard_manage_addons_sheet_close\"]");
    private final By GetMoreAddOns_button = new MobileBy.ByAccessibilityId("id_addons_get_addons_button");
    private final By ManageAddOnsOverlay_button = new MobileBy.ByAccessibilityId("id_addons_manage_addons_button");
    private final By ManageAddOns_button = By.xpath("//android.widget.Button[@content-desc=\"id_manage_add_ons_button\"]");
    private final By SelectAddOnsToRemoveOverlayCancel_button = new MobileBy.ByAccessibilityId("id_cancel_add_on_remove_button");
    private final By AddOnsExpiresOverlay_text = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]");
    private final By OneOffListFirstItem_text = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
    private final By AddOnsContinue_button = new MobileBy.ByAccessibilityId("id_continue_add_on_flow_button");
    private final By RecurringListFirstItem_text= By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    private final By Select_button = By.xpath("//android.widget.Button[@content-desc=\"id_select_add_on_button\"])[1]");
    private final By Select_text=By.xpath("//android.widget.Button[@content-desc=\"id_select_add_on_button\"])[1]/android.widget.TextView");

    //Getters of the elements
    public By getNoActiveAddOnsOverlayTxt() {
        return NoActiveAddOnsOverlay_text;
    }

    public By getOneOff_tab() {
        return OneOff_tab;
    }

    public By getRecurringTab() {
        return Recurring_tab;
    }

    public By getAddOnsHeader_text() {
        return AddOnsHeader_text;
    }

    public By getAddOnsHeaderOverlay_text() {
        return AddOnsHeaderOverlay_text;
    }

    public By getAddOnsExpiresOverlay_text() {
        return AddOnsExpiresOverlay_text;
    }

    public By getManageAddOnsOverlayHeader_text() {
        return ManageAddOnsOverlayHeader_text; //Select add ons to remove header
    }

    public By getSelect_text() {
        return Select_text;
    }

    public By getRecurring_tab_text() {
        return Recurring_tab_text;
    }

    //Page methods
    public void openAddOnsPage() {
        ElementActions.performTouchAction(driver).tap(GetMoreAddOns_button);
    }

    public void openManageAddOnsOverlay() {
        ElementActions.performTouchAction(driver).tap(ManageAddOnsOverlay_button);
    }

    public void openRecurringTab() {
        ElementActions.performTouchAction(driver).tap(Recurring_tab);
    }

    public void closeAddOnsOverlay() {
        ElementActions.click(driver, AddOnsCloseOverlay_button);
    }

    public void closeSelectAddOnsToRemoveOverlay() {
        ElementActions.click(driver, SelectAddOnsToRemoveOverlayCancel_button);
    }

    public void clickSelectBtn() {
        ElementActions.click(driver, Select_button);
    }

    //Check existence methods
    public boolean checkBuyAddOnsFirstTab() {
        return ElementActions.isElementDisplayed(driver, OneOff_tab);
    }

    public boolean checkBuyAddOnsSecondTab() {
        return ElementActions.isElementDisplayed(driver, Recurring_tab);
    }

    public boolean checkOneOffListFirstItem() {
        return ElementActions.isElementDisplayed(driver, OneOffListFirstItem_text);
    }

    public boolean checkRecurringListFirstItem() {
        return ElementActions.isElementDisplayed(driver, RecurringListFirstItem_text);
    }

    public boolean checkAddOnsContinueBtn() {
        return ElementActions.isElementDisplayed(driver, AddOnsContinue_button);
    }

    public boolean checkAddOnsOverlay() {
        return ElementActions.isElementDisplayed(driver, NoActiveAddOnsOverlay_text);
    }

    public boolean checkManageAddOnsBtn() {
        return ElementActions.isElementDisplayed(driver, ManageAddOns_button);
    }

}
