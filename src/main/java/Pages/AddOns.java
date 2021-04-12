package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOns {
    private final WebDriver driver;
    private final By AddOnsHeader_Text = new MobileBy.ByAccessibilityId("id_header_title_Buy_add_ons");
    private final By OneOff_tab = new MobileBy.ByAccessibilityId("One off (Selected)");
    private final By RecurringTab = new MobileBy.ByAccessibilityId("Recurring ");
    private final By NoActiveAddOnsOverlayTxt=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView");

    public By getOneOff_tab() {
        return OneOff_tab;
    }
    public By getRecurringTab() {
        return RecurringTab;
    }
    public final By getAddOnsHeader_Text() {
        return AddOnsHeader_Text;
    }
    public AddOns(WebDriver driver) {
        this.driver = driver;
    }

    public String getAddOnsHeaderText() {
        return ElementActions.getText(driver, AddOnsHeader_Text);
    }

    //Is it the way to handle false assertions?
    public boolean checkFirstTabNotExisted() {
        if (ElementActions.isElementDisplayed(driver, OneOff_tab)) {
            return false;
        } else return true;
    }

    public boolean checkSecondtTabNotExisted() {
        if (ElementActions.isElementDisplayed(driver, RecurringTab)) {
            return false;
        } else return true;
    }

    public Boolean checkAddOnsOverlay() {
       return ElementActions.isElementDisplayed(driver,NoActiveAddOnsOverlayTxt);
    }
}
