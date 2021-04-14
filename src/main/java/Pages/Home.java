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

    public boolean checkDiscoverySection() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(Discover_text, TouchActions.SwipeDirection.DOWN, 1);
        return ElementActions.isElementDisplayed(driver, Discover_text);
    }

    public boolean checkTheVodafoneLogo() {
        return ElementActions.isElementDisplayed(driver, VodafoneLogo);
    }

    public boolean checkTheNextBillTile() {
        return ElementActions.isElementDisplayed(driver, BillTile);
    }

    public Boolean checkTrayMenuOptionsForBillPay(){
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
