package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Offers {

    private final WebDriver driver;
    //Bill Pay
    private By OffersHeader_text;
    private By OffersHeaderClose_button;
    private By FindOutMore_button;
    private By SwipeLeft_button;
    private By Chrome_driver;
    private By FirstInternalOffer_image;
    private By InternalOfferBack_button;

    //PAYG offers page
    private By FirstOfferTitle_button;
    private By FirstOfferContinue_button;

    //Getters
    public By getOffersHeader_text() {
        return OffersHeader_text;
    }

    public By getFindOutMore_button() {
        return FindOutMore_button;
    }

    public By getFirstOfferContinue_button() {
        return FirstOfferContinue_button;
    }

    public By getFirstOfferTitle_button() {
        return FirstOfferTitle_button;
    }

    public Offers(WebDriver driver) {
        this.driver = driver;

        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            OffersHeader_text = new MobileBy.ByAccessibilityId("id_header_title_Offers");
            OffersHeaderClose_button = new MobileBy.ByAccessibilityId("id_header_close_icon");
            FindOutMore_button = By.xpath("//android.widget.Button[@content-desc=\"id_offers_button\"]/android.widget.TextView\n");
            SwipeLeft_button = new MobileBy.ByAccessibilityId("id_offers_button_previous");
            Chrome_driver = By.id("com.android.chrome:id/url_bar");
            FirstInternalOffer_image = By.xpath("(//android.view.View[@content-desc=\"Offer_Selection\"])[1]");
            InternalOfferBack_button = new MobileBy.ByAccessibilityId("id_header_back_arrow");

            //PAYG offers page
            FirstOfferTitle_button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]");
            FirstOfferContinue_button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button");
        } else {
            //IOS locators
        }
    }

    //Actions methods
    public void pressHeaderCloseButton() {
        ElementActions.performTouchAction(driver).tap(OffersHeaderClose_button);
    }

    public void swipeToAnotherOffer() {
        ElementActions.performTouchAction(driver).tap(SwipeLeft_button);
    }

    public void pressOffersButton() {
        ElementActions.performTouchAction(driver).tap(FindOutMore_button);
    }

    public void goBackToAppFromExternalPage() {
        driver.navigate().back();
    }

    public void goBackToAppFromInternalPage() {
        ElementActions.performTouchAction(driver).tap(InternalOfferBack_button);
    }

    //Check existence
    public boolean isExternalWebpageOpened() {
        return ElementActions.isElementDisplayed(driver, Chrome_driver);
    }

    public boolean isInternalWebpageOpened() {
        return ElementActions.isElementDisplayed(driver, FirstInternalOffer_image);
    }

    //Actions Method
    public void expandFirstOffer() {
        ElementActions.performTouchAction(driver).tap(FirstOfferTitle_button);
    }

    public void openExternalPage() {
        ElementActions.performTouchAction(driver).tap(FirstOfferContinue_button);
    }
}



