package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private final WebDriver driver;
    private By termsAndConditions_Header;
    private By termsAndConditions_Txt;
    private By AcceptTerms_button;
    private By Continue_button;
    private By Vodafone_Logo;
    private By Reg_Login_Txt;
    private By Reg_Login_Button;
    private By Reg_Register_Txt;
    private By Reg_Register_button;
    private By Reg_OurPrivacy_Link;
    private By Registration_Title;
    private By Registration_SendToken;
    private By Registration_OurPrivacy;
    private By Registration_ResetYourPassword_RedirectText;
    private By Registration_ResetYourPassword_RedirectLink;
    private By Registration_UserName;
    private By RestPassword_Title;
    private By RestPassword_SendToken;
    private By RestPassword_OurPrivacy;
    private By RestPassword_RegisterHere_RedirectText;
    private By RestPassword_RegisterHere_RedirectLink;
    private By RestPassword_UserName;
    private By Back_Arrow;
    private By PhoneOrEmail_TxtField;
    private By Password_TxtField;
    private By KeepMe_Checkbox;
    private By Login_button;
    private By LetsGo_Button;
    private By PrivacyContinue_button;
    private By PersonalPreferencesContinue_button;
    private By Yes_Button;
    private By No_Button;
    private By OnboardingPersonalDetailsContinue_button;
    private By PermissionsContinue_button;
    private By GoToTheApp_button;
    private By Tutorials_button;
    private By GoToMyVodafone_button;

    public Login(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")){

            termsAndConditions_Header = new MobileBy.ByAccessibilityId("id_accordion_description_title");
            termsAndConditions_Txt = By.xpath("(//android.widget.TextView[@content-desc=\"id_tc_content_item\"])[2]");
            AcceptTerms_button = new MobileBy.ByAccessibilityId("id_TC_switch_accept_terms");
            Continue_button= new MobileBy.ByAccessibilityId("id_tc_agree_button");
            Vodafone_Logo = new MobileBy.ByAccessibilityId("id_login_and_register_logo");
            Reg_Login_Txt = new MobileBy.ByAccessibilityId("id_login_and_register_login_text");
            Reg_Login_Button = new MobileBy.ByAccessibilityId("signup_signin_login_btn");
            Reg_Register_Txt = new MobileBy.ByAccessibilityId("id_login_and_register_register_text");
            Reg_Register_button = new MobileBy.ByAccessibilityId("signup_signin_signup_btn");
            Reg_OurPrivacy_Link = new MobileBy.ByAccessibilityId("tv_our_privacy");
            Registration_Title = new MobileBy.ByAccessibilityId("signup_signin_signup_btn");
            Registration_UserName = new MobileBy.ByAccessibilityId("id_registration_edittext_username");
            Registration_SendToken = new MobileBy.ByAccessibilityId("id_registration_button_sendtoken");
            Registration_OurPrivacy = new MobileBy.ByAccessibilityId("id_registration_textview_ourprivacy");
            Registration_ResetYourPassword_RedirectText = new MobileBy.ByAccessibilityId("id_registration_textview_beside_redirect");
            Registration_ResetYourPassword_RedirectLink = new MobileBy.ByAccessibilityId("id_registration_textview_redirect");
            RestPassword_Title = new MobileBy.ByAccessibilityId("id_forgotpassword_title");
            RestPassword_SendToken = new MobileBy.ByAccessibilityId("");
            RestPassword_OurPrivacy = new MobileBy.ByAccessibilityId("");
            RestPassword_RegisterHere_RedirectText = new MobileBy.ByAccessibilityId("");
            RestPassword_RegisterHere_RedirectLink = new MobileBy.ByAccessibilityId("");
            RestPassword_UserName = new MobileBy.ByAccessibilityId("");
            Back_Arrow = new MobileBy.ByAccessibilityId("id_header_back_arrow");
            PhoneOrEmail_TxtField = new MobileBy.ByAccessibilityId("id_login_edittext_username");
            Password_TxtField = new MobileBy.ByAccessibilityId("id_login_edittext_password");
            KeepMe_Checkbox = new MobileBy.ByAccessibilityId("");
            Login_button = new MobileBy.ByAccessibilityId("id_login_button_login");
            LetsGo_Button = By.xpath("//android.widget.TextView[@content-desc=\"OBstartButton\"]");
            PrivacyContinue_button = new MobileBy.ByAccessibilityId("id_privacy_policy_continue_button");
            PersonalPreferencesContinue_button = new MobileBy.ByAccessibilityId("id_onboarding_personal_preferences_continue_button");
            Yes_Button = By.xpath("//android.widget.Button[@content-desc=\"Yes\"]/android.widget.TextView");
            OnboardingPersonalDetailsContinue_button = new MobileBy.ByAccessibilityId("id_onboarding_personal_details_continue_button");
            PermissionsContinue_button = new MobileBy.ByAccessibilityId("id_onboarding_permissions_continue_button");
            GoToTheApp_button = new MobileBy.ByAccessibilityId("OBgetStartedButton");
            Tutorials_button = new MobileBy.ByAccessibilityId("id_tutorials_tour_button");
            GoToMyVodafone_button = new MobileBy.ByAccessibilityId("id_tutorials_dismiss_button");

        }else{

            termsAndConditions_Header =new MobileBy.ByAccessibilityId("id_accordion_description_title");
            termsAndConditions_Txt = By.xpath("(//XCUIElementTypeStaticText[@name=\"id_tc_content_item\"])[2]");
            AcceptTerms_button = new MobileBy.ByAccessibilityId("id_TC_switch_accept_terms");
            Continue_button= new MobileBy.ByAccessibilityId("Continue");
            Vodafone_Logo=new MobileBy.ByAccessibilityId("id_login_and_register_logo");
            Reg_Login_Button=new MobileBy.ByAccessibilityId("Login");
            Login_button=new MobileBy.ByAccessibilityId("Login");
            Yes_Button = By.xpath("//XCUIElementTypeOther[@name=\"Yes\"]");
            GoToTheApp_button = new MobileBy.ByAccessibilityId("Go to the app");
            Tutorials_button = new MobileBy.ByAccessibilityId("Take a quick tour");
            GoToMyVodafone_button = new MobileBy.ByAccessibilityId("OBgetStartedButton");
        }
    }

    public Login acceptTermsAndConditions() {
        ElementActions.performTouchAction(driver).tap(AcceptTerms_button);
        ElementActions.performTouchAction(driver).tap(Continue_button);
        return this;
    }

    public Login login() {
        ElementActions.performTouchAction(driver).tap(Reg_Login_Button);
        ElementActions.type(driver, PhoneOrEmail_TxtField, "0876352242");
        ElementActions.type(driver, Password_TxtField, "Mountainview01!");
        ElementActions.performTouchAction(driver).tap(Login_button);
        return this;
    }

    public void acceptPermissions() {
        ElementActions.performTouchAction(driver).tap(LetsGo_Button);
        ElementActions.performTouchAction(driver).tap(PrivacyContinue_button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PersonalPreferencesContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(PersonalPreferencesContinue_button);
        ElementActions.performTouchAction(driver).tap(OnboardingPersonalDetailsContinue_button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PermissionsContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(PermissionsContinue_button);
        ElementActions.performTouchAction(driver).tap(GoToTheApp_button);
        ElementActions.performTouchAction(driver).tap(GoToMyVodafone_button);
    }

    public By getLetsGo_Button() {return LetsGo_Button;}
    public By getVodafone_Logo() {return Vodafone_Logo;}
    public By getAcceptTerms_button() {return AcceptTerms_button;}
    public By getContinue_button() {return Continue_button;}
    public By getTermsAndConditions_Header() { return termsAndConditions_Header;}
    public By getTermsAndConditions_Txt() { return termsAndConditions_Txt; }



}
