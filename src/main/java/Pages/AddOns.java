package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOns {
    private WebDriver driver;

    public By getAddOnsHeader_Text() {
        return AddOnsHeader_Text;
    }

    private By AddOnsHeader_Text = new MobileBy.ByAccessibilityId("id_header_title_Buy_add_ons");

    public By getOneOff_tab() {
        return OneOff_tab;
    }

    public By getRecurringTab() {
        return RecurringTab;
    }

    private By OneOff_tab = new MobileBy.ByAccessibilityId("One off (Selected)");
    private By RecurringTab = new MobileBy.ByAccessibilityId("Recurring ");

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

}
