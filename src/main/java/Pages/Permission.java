package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Permission {

    private WebDriver driver;
    private By AppPermissionsPageHeader;
    private By AppPermissionsPageContent;
    private By AccountHeaderBackChevron;

    public Permission(WebDriver driver) {

        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            AppPermissionsPageHeader = new MobileBy.ByAccessibilityId("id_header_title_Permissions");
            AppPermissionsPageContent = new MobileBy.ByAccessibilityId("id_settings_permission_title_Location");
            AccountHeaderBackChevron = new MobileBy.ByAccessibilityId("id_header_back_arrow");
        } else {
            AppPermissionsPageHeader = MobileBy.AccessibilityId("id_header_title_Permissions");
            AppPermissionsPageContent = MobileBy.AccessibilityId("id_settings_permission_title_Location");
            AccountHeaderBackChevron = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_back_arrow\"])[2]");
        }
    }

    public By getCheckAppPermissionsPageHeader() {
        return AppPermissionsPageHeader;
    }

    public By getCheckAppPermissionsPageContent() {
        return AppPermissionsPageContent;
    }

    public void pressAccountHeaderBackChevron() {
        ElementActions.performTouchAction(driver).tap(AccountHeaderBackChevron);
    }

}

