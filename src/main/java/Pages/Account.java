package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {

    private WebDriver driver;
    private By AccountTry_Button;
    private By AccountOverlay;


    public Account(WebDriver driver) {

        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android"))
        {
            AccountTry_Button = new MobileBy.ByAccessibilityId("Account");
            AccountOverlay = new MobileBy.ByAccessibilityId("STundefinedMainTitle");
        } else
            {
        }


    }

    public void pressAccountTrayMenuOption()
    {
        ElementActions.performTouchAction(driver).tap(AccountTry_Button);
    }
    public boolean checkAccountOverlay(){
        return ElementActions.isElementDisplayed(driver, AccountOverlay);
    }
}

