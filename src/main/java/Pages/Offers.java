package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Offers {

    private final MobileDriver driver;
    //Bill Pay
    private static By OffersHeader_text;
    private static By OffersHeaderClose_button;
    private static By FindOutMore_button;
    private static By SwipeLeft_button;
    private static By Chrome_driver;
    private static By FirstInternalOffer_image;
    private static By InternalOfferBack_button;

    //PAYG offers page
    private static By FirstOfferTitle_button;

    public By getOffersHeaderClose_button() {
        return OffersHeaderClose_button;
    }

    public By getSwipeLeft_button() {
        return SwipeLeft_button;
    }

    public By getChrome_driver() {
        return Chrome_driver;
    }

    public By getFirstInternalOffer_image() {
        return FirstInternalOffer_image;
    }

    public By getInternalOfferBack_button() {
        return InternalOfferBack_button;
    }

    private static By FirstOfferContinue_button;

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
        this.driver = (MobileDriver) driver;

        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            //Android Locators
            OffersHeader_text = new MobileBy.ByAccessibilityId("id_header_title_Offers");
            OffersHeaderClose_button = new MobileBy.ByAccessibilityId("id_header_close_icon");
            FindOutMore_button = MobileBy.xpath("//android.widget.Button[@content-desc=\"id_offers_button\"]/android.widget.TextView\n");
            SwipeLeft_button = MobileBy.AccessibilityId("id_offers_button_previous");
            Chrome_driver = By.id("com.android.chrome:id/url_bar");
            FirstInternalOffer_image = By.xpath("(//android.view.View[@content-desc=\"Offer_Selection\"])[1]");
            InternalOfferBack_button = new MobileBy.ByAccessibilityId("id_header_back_arrow");

            //PAYG offers page
            FirstOfferTitle_button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]");
            FirstOfferContinue_button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button");
        } else {
            //IOS Locators
            OffersHeader_text = MobileBy.AccessibilityId("id_header_title_Offers");
            OffersHeaderClose_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            FindOutMore_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Find out more\"])[2]");
            SwipeLeft_button = MobileBy.AccessibilityId("Go to previous offer");
            Chrome_driver = MobileBy.AccessibilityId("URL");
            FirstInternalOffer_image = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_offers_image_background\"])[4]");
            InternalOfferBack_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_back_arrow\"])[2]");

            //PAYG offers page
            FirstOfferTitle_button = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"Your Fantastic Offers Reward\"]");
            FirstOfferContinue_button = MobileBy.AccessibilityId("Continue");
        }
    }

    //Actions methods
    public void pressHeaderCloseButton() {
        ElementActions.performTouchAction(driver).tap(OffersHeaderClose_button);
    }

    public void swipeToAnotherOffer() {
        ElementActions.waitForElementToBePresent(driver, SwipeLeft_button, 5, true);
        //ElementActions.performTouchAction(driver).tap(SwipeLeft_button);
        ElementActions.click(driver, SwipeLeft_button);
    }

    public void pressOffersButton() {
        ElementActions.performTouchAction(driver).tap(FindOutMore_button);
    }

    public void goBackToAppFromExternalPage() {
        driver.activateApp("com.VodafoneIreland.MyVodafone");
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



