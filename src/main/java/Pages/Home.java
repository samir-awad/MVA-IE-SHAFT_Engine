package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private  final WebDriver driver;
    private  By Discover_text;
    private  By BuyAndManageAddOns_button;
    private  By VodafoneLogo ;
    private  By BillTile ;
    private  By ClickNextBillTitle;
    private  By Essentials_text;
    private  By BillAndPayment;
    private  By ShowMore_button;
    private  By OtherUsefulTools_text;
    private  By UnlockYourDevice_text;
    private  By SeeAllOffers_button;
    private  By AmountDueTile;
    private  By DirectDebitTile;
    private  By OtherUsefulTools;
    private  By ChangePlan_Button;
    private  By InactiveToUp;
    private By BalanceTile;
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



    public By getEssentials_text() {
        return Essentials_text;
    }

    public By getDiscover_text() {
        return Discover_text;
    }

    public By getSeeAllOffers_button() {
        return SeeAllOffers_button;
    }

    public Home(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")){
          Discover_text = new MobileBy.ByAccessibilityId("id_dashboard_discover_title");
          BuyAndManageAddOns_button = new MobileBy.ByAccessibilityId("id_dashboard_essentials_addons_clickable");
          VodafoneLogo = new MobileBy.ByAccessibilityId("id_header_vodafone_logo");
          BillTile = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
          ClickNextBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
          Essentials_text = new MobileBy.ByAccessibilityId("id_dashboard_essentials_title");
          BillAndPayment = new MobileBy.ByAccessibilityId("id_tray_menu_item_Bills & Payments");
          ShowMore_button= new MobileBy.ByAccessibilityId("id_dashboard_essentials_see_more_less_label");
          OtherUsefulTools_text= new MobileBy.ByAccessibilityId("id_dashboard_tools_title");
          UnlockYourDevice_text= new MobileBy.ByAccessibilityId("id_dashboard_tools_nac_label");
          SeeAllOffers_button= new MobileBy.ByAccessibilityId("id_dashboard_discover_see_all_offers_label");
          ClickNextBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_title");
          AmountDueTile = new MobileBy.ByAccessibilityId("id_dashboard_amount_due_title");
          DirectDebitTile = new MobileBy.ByAccessibilityId("id_dashboard_direct_debit_title");
          OtherUsefulTools = new MobileBy.ByAccessibilityId("id_dashboard_tools_title");
          ChangePlan_Button = new MobileBy.ByAccessibilityId("d_dashboard_essentials_change_plan_clickable");
          InactiveToUp = new MobileBy.ByAccessibilityId("id_dashboard_my_usage_exception_noActiveTopUpOffer_text");
          BalanceTile = new MobileBy.ByAccessibilityId("id_dashboard_balance_title");
          TopUpHistoryTile =new MobileBy.ByAccessibilityId("id_dashboard_topup_history_title");
          PAYG_Tray = new MobileBy.ByAccessibilityId("id_tray_menu_item_Top Up");
          ActiveToUp = new MobileBy.ByAccessibilityId("id_dashboard_my_usage_plan_name");
          Change_button = new MobileBy.ByAccessibilityId("id_dashboard_change_subscription");
          SelectAccountAndSubscriptionTitle = new MobileBy.ByAccessibilityId("id_dashboard_change_subscription_title");
          NewSubscription = By.xpath( "(//android.view.ViewGroup[@content-desc=\"id_dashboard_change_subscription_subscriptions_item\"])[2]");
          ChangeAccount = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Spinner");
          AccountChanged = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]");
          Close_Button = By.xpath( "//android.widget.ImageView[@content-desc=\"id_dashboard_change_subscription_close\"]");
          Select_Button = new MobileBy.ByAccessibilityId("id_dashboard_change_subscription_select_button");
          LastBileTile = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]");
          TvAddOnsTile = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[1]");
          EssentialsSectionFixed_WithTV = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView");

        }
        else {
            //IOS Locators
        }
    }

    //Check existence methods
    public boolean checkEssentialsSection() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(BuyAndManageAddOns_button, TouchActions.SwipeDirection.DOWN, 1);
        return ElementActions.isElementDisplayed(driver, Essentials_text);
    }
    public boolean checkEssentialsSectionFixedWithTv(){
        ElementActions.performTouchAction(driver).swipeElementIntoView(EssentialsSectionFixed_WithTV, TouchActions.SwipeDirection.DOWN, 1);
        return ElementActions.isElementDisplayed(driver, EssentialsSectionFixed_WithTV);
    }
    public void pressSelectAccountAndSubscriptionSelectButton(){
        ElementActions.performTouchAction(driver).tap(Select_Button);
    }
    public boolean checkLastBillTile(){
        return ElementActions.isElementDisplayed(driver, LastBileTile);
    }
    public void changeTheSelectedSubscription(){
        ElementActions.performTouchAction(driver).tap(NewSubscription);
    }
    public void pressSelectAccountAndSubscriptionCloseButton()
    {
        ElementActions.performTouchAction(driver).tap(Close_Button);
    }

    public boolean checkOtherUsefulToolsSection(){
        ElementActions.performTouchAction(driver).swipeElementIntoView(OtherUsefulTools, TouchActions.SwipeDirection.DOWN, 1);
        return ElementActions.isElementDisplayed(driver, OtherUsefulTools);
    }
    public boolean checkAccountSuccessfullySelected(){
        return ElementActions.isElementDisplayed(driver, AccountChanged);
    }

    public boolean checkTvAddOnsTile(){
        return ElementActions.isElementDisplayed(driver, TvAddOnsTile);
    }
    public void pressViewOrChangePlan(){
        ElementActions.performTouchAction(driver).tap(ChangePlan_Button);

    }
    public void changeTheSelectedAccount(){
        ElementActions.performTouchAction(driver).tap(ChangeAccount);
    }

    public boolean checkTrayMenuOptionsForPayg(){
        return ElementActions.isElementDisplayed(driver, PAYG_Tray);
    }
    public boolean checkTopUpOfferTileInactiveTopUp(){
        return ElementActions.isElementDisplayed(driver, InactiveToUp);
    }
    public boolean checkTopUpOfferTileActiveTopUp()
    {
        return ElementActions.isElementDisplayed(driver, ActiveToUp);

    }
    public boolean checkBalanceTile(){
        return ElementActions.isElementDisplayed(driver, BalanceTile);
    }
    public boolean checkSelectAccountAndSubscriptionComponentContent(){
        return ElementActions.isElementDisplayed(driver, SelectAccountAndSubscriptionTitle);
    }

    public boolean checkTopUpHistoryTile(){
        return ElementActions.isElementDisplayed(driver, TopUpHistoryTile);
    }

    public boolean checkAmountDueTile(){
        return ElementActions.isElementDisplayed(driver, AmountDueTile);
    }
    public boolean checkDirectDebitTile(){
        return ElementActions.isElementDisplayed(driver, DirectDebitTile);
    }
    public boolean checkDiscoverySection()
    {
        ElementActions.performTouchAction(driver).swipeElementIntoView(Discover_text, TouchActions.SwipeDirection.DOWN, 1);
        return ElementActions.isElementDisplayed(driver, Discover_text);
    }

    public boolean checkTheVodafoneLogo() {
        return ElementActions.isElementDisplayed(driver, VodafoneLogo);
    }
    public boolean checkSelectAccountAndSubscriptionComponent()
    {
        return ElementActions.isElementDisplayed(driver, Change_button);
    }
    public void pressSelectAccountAndSubscriptionComponent(){
        ElementActions.performTouchAction(driver).tap(Change_button);
    }


    public boolean checkNextBillTile() {
        return ElementActions.isElementDisplayed(driver, BillTile);
    }

    public boolean checkTrayMenuOptionsForBillPay(){
        return ElementActions.isElementDisplayed(driver,BillAndPayment);
    }

    //Actions methods
    public void pressBillsPaymentsTrayMenuOption(){

        ElementActions.performTouchAction(driver).tap(BillAndPayment);
    }

    public void opedAddOnsOverlay() {
        ElementActions.performTouchAction(driver).tap(BuyAndManageAddOns_button);
    }
    public void pressNextBillTile() {
        ElementActions.performTouchAction(driver).tap(ClickNextBillTitle);
    }

    public void pressSeeAllOffersLink(){
        ElementActions.performTouchAction(driver).tap(SeeAllOffers_button);
    }

}
