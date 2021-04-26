package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {

    private WebDriver driver;
    private By AccountTry_Button;
    private By AccountOverlay;
    private By AccountSettingOption;
    private By AccountSettingsPageHeader;
    private By AccountSettingsSection;
    private By PersonalDetailsSection;
    private By AppSettingsSection;
    private By Close_Button;

    public Account(WebDriver driver) {

        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android"))
        {
            AccountTry_Button = new MobileBy.ByAccessibilityId("Account");
            AccountOverlay = new MobileBy.ByAccessibilityId("STundefinedMainTitle");
            AccountSettingOption = new MobileBy.ByAccessibilityId("");
            AccountSettingsPageHeader = new MobileBy.ByAccessibilityId("");
            AccountSettingsSection = new MobileBy.ByAccessibilityId("");
            PersonalDetailsSection = new MobileBy.ByAccessibilityId("");
            AppSettingsSection = new MobileBy.ByAccessibilityId("");
            Close_Button = new MobileBy.ByAccessibilityId("");

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
    public void pressAccountSettingOption()
    {
        ElementActions.performTouchAction(driver).tap(AccountSettingOption);
    }
    public boolean checkAccountSettingsPageHeader(){
        return ElementActions.isElementDisplayed(driver, AccountSettingsPageHeader);
    }

    public boolean checkAccountSettingsSection(){
        return ElementActions.isElementDisplayed(driver, AccountSettingsSection);
    }
    public boolean checkPersonalDetailsSection(){
        return ElementActions.isElementDisplayed(driver, PersonalDetailsSection);
    }
    public boolean checkAppSettingsSection(){
        return ElementActions.isElementDisplayed(driver, AppSettingsSection);
    }
    public void pressCloseButton(){
        ElementActions.performTouchAction(driver).tap(Close_Button);
    }
}

