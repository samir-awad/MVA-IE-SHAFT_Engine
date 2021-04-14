package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Offers {

    private final WebDriver driver;
    private By OffersHeader_text;
    private By OffersHeaderClose_button;
    private By FindOutMore_button;

    public By getOffersHeader_text() {
        return OffersHeader_text;
    }

    public By getFindOutMore_button() {
        return FindOutMore_button;
    }

    public Offers(WebDriver driver) {
        this.driver = driver;

        if (System.getProperty("targetOperatingSystem").equals("Android")) {
        OffersHeader_text= new MobileBy.ByAccessibilityId("id_header_title_Offers");
        OffersHeaderClose_button=new MobileBy.ByAccessibilityId("id_header_close_icon");
        FindOutMore_button= new MobileBy.ByAccessibilityId("id_offers_button");

        }
        else {
            //IOS locators
        }
    }

    //Actions methods
    public void pressHeaderCloseButton(){
        ElementActions.performTouchAction(driver).tap(OffersHeaderClose_button);
    }
}
