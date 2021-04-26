package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopUp {
    private final WebDriver driver;
    private By TopUpOverlayClose_button;
    private By TopUpOverlay_button;
    private By TopUpHeader_text;
    private By TopUpHeaderClose_button;
    private By ChooseANumber_text;
    private By ChooseATopUpAmount_text;
    private By ChooseAPaymentMethod_text;
    private By ChangePaymentMethod_button;
    private By Cancel_button; //general locator in Top up page
    private By PaymentCard_text;
    private By AddPaymentCard_button;
    private By Chrome_driver;
    private By CardType_text;
    private By Next_button; //general locator in Top up page
    private By ConfirmYourTopUpDetails;
    private By MoreOptionsOverlay_button;
    private By MoreOptionsOverlayHeader_text;
    private By MoreOptionsOverlayBack_button;
    private By SetAnAutomaticTopUp_button;
    private By AutoTopUpPageHeader_text;
    private By AutoTopUpPageHeaderBack_button;
    private By AutoTopUpPageMyNumber_text;
    private By CheckYourTopUpHistory_button;
    private By SelectAccount_text;
    private By Filter_text;
    private By TopUpWithAVoucher_button;
    private By ChooseTheNumber_text;
    private By TopUpAnotherNumber_button;
    private By InsertPhoneNumber_editbox;
    private By InsertVoucherCode_editbox;
    private By Submit_button;

    //Getters
    public By getTopUpHeader_text() { return TopUpHeader_text; }

    public By getChooseANumber_text() {
        return ChooseANumber_text;
    }

    public By getChooseATopUpAmount_text() {
        return ChooseATopUpAmount_text;
    }

    public By getChooseAPaymentMethod_text() {
        return ChooseAPaymentMethod_text;
    }

    public By getPaymentCard_text() {
        return PaymentCard_text;
    }

    public By getCancel_button() {
        return Cancel_button;
    }

    public By getCardType_text() { return CardType_text; }

    public By getConfirmYourTopUpDetails() { return ConfirmYourTopUpDetails; }

    public By getMoreOptionOverlayHeader_text() {
        return MoreOptionsOverlayHeader_text;
    }

    public By getAutoTopUpPageHeader_text() { return AutoTopUpPageHeader_text; }

    public By getAutoTopUpPageMyNumber_text() { return AutoTopUpPageMyNumber_text; }
    public By getSelectAccount_text() { return SelectAccount_text; }
    public By getFilter_text() { return Filter_text; }
    public By getChooseTheNumber_text() { return ChooseTheNumber_text; }

    public TopUp(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            TopUpOverlayClose_button = new MobileBy.ByAccessibilityId("STundefinedCloseBtn");
            TopUpOverlay_button = By.xpath("(//android.widget.Button[@content-desc=\"id_top_up_button\"])[1]");
            TopUpHeader_text = new MobileBy.ByAccessibilityId("id_header_title_Top_up");
            ChooseANumber_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[1]");
            ChooseATopUpAmount_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView[2]/android.view.View[1]");
            ChooseAPaymentMethod_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView[3]/android.view.View[1]");
            ChangePaymentMethod_button = By.xpath("(//android.view.View[@content-desc=\"Change\"])[3]");
            PaymentCard_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]");
            Cancel_button = new MobileBy.ByAccessibilityId("Cancel");
            AddPaymentCard_button = new MobileBy.ByAccessibilityId("Add payment card");
            Chrome_driver = By.id("com.android.chrome:id/url_bar");
            CardType_text=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View");
            Next_button= new MobileBy.ByAccessibilityId("Next");
            ConfirmYourTopUpDetails=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]");
            TopUpHeaderClose_button=new MobileBy.ByAccessibilityId("id_header_close_icon");
            MoreOptionsOverlayHeader_text= new MobileBy.ByAccessibilityId("STundefinedMainTitle");
            MoreOptionsOverlay_button= By.xpath("(//android.widget.Button[@content-desc=\"id_top_up_button\"])[2]/android.widget.TextView");
            MoreOptionsOverlayBack_button= By.xpath("//android.widget.Button[@content-desc=\"id_top_up_more_options_back_button\"]/android.widget.TextView");
            SetAnAutomaticTopUp_button= new MobileBy.ByAccessibilityId("id_top_up_more_options_auto_top_up_clickable");
            AutoTopUpPageHeader_text= new MobileBy.ByAccessibilityId("id_header_title_Auto_top_up");
            AutoTopUpPageHeaderBack_button= new MobileBy.ByAccessibilityId("id_header_back_arrow");
            AutoTopUpPageMyNumber_text=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[1]");
            CheckYourTopUpHistory_button= new MobileBy.ByAccessibilityId("id_dashboard_tools_net_perform_label");
            SelectAccount_text= By.id("account-selector");
            Filter_text= By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.Spinner");
            TopUpWithAVoucher_button= By.xpath("(//android.view.ViewGroup[@content-desc=\"id_top_up_more_options_top_up_voucher_clickable\"])[2]");
            ChooseTheNumber_text=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]");
            TopUpAnotherNumber_button= By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[7]");
            InsertPhoneNumber_editbox=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[8]/android.view.View[3]/android.widget.EditText");
            InsertVoucherCode_editbox=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[9]/android.view.View/android.widget.EditText");
        }
    }

    public void pressTopUpOverlayCloseButton() {
        ElementActions.performTouchAction(driver).tap(TopUpOverlayClose_button);
    }

    public void pressTopUpOverlayTopUpButton() {
        ElementActions.performTouchAction(driver).tap(TopUpOverlay_button);
    }

    public void pressChangePaymentMethodButton() {
        ElementActions.performTouchAction(driver).tap(ChangePaymentMethod_button);
    }

    public void pressAddPaymentCardButton() {
        ElementActions.performTouchAction(driver).tap(AddPaymentCard_button);
    }

    public boolean isVestaWebpageOpened() {
        return ElementActions.isElementDisplayed(driver, Chrome_driver);
    }

    public void scrollDownToCancelBtn() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(Cancel_button, TouchActions.SwipeDirection.DOWN);
    }

    public void pressCancelBtn(){
        ElementActions.performTouchAction(driver).tap(Cancel_button);
    }

    public void pressCloseBtn(){
        ElementActions.performTouchAction(driver).tap(TopUpHeaderClose_button);
    }

    public void pressNextBtn(){
        ElementActions.performTouchAction(driver).tap(Next_button);
    }

    public void pressTopUpOverlayMoreOptionsButton(){
        ElementActions.performTouchAction(driver).tap(MoreOptionsOverlay_button);
    }

    public void pressMoreOptionsOverlayBackButton(){
        ElementActions.performTouchAction(driver).tap(MoreOptionsOverlayBack_button);
    }

    public void pressMoreOptionsOverlaySetAutoTopUpOption(){
        ElementActions.performTouchAction(driver).tap(SetAnAutomaticTopUp_button);
    }

    public void pressAutoTopUpBackButton(){
        ElementActions.performTouchAction(driver).tap(AutoTopUpPageHeaderBack_button);
    }

    public void pressMoreOptionsOverlayTopUpHistoryOption(){
        ElementActions.performTouchAction(driver).tap(CheckYourTopUpHistory_button);
    }

    public void pressMoreOptionsOverlayTopUpWithVoucherOption(){
        ElementActions.performTouchAction(driver).tap(TopUpWithAVoucher_button);
    }
    public void submitInvalidVoucher(String phoneNumber,String Voucher){
        //The following elements can't be located
        //ElementActions.performTouchAction(driver).tap(TopUpAnotherNumber_button);
        //ElementActions.type(driver,InsertPhoneNumber_editbox,phoneNumber);
        //ElementActions.type(driver,InsertVoucherCode_editbox,Voucher);
        //ElementActions.performTouchAction(driver).tap(Submit_button);
    }


}
