package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOns {
    //Element locators
    private final WebDriver driver;
    private final By AddOnsHeader_Text = new MobileBy.ByAccessibilityId("id_header_title_Buy_add_ons");
    private final By OneOff_tab = new MobileBy.ByAccessibilityId("One off (Selected)");
    private final By Recurring_tab = new MobileBy.ByAccessibilityId("Recurring ");
    private final By NoActiveAddOnsOverlay_text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView");
    private final By AddOnsCloseOverlay_button = By.xpath("//android.view.ViewGroup[@content-desc=\"id_dashboard_manage_addons_sheet_close\"]");
    private final By AddOnsExpiresOverlay_text= By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]");

    //Getters of the elements
    public By getNoActiveAddOnsOverlayTxt() {
        return NoActiveAddOnsOverlay_text;
    }

    public By getOneOff_tab() {
        return OneOff_tab;
    }

    public By getRecurringTab() {
        return Recurring_tab;
    }

    public final By getAddOnsHeader_Text() {
        return AddOnsHeader_Text;
    }

    public AddOns(WebDriver driver) {
        this.driver = driver;
    }

    //Page methods
    public Boolean checkAddOnsOverlay() {
        return ElementActions.isElementDisplayed(driver, NoActiveAddOnsOverlay_text);
    }

    public void closeAddOnsOverlayBtn() {
        ElementActions.click(driver, AddOnsCloseOverlay_button);
    }

    public String getExpiresText(){
        return ElementActions.getText(driver,AddOnsExpiresOverlay_text);
    }
}
