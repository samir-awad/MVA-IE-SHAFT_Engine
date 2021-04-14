package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePlan {
    public ChangePlan(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private By PlanTitle = By.xpath("//android.widget.TextView[@content-desc=\"id_dashboard_your_plan_details_title\"]");
    private By ChangePlan_Button = By.xpath("//android.widget.Button[@content-desc=\"id_dashboard_your_plan_details_button\"]/android.widget.TextView");
    private By YourPlanClose_Button = By.xpath("//android.widget.ImageView[@content-desc=\"id_dashboard_your_plan_details_close\"]");

    ////
    private By ChangePlanTitle = new MobileBy.ByAccessibilityId("id_header_title_Change_plan");
    private By ChangePlanClose_Button = new MobileBy.ByAccessibilityId("id_header_close_icon\"");
    private By ViewCurrentPlanDetails = new MobileBy.ByAccessibilityId("id_current_plan_view_details");
    private By SelectPlan_Button = new MobileBy.ByAccessibilityId("id_change_plan_Bill Pay_select_button");
    private By ViewDetails_Button = new MobileBy.ByAccessibilityId("id_change_plan_Bill Pay_view_button");
    private By SimOnlyTab = new MobileBy.ByAccessibilityId("SIM only");
    private By CloseCurrentPlanDetails = By.xpath("//android.widget.ImageView[@content-desc=\"id_change_plan_close\"]");
    ////

    private By AvailablePlanDetails = new MobileBy.ByAccessibilityId("");
    private By PlanDetailsClose_Button = new MobileBy.ByAccessibilityId("");
    private By PlanDetailsTitle = By.xpath("(//android.widget.TextView[@content-desc=\"id_change_plan_title\"])[1]");


    public Boolean yourPlanTitle() {
        return ElementActions.isElementDisplayed(driver, PlanTitle);
    }

    public void pressYourPlanOverlayCloseButton() {
        ElementActions.performTouchAction(driver).tap(YourPlanClose_Button);
    }

    public void pressSelectChangePlanButton() {
        ElementActions.performTouchAction(driver).tap(ChangePlan_Button);
    }

    public Boolean ChangePlanTitle() {
        return ElementActions.isElementDisplayed(driver, ChangePlanTitle);
    }

    public void checkCurrentPlanDetails() {
        ElementActions.performTouchAction(driver).tap(ViewCurrentPlanDetails);
    }

    public void pressPlanDetailsOverlayCloseButton() {
        ElementActions.performTouchAction(driver).tap(CloseCurrentPlanDetails);
    }

    public void changeFromBillPayPlansToSimOnlyPlans() {
        ElementActions.performTouchAction(driver).tap(SimOnlyTab);
    }

    public void changePlanCloseBTN() {
        ElementActions.performTouchAction(driver).tap(ChangePlanClose_Button);
    }

    public void pressSelectPlanButton() {
        ElementActions.performTouchAction(driver).tap(SelectPlan_Button);
    }

    public void checkAvailablePlanDetailsOverlay() {
        ElementActions.performTouchAction(driver).tap(AvailablePlanDetails);
    }
    public void pressPlanDetailsOverlayCloseBtn(){
        ElementActions.performTouchAction(driver).tap(PlanDetailsClose_Button);
    }
    public void pressViewDetailsButton(){
        ElementActions.performTouchAction(driver).tap(ViewDetails_Button);
    }
    public Boolean planDetailsTitle(){
        return ElementActions.isElementDisplayed(driver, PlanDetailsTitle);
    }
}


