package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePlan {

    private WebDriver driver;
    private By PlanTitle ;
    private By ChangePlan_Button ;
    private By YourPlanClose_Button;
    private By ChangePlanTitle;
    private By ChangePlanClose_Button;
    private By ViewCurrentPlanDetails;
    private By SelectPlan_Button ;
    private By ViewDetails_Button ;
    private By SimOnlyTab;
    private By CloseCurrentPlanDetails;
    private By AvailablePlanDetails;
    private By PlanDetailsClose_Button;
    private By PlanDetailsTitle;


    public ChangePlan(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android"))
        {
         PlanTitle = By.xpath("//android.widget.TextView[@content-desc=\"id_dashboard_your_plan_details_title\"]");
         ChangePlan_Button = By.xpath("//android.widget.Button[@content-desc=\"id_dashboard_your_plan_details_button\"]/android.widget.TextView");
         YourPlanClose_Button = By.xpath("//android.widget.ImageView[@content-desc=\"id_dashboard_your_plan_details_close\"]");
         ChangePlanTitle = new MobileBy.ByAccessibilityId("id_header_title_Change_plan");
         ChangePlanClose_Button = new MobileBy.ByAccessibilityId("id_header_close_icon\"");
         ViewCurrentPlanDetails = new MobileBy.ByAccessibilityId("id_current_plan_view_details");
         SelectPlan_Button = new MobileBy.ByAccessibilityId("id_change_plan_Bill Pay_select_button");
         ViewDetails_Button = new MobileBy.ByAccessibilityId("id_change_plan_Bill Pay_view_button");
         SimOnlyTab = new MobileBy.ByAccessibilityId("SIM only");
         CloseCurrentPlanDetails = By.xpath("//android.widget.ImageView[@content-desc=\"id_change_plan_close\"]");
         AvailablePlanDetails = new MobileBy.ByAccessibilityId("");
         PlanDetailsClose_Button = new MobileBy.ByAccessibilityId("");
         PlanDetailsTitle = By.xpath("(//android.widget.TextView[@content-desc=\"id_change_plan_title\"])[1]");

        }else{
        }
    }

    public boolean checkYourPlanOverlay() {
        return ElementActions.isElementDisplayed(driver, PlanTitle);
    }

    public void pressYourPlanOverlayCloseButton() {
        ElementActions.performTouchAction(driver).tap(YourPlanClose_Button);
    }

    public void pressYourPlanOverlayChangePlanButton() {
        ElementActions.performTouchAction(driver).tap(ChangePlan_Button);
    }

    public boolean checkChangePlanPageHeader() {
        return ElementActions.isElementDisplayed(driver, ChangePlanTitle);
    }

    public void pressViewCurrentPlanDetails() {
        ElementActions.performTouchAction(driver).tap(ViewCurrentPlanDetails);
    }

    public void pressPlanDetailsOverlayCloseButton() {
        ElementActions.performTouchAction(driver).tap(CloseCurrentPlanDetails);
    }

    public void changeFromBillPayPlansToSimOnlyPlans() {
        ElementActions.performTouchAction(driver).tap(SimOnlyTab);
    }

    public void pressCloseButton() {
        ElementActions.performTouchAction(driver).tap(ChangePlanClose_Button);
    }

    public void pressSelectPlanButton() {
        ElementActions.performTouchAction(driver).tap(SelectPlan_Button);
    }

    public void checkAvailablePlanDetailsOverlay() {
        ElementActions.performTouchAction(driver).tap(AvailablePlanDetails);
    }
    public void pressPlanDetailsOverlayCloseButton_2(){
        ElementActions.performTouchAction(driver).tap(PlanDetailsClose_Button);
    }
    public void pressViewSelectedPlansDetails(){
        ElementActions.performTouchAction(driver).tap(ViewDetails_Button);
    }
    public boolean planDetailsTitle(){
        return ElementActions.isElementDisplayed(driver, PlanDetailsTitle);
    }
}


