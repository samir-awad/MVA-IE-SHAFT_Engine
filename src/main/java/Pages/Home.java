package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Assertions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private final WebDriver driver;
    private By Discover_text;
    private By OffersPageHeader_button; //The image above see all offers link
    private By Support_button;
    private By BuyAndManageAddOns_button;
    private By VodafoneLogo;
    private By BillTile;
    private By ClickNextBillTitle;
    private By Essentials_text;
    private By BillAndPayment;
    private By ShowMore_button;
    private By OtherUsefulTools_text;
    private By UnlockYourDevice_text;
    private By SeeAllOffers_button;
    private By AmountDueTile;
    private By DirectDebitTile;
    private By OtherUsefulTools;
    private By ChangePlan_Button;
    private By InactiveToUp;
    private By BalanceTitle;
    private By TopUpHistoryTile;
    private By PAYG_Tray;
    private By ActiveToUp;
    private By Change_button;
    private By SelectAccountAndSubscriptionTitle;
    private By NewSubscription;
    private By ChangeAccount;
    private By AccountChanged;
    private By Close_Button;
    private By Select_Button;
    private By LastBileTile;
    private By TvAddOnsTile;
    private By EssentialsSectionFixed_WithTV;
    private By SupportTrayMenuPAYG;
    private By AccountOverlaySetting_text;
    private By Account;
    private By TopUpOverlayTitle_text;
    private By TopUp_button;
    private By TopUpHistory_button;
    private By BuyAndManageAddOns_text;
    private By TakeQuickTour_Tile;
    private By SendWebText_button;
    private By Essentials_ShowMore;
    private By DevicesAndSim_button;

    public Home(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {

            Discover_text = MobileBy.AccessibilityId("id_dashboard_discover_title");
            BuyAndManageAddOns_button = MobileBy.AccessibilityId("id_dashboard_essentials_addons_clickable");
            VodafoneLogo = MobileBy.AccessibilityId("id_header_vodafone_logo");
            BillTile = MobileBy.AccessibilityId("id_dashboard_next_bill_title");
            ClickNextBillTitle = MobileBy.AccessibilityId("id_dashboard_next_bill_title");
            Essentials_text = MobileBy.AccessibilityId("id_dashboard_essentials_title");
            BillAndPayment = MobileBy.AccessibilityId("id_tray_menu_item_Bills & Payments");
            ShowMore_button = MobileBy.AccessibilityId("id_dashboard_essentials_see_more_less_label");
            OtherUsefulTools_text = MobileBy.AccessibilityId("id_dashboard_tools_title");
            UnlockYourDevice_text = MobileBy.AccessibilityId("id_dashboard_tools_device_and_sim_b_sheet_NAC_clickable");
            OffersPageHeader_button = MobileBy.AccessibilityId("id_dashboard_discover_card_image");
            Support_button = MobileBy.AccessibilityId("id_dashboard_live_chat_tile_title");
            SeeAllOffers_button = MobileBy.AccessibilityId("id_dashboard_discover_see_all_offers_label");
            ClickNextBillTitle = MobileBy.AccessibilityId("id_dashboard_next_bill_title");
            AmountDueTile = MobileBy.AccessibilityId("id_dashboard_amount_due_title");
            DirectDebitTile = MobileBy.AccessibilityId("id_dashboard_direct_debit_title");
            OtherUsefulTools = MobileBy.AccessibilityId("id_dashboard_tools_title");
            ChangePlan_Button = MobileBy.AccessibilityId("d_dashboard_essentials_change_plan_clickable");
            InactiveToUp = MobileBy.AccessibilityId("id_dashboard_my_usage_exception_noActiveTopUpOffer_text");
            BalanceTitle = MobileBy.AccessibilityId("id_dashboard_balance_title");
            TopUpHistoryTile = MobileBy.AccessibilityId("id_dashboard_topup_history_title");
            PAYG_Tray = MobileBy.AccessibilityId("id_tray_menu_item_Top Up");
            ActiveToUp = MobileBy.AccessibilityId("id_dashboard_my_usage_plan_name");
            Change_button = MobileBy.AccessibilityId("id_dashboard_change_subscription");
            SelectAccountAndSubscriptionTitle = MobileBy.AccessibilityId("id_dashboard_change_subscription_title");
            NewSubscription = MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"id_dashboard_change_subscription_subscriptions_item\"])[2]");
            ChangeAccount = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Spinner");
            AccountChanged = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]");
            Close_Button = MobileBy.xpath("//android.widget.ImageView[@content-desc=\"id_dashboard_change_subscription_close\"]");
            Select_Button = MobileBy.AccessibilityId("id_dashboard_change_subscription_select_button");
            LastBileTile = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]");
            TvAddOnsTile = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[1]");
            EssentialsSectionFixed_WithTV = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView");
            SupportTrayMenuPAYG = MobileBy.AccessibilityId("id_tray_menu_item_label_Support");
            AccountOverlaySetting_text = MobileBy.AccessibilityId("id_account_overlay_Settings_title");
            Account = MobileBy.AccessibilityId("id_tray_menu_item_Account");
            TopUpOverlayTitle_text = MobileBy.AccessibilityId("STundefinedMainTitle");
            TopUp_button = MobileBy.AccessibilityId("id_tray_menu_item_Top Up");
            TopUpHistory_button = MobileBy.AccessibilityId("id_dashboard_topup_history_title");
            SendWebText_button = MobileBy.AccessibilityId("id_dashboard_tools_webtext_label");
            DevicesAndSim_button = MobileBy.AccessibilityId("id_dashboard_tools_device_and_sim_clickable");

        } else {

            Discover_text = MobileBy.AccessibilityId("id_dashboard_discover_title");
            BuyAndManageAddOns_button = MobileBy.AccessibilityId("id_dashboard_essentials_addons_clickable");
            VodafoneLogo = MobileBy.AccessibilityId("id_header_vodafone_logo");
            BillTile = MobileBy.AccessibilityId("id_dashboard_next_bill_clickable");
            ClickNextBillTitle = MobileBy.AccessibilityId("id_dashboard_next_bill_clickable");
            Essentials_text = MobileBy.AccessibilityId("id_dashboard_essentials_title");
            ShowMore_button = MobileBy.AccessibilityId("id_dashboard_essentials_see_more_less_label");
            OtherUsefulTools_text = MobileBy.AccessibilityId("id_dashboard_tools_title");
            BillAndPayment = MobileBy.AccessibilityId("id_tray_menu_item_Bills & Payments");
            ShowMore_button = MobileBy.AccessibilityId("id_dashboard_essentials_see_more_less_label");
            OtherUsefulTools_text = MobileBy.AccessibilityId("id_dashboard_tools_title");
            UnlockYourDevice_text = MobileBy.AccessibilityId("id_dashboard_tools_nac_label");
            OffersPageHeader_button = MobileBy.AccessibilityId("id_dashboard_discover_card_image");
            Support_button = MobileBy.AccessibilityId("id_tray_menu_item_Support");
            SeeAllOffers_button = MobileBy.AccessibilityId("id_dashboard_discover_see_all_offers");
            ClickNextBillTitle = MobileBy.AccessibilityId("id_dashboard_next_bill_title");
            AmountDueTile = MobileBy.AccessibilityId("id_dashboard_amount_due_clickable");
            DirectDebitTile = MobileBy.AccessibilityId("id_dashboard_direct_debit_clickable");
            OtherUsefulTools = MobileBy.AccessibilityId("id_dashboard_tools_title");
            ChangePlan_Button = MobileBy.AccessibilityId("d_dashboard_essentials_change_plan_clickable");
            InactiveToUp = MobileBy.AccessibilityId("id_dashboard_my_usage_exception_noActiveTopUpOffer_text");
            BalanceTitle = MobileBy.AccessibilityId("id_dashboard_balance_clickable");
            TopUpHistoryTile = MobileBy.AccessibilityId("id_dashboard_topup_history_title");
            PAYG_Tray = MobileBy.AccessibilityId("id_tray_menu_item_Top Up");
            ActiveToUp = MobileBy.AccessibilityId("id_dashboard_my_usage_plan_name");
            Change_button = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"id_dashboard_change_subscription\"]");
            SelectAccountAndSubscriptionTitle = MobileBy.AccessibilityId("id_dashboard_change_subscription_title");
            NewSubscription = MobileBy.AccessibilityId("id_dashboard_change_subscription_subscriptions");
            ChangeAccount = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Spinner");
            AccountChanged = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]");
            Close_Button = MobileBy.xpath("//android.widget.ImageView[@content-desc=\"id_dashboard_change_subscription_close\"]");
            Select_Button = MobileBy.AccessibilityId("Select");
            LastBileTile = MobileBy.AccessibilityId("id_dashboard_last_bill_clickable");
            TvAddOnsTile = MobileBy.AccessibilityId("id_dashboard_tv_addons_clickable");
            EssentialsSectionFixed_WithTV = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView");
            SupportTrayMenuPAYG = MobileBy.AccessibilityId("id_tray_menu_item_Support");
            AccountOverlaySetting_text = MobileBy.AccessibilityId("Settings Account, personal details & app settings");
            Account = MobileBy.AccessibilityId("id_tray_menu_item_Account");
            TopUpOverlayTitle_text = MobileBy.AccessibilityId("STundefinedMainTitle");
            TopUp_button = MobileBy.AccessibilityId("id_tray_menu_item_Top Up");
            TopUpHistory_button = MobileBy.AccessibilityId("id_dashboard_topup_history_title");
            TakeQuickTour_Tile = MobileBy.AccessibilityId("id_dashboard_whats_new_clickable");
            Essentials_ShowMore = MobileBy.AccessibilityId("id_dashboard_essentials_see_more_less");
        }
    }


    public By getEssentials_text() {
        return Essentials_text;
    }

    public By getSeeAllOffers_button() {
        return SeeAllOffers_button;
    }

    public By getSupportTrayMenuPAYG() {
        return SupportTrayMenuPAYG;
    }

    public By getTopUpOverlayTitle_text() {
        return TopUpOverlayTitle_text;
    }

    public By getBalanceTitle() {
        return BalanceTitle;
    }

    public By getVodafoneLogo() {
        return VodafoneLogo;
    }

    public By getDiscover_text() {
        return Discover_text;
    }

    public By getOffersPageHeader_button() {
        return OffersPageHeader_button;
    }

    public By getSupport_button() {
        return Support_button;
    }

    public By getBuyAndManageAddOns_button() {
        return BuyAndManageAddOns_button;
    }

    public By getBillTile() {
        return BillTile;
    }

    public By getClickNextBillTitle() {
        return ClickNextBillTitle;
    }

    public By getBillAndPayment() {
        return BillAndPayment;
    }

    public By getShowMore_button() {
        return ShowMore_button;
    }

    public By getOtherUsefulTools_text() {
        return OtherUsefulTools_text;
    }

    public By getUnlockYourDevice_text() {
        return UnlockYourDevice_text;
    }

    public By getAmountDueTile() {
        return AmountDueTile;
    }

    public By getDirectDebitTile() {
        return DirectDebitTile;
    }


    public By getChangePlan_Button() {
        return ChangePlan_Button;
    }

    public By getInactiveToUp() {
        return InactiveToUp;
    }

    public By getTopUpHistoryTile() {
        return TopUpHistoryTile;
    }

    public By getPAYG_Tray() {
        return PAYG_Tray;
    }

    public By getActiveToUp() {
        return ActiveToUp;
    }

    public By getChange_button() {
        return Change_button;
    }

    public By getSelectAccountAndSubscriptionTitle() {
        return SelectAccountAndSubscriptionTitle;
    }

    public By getNewSubscription() {
        return NewSubscription;
    }

    public By getChangeAccount() {
        return ChangeAccount;
    }

    public By getAccountChanged() {
        return AccountChanged;
    }

    public By getClose_Button() {
        return Close_Button;
    }

    public By getSelect_Button() {
        return Select_Button;
    }

    public By getLastBileTile() {
        return LastBileTile;
    }

    public By getTvAddOnsTile() {
        return TvAddOnsTile;
    }

    public By getEssentialsSectionFixed_WithTV() {
        return EssentialsSectionFixed_WithTV;
    }

    public By getAccountOverlaySetting_text() {
        return AccountOverlaySetting_text;
    }

    public By getAccount() {
        return Account;
    }

    public By getTopUp_button() {
        return TopUp_button;
    }

    public By getTopUpHistory_button() {
        return TopUpHistory_button;
    }

    public By getBuyAndManageAddOns_text() {
        return BuyAndManageAddOns_text;
    }

    public By getTakeQuickTour_Tile() {
        return TakeQuickTour_Tile;
    }


    public By getEssentials_ShowMore() {
        return Essentials_ShowMore;
    }

    public By getOtherUsefulTools() {
        return OtherUsefulTools;
    }

    public By getSendWebText_button() {
        return SendWebText_button;
    }

    public By getDevicesAndSim_button() {
        return DevicesAndSim_button;
    }


    //Check existence methods
    public void checkEssentialsSection() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(BuyAndManageAddOns_button, TouchActions.SwipeDirection.UP);
        Assertions.assertElementExists(driver, Essentials_text);
    }

    public boolean checkEssentialsSectionFixedWithTv() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(EssentialsSectionFixed_WithTV, TouchActions.SwipeDirection.UP);
        return ElementActions.isElementDisplayed(driver, EssentialsSectionFixed_WithTV);
    }

    public void pressSelectAccountAndSubscriptionSelectButton() {
        ElementActions.performTouchAction(driver).tap(Select_Button);
    }

    public boolean checkLastBillTile() {
        return ElementActions.isElementDisplayed(driver, LastBileTile);
    }

    public void changeTheSelectedSubscription() {
        ElementActions.performTouchAction(driver).tap(NewSubscription);
    }

    public void pressSelectAccountAndSubscriptionCloseButton() {
        ElementActions.performTouchAction(driver).tap(Close_Button);
    }

    public void checkOtherUsefulToolsSection() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(DevicesAndSim_button, TouchActions.SwipeDirection.UP);
        Assertions.assertElementExists(driver, OtherUsefulTools);
    }

    public void swipeToOtherUsefulTools() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(OtherUsefulTools, TouchActions.SwipeDirection.UP);

    }

    public boolean checkAccountSuccessfullySelected() {
        return ElementActions.isElementDisplayed(driver, AccountChanged);
    }

    public boolean checkTvAddOnsTile() {
        return ElementActions.isElementDisplayed(driver, TvAddOnsTile);
    }

    public void pressViewOrChangePlan() {
        ElementActions.performTouchAction(driver).tap(ChangePlan_Button);

    }

    public void changeTheSelectedAccount() {
        ElementActions.performTouchAction(driver).tap(ChangeAccount);
    }

    public boolean checkTrayMenuOptionsForPayg() {
        return ElementActions.isElementDisplayed(driver, PAYG_Tray);
    }

    public boolean checkTopUpOfferTileInactiveTopUp() {
        return ElementActions.isElementDisplayed(driver, InactiveToUp);
    }

    public boolean checkTopUpOfferTileActiveTopUp() {
        return ElementActions.isElementDisplayed(driver, ActiveToUp);

    }

    public boolean checkBalanceTile() {
        return ElementActions.isElementDisplayed(driver, BalanceTitle);
    }

    public boolean checkSelectAccountAndSubscriptionComponentContent() {
        return ElementActions.isElementDisplayed(driver, SelectAccountAndSubscriptionTitle);
    }

    public boolean checkTopUpHistoryTile() {
        return ElementActions.isElementDisplayed(driver, TopUpHistoryTile);
    }

    public boolean checkAmountDueTile() {
        return ElementActions.isElementDisplayed(driver, AmountDueTile);
    }

    public boolean checkDirectDebitTile() {
        return ElementActions.isElementDisplayed(driver, DirectDebitTile);
    }

    public void checkDiscoverySection() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(Discover_text, TouchActions.SwipeDirection.UP);
        Assertions.assertElementExists(driver, Discover_text);
    }

    //for Bill Pay
    public boolean checkSupportSection() {
        return ElementActions.isElementDisplayed(driver, Support_button);
    }

    public By getCheckTheVodafoneLogo() {
        return VodafoneLogo;
    }

    public boolean checkSelectAccountAndSubscriptionComponent() {
        return ElementActions.isElementDisplayed(driver, Change_button);
    }

    public void pressSelectAccountAndSubscriptionComponent() {
        ElementActions.performTouchAction(driver).tap(Change_button);
    }


    public boolean checkNextBillTile() {
        return ElementActions.isElementDisplayed(driver, BillTile);
    }

    public void pressNextBillTile() {
        ElementActions.performTouchAction(driver).tap(ClickNextBillTitle);
    }

    public boolean checkTrayMenuOptionsForBillPay() {
        return ElementActions.isElementDisplayed(driver, BillAndPayment);
    }

    //Actions methods
    public void pressBillsPaymentsTrayMenuOption() {
        ElementActions.performTouchAction(driver).tap(BillAndPayment);
    }

    public void pressBalanceTitle() {
        ElementActions.performTouchAction(driver).tap(BalanceTitle);
    }

    public void pressTopUpTrayMenu() {
        ElementActions.performTouchAction(driver).tap(TopUp_button);
    }

    public void pressTopUpHistoryTitle() {
        ElementActions.performTouchAction(driver).tap(TopUpHistory_button);
    }

    //DirectDebits
    public By getDirectDebit_Tab() {
        return DirectDebitTile;
    }

    public void pressAccountTrayMenuOption() {
        ElementActions.performTouchAction(driver).tap(Account);
    }

    public Boolean CheckAccountOverlaySettingText() {
        return ElementActions.isElementDisplayed(driver, AccountOverlaySetting_text);
    }

    public void pressAccountSettingOption() {
        ElementActions.performTouchAction(driver).tap(AccountOverlaySetting_text);
    }

    public void pressDirectDebitTile() {
        ElementActions.performTouchAction(driver).tap(DirectDebitTile);
    }

    public void opedAddOnsOverlay() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(BuyAndManageAddOns_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(BuyAndManageAddOns_button);
    }

    public void pressSeeAllOffersLink() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(SeeAllOffers_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(SeeAllOffers_button);
    }

    public void openOffersPageHeader() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(OffersPageHeader_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(OffersPageHeader_button);
    }

    public void pressSupportTitle() { //For Bill Pay user
        ElementActions.performTouchAction(driver).tap(Support_button);
    }

    public void pressSupportTrayView() {
        ElementActions.performTouchAction(driver).tap(SupportTrayMenuPAYG);
    }

    public void pressSendWebTextOption() {
        ElementActions.performTouchAction(driver).tap(SendWebText_button);
    }

    public void pressNacRequestOption() {
        ElementActions.performTouchAction(driver).tap(getUnlockYourDevice_text());
    }
}
