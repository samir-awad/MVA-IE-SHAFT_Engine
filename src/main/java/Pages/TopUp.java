package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopUp {
    private final MobileDriver driver;
    private static By TopUpOverlayClose_button;
    private static By TopUpOverlay_button;
    private static By TopUpHeader_text;
    private static By TopUpHeaderClose_button;
    private static By ChooseANumber_text;
    private static By ChooseATopUpAmount_text;
    private static By ChooseAPaymentMethod_text;
    private static By ChangePaymentMethod_button;
    private static By Cancel_button; //general locator in Top up page
    private static By PaymentCard_text;
    private static By AddPaymentCard_button;
    private static By Chrome_driver;
    private static By CardType_text;
    private static By Next_button; //general locator in Top up page
    private static By ConfirmYourTopUpDetails;
    private static By MoreOptionsOverlay_button;
    private static By TopUpOverlayHeader_text;
    private static By MoreOptionsOverlayBack_button;
    private static By SetAnAutomaticTopUp_button;
    private static By AutoTopUpPageHeader_text;
    private static By AutoTopUpPageHeaderBack_button;
    private static By AutoTopUpPageMyNumber_text;
    private static By CheckYourTopUpHistory_button;
    private static By SelectAccount_text;
    private static By Filter_text;
    private static By TopUpWithAVoucher_button;
    private static By ChooseTheNumber_text;
    private static By TopUpAnotherNumber_button;
    private static By InsertPhoneNumber_editbox;
    private static By InsertVoucherCode_editbox;
    private static By Submit_button;
    private static By VoucherTopUpHeader_text;
    private static By EditView;

    //Getters
    public By getTopUpHeader_text() {
        return TopUpHeader_text;
    }

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

    public By getCardType_text() {
        return CardType_text;
    }

    public By getConfirmYourTopUpDetails() {
        return ConfirmYourTopUpDetails;
    }

    public By getTopUpOverlayHeader_text() {
        return TopUpOverlayHeader_text;
    }

    public By getAutoTopUpPageHeader_text() {
        return AutoTopUpPageHeader_text;
    }

    public By getAutoTopUpPageMyNumber_text() {
        return AutoTopUpPageMyNumber_text;
    }

    public By getSelectAccount_text() {
        return SelectAccount_text;
    }

    public By getFilter_text() {
        return Filter_text;
    }

    public By getChooseTheNumber_text() {
        return ChooseTheNumber_text;
    }

    public By getVoucherTopUpHeader_text() {
        return VoucherTopUpHeader_text;
    }

    public By getTopUpOverlayClose_button() {
        return TopUpOverlayClose_button;
    }

    public By getTopUpOverlay_button() {
        return TopUpOverlay_button;
    }

    public By getTopUpHeaderClose_button() {
        return TopUpHeaderClose_button;
    }

    public By getChangePaymentMethod_button() {
        return ChangePaymentMethod_button;
    }

    public By getAddPaymentCard_button() {
        return AddPaymentCard_button;
    }

    public By getChrome_driver() {
        return Chrome_driver;
    }

    public By getNext_button() {
        return Next_button;
    }

    public By getMoreOptionsOverlay_button() {
        return MoreOptionsOverlay_button;
    }

    public By getMoreOptionsOverlayBack_button() {
        return MoreOptionsOverlayBack_button;
    }

    public By getSetAnAutomaticTopUp_button() {
        return SetAnAutomaticTopUp_button;
    }

    public By getAutoTopUpPageHeaderBack_button() {
        return AutoTopUpPageHeaderBack_button;
    }

    public By getCheckYourTopUpHistory_button() {
        return CheckYourTopUpHistory_button;
    }

    public By getTopUpWithAVoucher_button() {
        return TopUpWithAVoucher_button;
    }

    public By getTopUpAnotherNumber_button() {
        return TopUpAnotherNumber_button;
    }

    public By getInsertPhoneNumber_editbox() {
        return InsertPhoneNumber_editbox;
    }

    public By getInsertVoucherCode_editbox() {
        return InsertVoucherCode_editbox;
    }

    public By getSubmit_button() {
        return Submit_button;
    }


    public TopUp(WebDriver driver) {
        this.driver = (MobileDriver) driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {

            TopUpOverlayClose_button = new MobileBy.ByAccessibilityId("STundefinedCloseBtn");
            TopUpOverlay_button = MobileBy.xpath("(//android.widget.Button[@content-desc=\"id_top_up_button\"])[1]");
            TopUpHeader_text = new MobileBy.ByAccessibilityId("id_header_title_Top_up");
            ChooseANumber_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[1]");
            ChooseATopUpAmount_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView[2]/android.view.View[1]");
            ChooseAPaymentMethod_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView[3]/android.view.View[1]");
            ChangePaymentMethod_button = By.xpath("(//android.view.View[@content-desc=\"Change\"])[3]");
            PaymentCard_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]");
            Cancel_button = MobileBy.AccessibilityId("Cancel");
            AddPaymentCard_button = new MobileBy.ByAccessibilityId("Add payment card");
            Chrome_driver = By.id("com.android.chrome:id/url_bar");
            CardType_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View");
            Next_button = new MobileBy.ByAccessibilityId("Next");
            ConfirmYourTopUpDetails = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]");
            TopUpHeaderClose_button = new MobileBy.ByAccessibilityId("id_header_close_icon");
            TopUpOverlayHeader_text = new MobileBy.ByAccessibilityId("STundefinedMainTitle");
            VoucherTopUpHeader_text = MobileBy.AccessibilityId("STundefinedMainTitle");
            MoreOptionsOverlay_button = By.xpath("(//android.widget.Button[@content-desc=\"id_top_up_button\"])[2]/android.widget.TextView");
            MoreOptionsOverlayBack_button = By.xpath("//android.widget.Button[@content-desc=\"id_top_up_more_options_back_button\"]/android.widget.TextView");
            SetAnAutomaticTopUp_button = new MobileBy.ByAccessibilityId("id_top_up_more_options_auto_top_up_clickable");
            AutoTopUpPageHeader_text = new MobileBy.ByAccessibilityId("id_header_title_Auto_top_up");
            AutoTopUpPageHeaderBack_button = new MobileBy.ByAccessibilityId("id_header_back_arrow");
            AutoTopUpPageMyNumber_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[1]");
            CheckYourTopUpHistory_button = new MobileBy.ByAccessibilityId("id_dashboard_tools_net_perform_label");
            SelectAccount_text = By.id("account-selector");
            Filter_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.Spinner");
            TopUpWithAVoucher_button = By.xpath("(//android.view.ViewGroup[@content-desc=\"id_top_up_more_options_top_up_voucher_clickable\"])[2]");
            ChooseTheNumber_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]");
            TopUpAnotherNumber_button = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]");
            InsertPhoneNumber_editbox = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[8]/android.view.View[3]/android.widget.EditText");
            InsertVoucherCode_editbox = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[9]/android.view.View/android.widget.EditText");
            EditView = MobileBy.AccessibilityId("AddEditPaymentDevice");

        } else {

            TopUpOverlayClose_button = new MobileBy.ByAccessibilityId("STundefinedCloseBtn");
            TopUpOverlay_button = new MobileBy.ByAccessibilityId("Top up");
            TopUpHeader_text = By.xpath("//XCUIElementTypeStaticText[@name=\"Top up\"]");
            ChooseANumber_text = By.xpath("//XCUIElementTypeStaticText[@name=\"Choose a number\"]");
            ChooseATopUpAmount_text = By.xpath("//XCUIElementTypeStaticText[@name=\"Choose a top up amount\"]");
            ChooseAPaymentMethod_text = By.xpath("//XCUIElementTypeStaticText[@name=\"Choose a payment method\"]");
            ChangePaymentMethod_button = By.xpath("(//XCUIElementTypeStaticText[@name=\"Change\"])[3]");
            PaymentCard_text = By.xpath("//XCUIElementTypeStaticText[@name=\"Payment card\"]");
            Cancel_button = By.xpath("//XCUIElementTypeStaticText[@name=\"Cancel\"]");
            AddPaymentCard_button = By.xpath("//XCUIElementTypeOther[@name=\"Add payment card\"]");
            Chrome_driver = new MobileBy.ByAccessibilityId("TopBrowserBar");
            CardType_text = By.xpath("//XCUIElementTypeStaticText[@name=\"Card Type\"]");
            Next_button = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"Next\"]");
            ConfirmYourTopUpDetails = MobileBy.AccessibilityId("Confirm your top up details");
            TopUpHeaderClose_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            TopUpOverlayHeader_text = new MobileBy.ByAccessibilityId("STundefinedMainTitle");
            VoucherTopUpHeader_text = MobileBy.AccessibilityId("STundefinedMainTitle");
            //VoucherTopUpHeader_text = MobileBy.xpath("//android.widget.TextView[@content-desc=\"id_header_title_Top_up\"]");
            MoreOptionsOverlay_button = MobileBy.AccessibilityId("More options");
            MoreOptionsOverlayBack_button = MobileBy.AccessibilityId("Back");
            SetAnAutomaticTopUp_button = new MobileBy.ByAccessibilityId("id_top_up_more_options_auto_top_up_clickable");
            AutoTopUpPageHeader_text = MobileBy.AccessibilityId("id_header_title_Auto_top_up");
            AutoTopUpPageHeaderBack_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_back_arrow\"])[2]");
            AutoTopUpPageMyNumber_text = By.xpath("(//XCUIElementTypeStaticText[@name=\"My number\"])[1]");
            CheckYourTopUpHistory_button = new MobileBy.ByAccessibilityId("(//XCUIElementTypeOther[@name=\"id_top_up_more_options_top_up_voucher_clickable\"])[1]");
            SelectAccount_text = By.id("account-selector");
            Filter_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.Spinner");
            TopUpWithAVoucher_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_top_up_more_options_top_up_voucher_clickable\"])[2]");
            ChooseTheNumber_text = MobileBy.AccessibilityId("Choose the number you want to Top up");
            TopUpAnotherNumber_button = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Top Up | Vodafone\"]/XCUIElementTypeOther[9]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]");
            InsertPhoneNumber_editbox = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Top Up | Vodafone\"]/XCUIElementTypeOther[10]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
            InsertVoucherCode_editbox = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Top Up | Vodafone\"]/XCUIElementTypeOther[11]/XCUIElementTypeOther/XCUIElementTypeTextField");
            Submit_button = MobileBy.AccessibilityId("Submit");

        }
    }

    public void pressTopUpOverlayCloseButton() {
        driver.findElement(TopUpOverlayClose_button).click();
//        ElementActions.performTouchAction(driver).tap(TopUpOverlayClose_button);
    }

    public void pressTopUpOverlayTopUpButton() {
//        driver.findElement(TopUpOverlay_button).click();
        ElementActions.performTouchAction(driver).tap(TopUpOverlay_button);
    }

    public void pressChangePaymentMethodButton() {
        driver.findElement(ChangePaymentMethod_button).click();
//        ElementActions.performTouchAction(driver).tap(ChangePaymentMethod_button);
    }

    public void pressAddPaymentCardButton() {
        driver.findElement(AddPaymentCard_button).click();
//        ElementActions.performTouchAction(driver).tap(AddPaymentCard_button);
    }

    public boolean isVestaWebpageOpened() {
        return ElementActions.isElementDisplayed(driver, Chrome_driver);
    }

    public void scrollDownToCancelBtn() {
//        ElementActions.waitForElementToBePresent(driver,EditView,10,true);
        ElementActions.performTouchAction(driver).swipeElementIntoView(Cancel_button, TouchActions.SwipeDirection.UP);
    }

    public void pressCancelBtn() {
//        ElementActions.performTouchAction(driver).swipeElementIntoView(Cancel_button, TouchActions.SwipeDirection.UP);
        driver.findElement(Cancel_button).click();
//        ElementActions.performTouchAction(driver).tap(Cancel_button);
    }

    public void pressCloseBtn() {
        driver.findElement(TopUpHeaderClose_button).click();
//        ElementActions.performTouchAction(driver).tap(TopUpHeaderClose_button);
    }

    public void pressNextBtn() {
//        driver.findElement(Next_button).click();
        ElementActions.performTouchAction(driver).tap(Next_button);
    }

    public void pressTopUpOverlayMoreOptionsButton() {
        ElementActions.performTouchAction(driver).tap(MoreOptionsOverlay_button);
    }

    public void pressMoreOptionsOverlayBackButton() {
        ElementActions.performTouchAction(driver).tap(MoreOptionsOverlayBack_button);
    }

    public void pressMoreOptionsOverlaySetAutoTopUpOption() {
        ElementActions.performTouchAction(driver).tap(SetAnAutomaticTopUp_button);
    }

    public void pressAutoTopUpBackButton() {
        ElementActions.performTouchAction(driver).tap(AutoTopUpPageHeaderBack_button);
    }

    public void pressMoreOptionsOverlayTopUpHistoryOption() {
        ElementActions.performTouchAction(driver).tap(CheckYourTopUpHistory_button);
    }

    public void pressMoreOptionsOverlayTopUpWithVoucherOption() {
        ElementActions.performTouchAction(driver).tap(TopUpWithAVoucher_button);
    }

    public void submitInvalidVoucher(String phoneNumber, String Voucher) {

//        //The following elements can't be located
//        ElementActions.performTouchAction(driver).tap(TopUpAnotherNumber_button);
//        //ElementActions.performTouchAction(driver).tap(InsertVoucherCode_editbox);
//        driver.findElement(InsertPhoneNumber_editbox).clear();
//        //ElementActions.type(driver,InsertPhoneNumber_editbox,phoneNumber);
//        driver.findElement(InsertPhoneNumber_editbox).sendKeys(phoneNumber);
//        driver.findElement(new MobileBy.ByAccessibilityId("Done")).click();
//        driver.findElement(InsertVoucherCode_editbox).clear();
//        //ElementActions.type(driver,InsertVoucherCode_editbox,Voucher);
//        driver.findElement(InsertVoucherCode_editbox).sendKeys(Voucher);
//        driver.findElement(new MobileBy.ByAccessibilityId("Done")).click();
//        ElementActions.performTouchAction(driver).tap(Submit_button);

        //ElementActions.isElementClickable(driver,getTopUpAnotherNumber_button());
        ElementActions.performTouchAction(driver).tap(getTopUpAnotherNumber_button());
        driver.findElement(getInsertPhoneNumber_editbox()).clear();
        driver.findElement(getInsertPhoneNumber_editbox()).sendKeys(phoneNumber);
        driver.hideKeyboard();
        //ElementActions.performTouchAction(driver).hideNativeKeyboard();
        driver.findElement(getInsertVoucherCode_editbox()).clear();
        driver.findElement(getInsertVoucherCode_editbox()).sendKeys(Voucher);
        driver.hideKeyboard();
        //ElementActions.performTouchAction(driver).hideNativeKeyboard();
        ElementActions.performTouchAction(driver).tap(getSubmit_button());
    }


}
