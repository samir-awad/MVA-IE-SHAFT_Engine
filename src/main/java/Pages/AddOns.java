package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOns {
    private final WebDriver driver;
    private By AddOnsHeader_text ;
    private By AddOnsHeaderOverlay_text ;
    private By BuyAddOnsHeaderOverlay_text;
    private By ManageAddOnsOverlayHeader_text ;
    private By OneOff_tab ;
    private By Recurring_tab;
    private By Recurring_tab_text;
    private By NoActiveAddOnsOverlay_text;
    private By AddOnsCloseOverlay_button ;
    private By GetMoreAddOns_button;
    private By ManageAddOnsOverlay_button;
    private By ManageAddOns_button;
    private By SelectAddOnsToRemoveOverlayCancel_button;
    private By AddOnsExpiresOverlay_text;
    private By OneOffListFirstItem_text;
    private By AddOnsContinue_button;
    private By RecurringListFirstItem_text;
    private By Select_button;
    private By RecurringContinue_button;
    private By BuyAddOnsCloseOverlay_button;
    private By BuyAddOnsCancelOverlay_button;
    private By AddOneClosePage_button;
    private By AddOneFirstListPAYG_text;
    private By SelectPAYG_button;
    private By BuyAddOnsOverlayClose_button;

    public AddOns(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            AddOnsHeader_text = new MobileBy.ByAccessibilityId("id_header_title_Buy_add_ons");
            AddOnsHeaderOverlay_text = new MobileBy.ByAccessibilityId("id_dashboard_manage_addons_sheet_title");
            BuyAddOnsHeaderOverlay_text = new MobileBy.ByAccessibilityId("id_buy_add_ons_title");
            ManageAddOnsOverlayHeader_text = new MobileBy.ByAccessibilityId("id_dashboard_manage_addons_sheet_title");
            OneOff_tab = new MobileBy.ByAccessibilityId("One off (Selected)");
            Recurring_tab = new MobileBy.ByAccessibilityId("Recurring ");
            Recurring_tab_text = new MobileBy.ByAccessibilityId("Recurring (Selected)");
            NoActiveAddOnsOverlay_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView");
            AddOnsCloseOverlay_button = By.xpath("//android.view.ViewGroup[@content-desc=\"id_dashboard_manage_addons_sheet_close\"]");
            GetMoreAddOns_button = new MobileBy.ByAccessibilityId("id_addons_get_addons_button");
            ManageAddOnsOverlay_button = new MobileBy.ByAccessibilityId("id_addons_manage_addons_button");
            ManageAddOns_button = By.xpath("//android.widget.Button[@content-desc=\"id_manage_add_ons_button\"]");
            SelectAddOnsToRemoveOverlayCancel_button = new MobileBy.ByAccessibilityId("id_cancel_add_on_remove_button");
            AddOnsExpiresOverlay_text = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]");
            OneOffListFirstItem_text = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
            AddOnsContinue_button = new MobileBy.ByAccessibilityId("id_continue_add_on_flow_button");
            RecurringListFirstItem_text = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
            Select_button = By.xpath("(//android.widget.Button[@content-desc=\"id_select_add_on_button\"])[1]/android.widget.TextView");
            RecurringContinue_button = By.xpath("(//android.view.ViewGroup[@content-desc=\"Button\"])[3]");
            BuyAddOnsCloseOverlay_button=By.xpath("//android.view.ViewGroup[@content-desc=\"id_buy_add_ons_close\"]");
            BuyAddOnsCancelOverlay_button=new MobileBy.ByAccessibilityId("id_cancel_buy_add_on_button");
            AddOneClosePage_button =new MobileBy.ByAccessibilityId("id_header_close_icon");
            AddOneFirstListPAYG_text= new MobileBy.ByAccessibilityId("id_add_on_card_item_description1_one_off_0");
            SelectPAYG_button= new MobileBy.ByAccessibilityId("id_select_add_on_button");
            BuyAddOnsOverlayClose_button =By.xpath("//android.widget.ImageView[@content-desc=\"id_buy_add_ons_close\"]");
        }
        else {
            //IOS locators
        }

    }

    //Getters of the elements
    public By getRecurringContinue_button() {
        return RecurringContinue_button;
    }

    public By getBuyAddOnsHeaderOverlay_text() {
        return BuyAddOnsHeaderOverlay_text;
    }

    public By getNoActiveAddOnsOverlay_text() {
        return NoActiveAddOnsOverlay_text;
    }

    public By getOneOff_tab() {
        return OneOff_tab;
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
        return Select_button;
    }

    public By getRecurring_tab_text() {
        return Recurring_tab_text;
    }

    public By getManageAddOns_button() {
        return ManageAddOns_button;
    }

    public By getAddOneFirstListPAYG_text() { return AddOneFirstListPAYG_text; }

    public By getAddOnsContinue_button() { return AddOnsContinue_button; }

    public By getSelectPAYG_button() { return SelectPAYG_button; }

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
        ElementActions.performTouchAction(driver).tap(AddOnsCloseOverlay_button);
    }

    public void closeSelectAddOnsToRemoveOverlay() {
        ElementActions.performTouchAction(driver).tap(SelectAddOnsToRemoveOverlayCancel_button);
    }

    public void clickSelectBtn() {
        ElementActions.performTouchAction(driver).tap(Select_button);
    }

    public void clickRecurringContinueBtn() {
        ElementActions.performTouchAction(driver).tap(RecurringContinue_button);
    }

    public void closeBuyAddOnsOverlay(){
        ElementActions.performTouchAction(driver).tap(BuyAddOnsCloseOverlay_button);
    }

    public void cancelBuyAddOnsOverlay() {
        ElementActions.performTouchAction(driver).tap(BuyAddOnsCancelOverlay_button);
    }

    public void closeAddOnsPage() {
        ElementActions.performTouchAction(driver).tap(AddOneClosePage_button);
    }

    public void pressFirstAddOnSelectButton(){
        ElementActions.performTouchAction(driver).tap(SelectPAYG_button);
    }

    public void pressBuyAddOnsContinueButton(){
        ElementActions.performTouchAction(driver).tap(AddOnsContinue_button);
    }

    public void pressBuyAddOnsOverlayCloseButton(){
        ElementActions.performTouchAction(driver).tap(BuyAddOnsOverlayClose_button);
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
