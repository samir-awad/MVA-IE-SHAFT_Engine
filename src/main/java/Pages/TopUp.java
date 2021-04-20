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

    public By getCardType_text() { return CardType_text; }

    public By getConfirmYourTopUpDetails() { return ConfirmYourTopUpDetails; }

    public By getMoreOptionOverlayHeader_text() {
        return MoreOptionsOverlayHeader_text;
    }

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


}
