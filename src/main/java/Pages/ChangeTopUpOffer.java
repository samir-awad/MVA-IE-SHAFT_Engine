package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeTopUpOffer {
    private final WebDriver driver;
    private static By ChangeTopUpOfferHeader_text;
    private static By ChangeTopUpOfferClose_button;
    private static By ChangeToUpOfferDashboard_button;
    private static By changeTopUpOfferDetails_title;
    private static By changeTopUpOfferDetails_OfferName;
    private static By changeTopUpOfferDetailsOffer_MuchMore;
    private static By currentTopUpOffer_title;
    private static By currentTopUpOffer_name;
    private static By currentTopUpOffer_value;
    private static By ViewDetailsCurrentTopUpOffer_button;
    private static By YourTopUpOffer_title;
    private static By ChangeTopUpOfferOverlay_CloseButton;
    private static By ChangeTopUpOffer_button;
    private static By NoTopUpOffer_text;
    private static By FirstOfferComponent;
    private static By SecondOfferComponent;
    private static By ViewDetailsNewTopUpOffer_button;
    private static By OptIn_button;


    public ChangeTopUpOffer(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            ChangeToUpOfferDashboard_button = MobileBy.AccessibilityId("id_dashboard_essentials_change_topup_offer_clickable");
            ChangeTopUpOfferHeader_text = MobileBy.AccessibilityId("id_header_title_Change_top_up_offer");
            ChangeTopUpOfferClose_button = MobileBy.AccessibilityId("id_header_close_icon");
            NoTopUpOffer_text = MobileBy.AccessibilityId("id_current_top_up_offer_title_no_offer");
            FirstOfferComponent = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"You are not opted in to a top up offer.\"])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]");
            SecondOfferComponent = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"You are not opted in to a top up offer.\"])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]");
            changeTopUpOfferDetails_title = MobileBy.AccessibilityId("id_dashboard_essentials_change_topup_offer_details_title");
            changeTopUpOfferDetails_OfferName = MobileBy.AccessibilityId("id_dashboard_essentials_change_topup_offer_details_offer_name");
            changeTopUpOfferDetailsOffer_MuchMore = MobileBy.AccessibilityId("id_dashboard_essentials_change_topup_offer_details_offer_much_more");
            ChangeTopUpOffer_button = MobileBy.AccessibilityId("Change top up offer");
            currentTopUpOffer_title = MobileBy.AccessibilityId("id_current_top_up_offer_title");
            currentTopUpOffer_name = MobileBy.AccessibilityId("id_current_top_up_offer_name");
            currentTopUpOffer_value = MobileBy.AccessibilityId("id_current_top_up_offer_value");
            ViewDetailsCurrentTopUpOffer_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"View details\"])[1]");
            ViewDetailsNewTopUpOffer_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"View details\"])[2]");
            YourTopUpOffer_title = MobileBy.AccessibilityId("Your top up offer id_change_top_up_offer_close");
            ChangeTopUpOfferOverlay_CloseButton = MobileBy.AccessibilityId("id_change_top_up_offer_close");
            OptIn_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Opt in\"])[1]");
        } else {
            ChangeToUpOfferDashboard_button = MobileBy.AccessibilityId("id_dashboard_essentials_change_topup_offer_clickable");
            ChangeTopUpOfferHeader_text = MobileBy.AccessibilityId("id_header_title_Change_top_up_offer");
            ChangeTopUpOfferClose_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            NoTopUpOffer_text = MobileBy.AccessibilityId("id_current_top_up_offer_title_no_offer");
            FirstOfferComponent = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Opt in\"])[1]");
            SecondOfferComponent = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"View details\"])[1]");
            changeTopUpOfferDetails_title = MobileBy.AccessibilityId("id_dashboard_essentials_change_topup_offer_details_title");
            changeTopUpOfferDetails_OfferName = MobileBy.AccessibilityId("id_dashboard_essentials_change_topup_offer_details_offer_name");
            changeTopUpOfferDetailsOffer_MuchMore = MobileBy.AccessibilityId("id_dashboard_essentials_change_topup_offer_details_offer_much_more");
            ChangeTopUpOffer_button = MobileBy.AccessibilityId("Change top up offer");
            currentTopUpOffer_title = MobileBy.AccessibilityId("id_current_top_up_offer_title");
            currentTopUpOffer_name = MobileBy.AccessibilityId("id_current_top_up_offer_name");
            currentTopUpOffer_value = MobileBy.AccessibilityId("id_current_top_up_offer_value");
            ViewDetailsCurrentTopUpOffer_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"View details\"])[1]");
            ViewDetailsNewTopUpOffer_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"View details\"])[2]");
            YourTopUpOffer_title = MobileBy.AccessibilityId("id_current_top_up_offer_title");
            ChangeTopUpOfferOverlay_CloseButton = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            OptIn_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Opt in\"])[1]");

        }
    }

    public void pressCloseBtn() {
        ElementActions.performTouchAction(driver).tap(ChangeTopUpOfferClose_button);
    }

    public By getChangeTopUpOfferDetails_title() {
        return changeTopUpOfferDetails_title;
    }

    public By getChangeTopUpOfferDetails_OfferName() {
        return changeTopUpOfferDetails_OfferName;
    }

    public By getChangeTopUpOfferDetailsOffer_MuchMore() {
        return changeTopUpOfferDetailsOffer_MuchMore;
    }

    public By getCurrentTopUpOffer_title() {
        return currentTopUpOffer_title;
    }

    public By getCurrentTopUpOffer_name() {
        return currentTopUpOffer_name;
    }

    public By getCurrentTopUpOffer_value() {
        return currentTopUpOffer_value;
    }

    public By getViewDetailsCurrentTopUpOffer_button() {
        return ViewDetailsCurrentTopUpOffer_button;
    }

    public By getYourTopUpOffer_title() {
        return YourTopUpOffer_title;
    }

    public By getChangeTopUpOfferOverlay_CloseButton() {
        return ChangeTopUpOfferOverlay_CloseButton;
    }

    public By getViewDetailsNewTopUpOffer_button() {
        return ViewDetailsNewTopUpOffer_button;
    }

    public By getOptIn_button() {
        return OptIn_button;
    }


    public By getChangeTopUpOfferClose_button() {
        return ChangeTopUpOfferClose_button;
    }

    public By getChangeToUpOfferDashboard_button() {
        return ChangeToUpOfferDashboard_button;
    }

    public By getChangeTopUpOffer_button() {
        return ChangeTopUpOffer_button;
    }

    public By getNoTopUpOffer_text() {
        return NoTopUpOffer_text;
    }

    public By getFirstOfferComponent() {
        return FirstOfferComponent;
    }

    public By getSecondOfferComponent() {
        return SecondOfferComponent;
    }

    public By getChangeTopUpOfferHeader_text() {
        return ChangeTopUpOfferHeader_text;
    }

}
