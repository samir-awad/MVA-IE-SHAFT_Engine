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
    private By LoginVf_Logo;
    private By LoginVf_title;
    private By PhoneOrEmail_TxtField;
    private By Password_TxtField;
    private By KeepMe_Checkbox;
    private By Login_button;
    private By NeedToRegister_link;
    private By ForgotPWD_link;
    private By LoginOurPrivacy_link;
    private By LegacyOverlay_title;
    private By LegacyOverlay_text;
    private By LegacyGoToMyVfWeb_button;
    private By LegacyCancel_button;
    private By Invalid_UserName_PWD_title;
    private By Invalid_UserName_PWD_text;
    private By Invalid_UserName_PWD_UpdatePWD_button;
    private By Invalid_UserName_PWD_Ok_button;
    private By Login_Inline_Error;
    private By OurPrivacy_title;
    private By OurPrivacy_text;
    private By LetsGo_Button;
    private By PrivacyContinue_button;
    private By PaymentMethod_Continue_button;
    private By PersonalPreferencesContinue_button;
    private By Yes_Button;
    private By NotNow_Button;
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
            OurPrivacy_title = new MobileBy.ByAccessibilityId("id_header_title_Our_Privacy");
            OurPrivacy_text = new MobileBy.ByAccessibilityId("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]");
            Registration_Title = new MobileBy.ByAccessibilityId("signup_signin_signup_btn");
            Registration_UserName = new MobileBy.ByAccessibilityId("id_registration_edittext_username");
            Registration_SendToken = new MobileBy.ByAccessibilityId("id_registration_button_sendtoken");
            Registration_OurPrivacy = new MobileBy.ByAccessibilityId("id_registration_textview_ourprivacy");
            Registration_ResetYourPassword_RedirectText = new MobileBy.ByAccessibilityId("id_registration_textview_beside_redirect");
            Registration_ResetYourPassword_RedirectLink = new MobileBy.ByAccessibilityId("id_registration_textview_redirect");
            RestPassword_Title = new MobileBy.ByAccessibilityId("id_forgotpassword_title");
//            RestPassword_SendToken = new MobileBy.ByAccessibilityId("");
//            RestPassword_OurPrivacy = new MobileBy.ByAccessibilityId("");
//            RestPassword_RegisterHere_RedirectText = new MobileBy.ByAccessibilityId("");
//            RestPassword_RegisterHere_RedirectLink = new MobileBy.ByAccessibilityId("");
//            RestPassword_UserName = new MobileBy.ByAccessibilityId("");
            Back_Arrow = new MobileBy.ByAccessibilityId("id_header_back_arrow");
            LoginVf_Logo = new MobileBy.ByAccessibilityId("id_login_vf_logo");
            LoginVf_title = new MobileBy.ByAccessibilityId("id_login_title_text");
            PhoneOrEmail_TxtField = new MobileBy.ByAccessibilityId("id_login_edittext_username");
            Password_TxtField = new MobileBy.ByAccessibilityId("id_login_edittext_password");
//            KeepMe_Checkbox = new MobileBy.ByAccessibilityId("");
            Login_button = new MobileBy.ByAccessibilityId("id_login_button_login");
            LegacyOverlay_title = new MobileBy.ByAccessibilityId("error_pop_up_title");
            LegacyOverlay_text = new MobileBy.ByAccessibilityId("id_error_pop_up_message");
            LegacyGoToMyVfWeb_button = new MobileBy.ByAccessibilityId("Go to My Vodafone web");
            LegacyCancel_button = new MobileBy.ByAccessibilityId("Cancel");
            Invalid_UserName_PWD_title =new MobileBy.ByAccessibilityId("error_pop_up_title");
            Invalid_UserName_PWD_text =new MobileBy.ByAccessibilityId("id_error_pop_up_message");
            Invalid_UserName_PWD_Ok_button = new MobileBy.ByAccessibilityId("Ok");
            Invalid_UserName_PWD_UpdatePWD_button = new MobileBy.ByAccessibilityId("Update Password");
            LetsGo_Button = By.xpath("//android.widget.TextView[@content-desc=\"OBstartButton\"]");
            PrivacyContinue_button = new MobileBy.ByAccessibilityId("id_privacy_policy_continue_button");
            PersonalPreferencesContinue_button = new MobileBy.ByAccessibilityId("id_onboarding_personal_preferences_continue_button");
            PaymentMethod_Continue_button = new MobileBy.ByAccessibilityId("id_onboarding_payment_method_continue_button");
            Yes_Button = By.xpath("//android.widget.Button[@content-desc=\"Yes\"]/android.widget.TextView");
            OnboardingPersonalDetailsContinue_button = new MobileBy.ByAccessibilityId("id_onboarding_payment_method_continue_button");
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
            OurPrivacy_title = new MobileBy.ByAccessibilityId("id_header_title_Our_Privacy");
            OurPrivacy_text = By.xpath("//XCUIElementTypeStaticText[@name=\"We're committed to keeping you informed about the information we use to bring you our products and services. Each section gives detail on the information we collect, what we do with it and how you can manage it.\"]");
            LoginVf_Logo = new MobileBy.ByAccessibilityId("id_login_vf_logo");
            LoginVf_title = new MobileBy.ByAccessibilityId("id_login_title_text");
            PhoneOrEmail_TxtField = new MobileBy.ByAccessibilityId("id_login_edittext_username");
            Password_TxtField = new MobileBy.ByAccessibilityId("id_login_edittext_password");
            KeepMe_Checkbox = new MobileBy.ByAccessibilityId("id_login_switch_keepmeloggedin");
            Login_button=new MobileBy.ByAccessibilityId("Login");
            NeedToRegister_link =By.xpath("//XCUIElementTypeStaticText[@name=\"id_login_textview_needtoregister\"]");
            ForgotPWD_link = By.xpath("//XCUIElementTypeStaticText[@name=\"id_login_textview_forgotyourpassword\"]");
            LoginOurPrivacy_link = By.xpath("//XCUIElementTypeStaticText[@name=\"id_login_textview_ourprivacy\"]");
            LegacyOverlay_title = new MobileBy.ByAccessibilityId("error_pop_up_title");
            LegacyOverlay_text = new MobileBy.ByAccessibilityId("id_error_pop_up_message");
            LegacyGoToMyVfWeb_button = new MobileBy.ByAccessibilityId("Go to My Vodafone web");
            LegacyCancel_button = new MobileBy.ByAccessibilityId("Cancel");
            LetsGo_Button =new MobileBy.ByAccessibilityId("OBstartButton");
            Invalid_UserName_PWD_title =new MobileBy.ByAccessibilityId("error_pop_up_title");
            Invalid_UserName_PWD_text =new MobileBy.ByAccessibilityId("id_error_pop_up_message");
            Invalid_UserName_PWD_Ok_button = new MobileBy.ByAccessibilityId("Ok");
            Invalid_UserName_PWD_UpdatePWD_button = new MobileBy.ByAccessibilityId("Update Password");
            Login_Inline_Error = new MobileBy.ByAccessibilityId("//XCUIElementTypeStaticText[@name=\"Email is not valid\"]");
            PrivacyContinue_button = new MobileBy.ByAccessibilityId("Continue");
            PersonalPreferencesContinue_button = By.xpath("(//XCUIElementTypeOther[@name=\"Continue\"])[2]");
            PaymentMethod_Continue_button =By.xpath("(//XCUIElementTypeOther[@name=\"Continue\"])[2]");
            Yes_Button = By.xpath("//XCUIElementTypeOther[@name=\"Yes\"]");
            NotNow_Button = new MobileBy.ByAccessibilityId("Not now");
            PermissionsContinue_button =By.xpath("(//XCUIElementTypeOther[@name=\"Continue\"])[2]");
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

    public void EnterPasswordAndLogin(String password){
        ElementActions.type(driver, Password_TxtField, password);
        ElementActions.performTouchAction(driver).tap(Login_button);
    }

    public void EnterUserName(String username){
        ElementActions.type(driver, PhoneOrEmail_TxtField, username);
    }

    public Login login(String username,String password) {
        ElementActions.performTouchAction(driver).tap(Reg_Login_Button);
        ElementActions.type(driver, PhoneOrEmail_TxtField, username);
        ElementActions.type(driver, Password_TxtField, password);
        ElementActions.performTouchAction(driver).tap(Login_button);
        return this;
    }

    public void acceptPermissions() {
        ElementActions.performTouchAction(driver).tap(LetsGo_Button);
        ElementActions.performTouchAction(driver).tap(PrivacyContinue_button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PersonalPreferencesContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(PersonalPreferencesContinue_button);
        ElementActions.performTouchAction(driver).tap(PaymentMethod_Continue_button);
       //ElementActions.performTouchAction(driver).tap(OnboardingPersonalDetailsContinue_button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PermissionsContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(PermissionsContinue_button);
        ElementActions.performTouchAction(driver).tap(GoToTheApp_button);
        ElementActions.performTouchAction(driver).tap(GoToMyVodafone_button);
    }

    public void PressReg_LoginButton(){
        ElementActions.performTouchAction(driver).tap(Reg_Login_Button);
    }

    public void PressBack(){
        ElementActions.performTouchAction(driver).tap(Back_Arrow);
    }

    public By getLetsGo_Button() {return LetsGo_Button;}
    public By getVodafone_Logo() {return Vodafone_Logo;}
    public By getAcceptTerms_button() {return AcceptTerms_button;}
    public By getContinue_button() {return Continue_button;}
    public By getTermsAndConditions_Header() { return termsAndConditions_Header;}
    public By getTermsAndConditions_Txt() { return termsAndConditions_Txt; }
    public By getReg_Login_Button() {return Reg_Login_Button;}
    public By getReg_Login_Txt() {return Reg_Login_Txt;}
    public By getReg_Register_Txt() {return Reg_Register_Txt;}
    public By getReg_Register_button() {return Reg_Register_button;}
    public By getLegacyOverlay_title() {return LegacyOverlay_title;}
    public By getLegacyOverlay_text() {return LegacyOverlay_text;}
    public By getLegacyGoToMyVfWeb_button() {return LegacyGoToMyVfWeb_button;}
    public By getLegacyCancel_button() {return LegacyCancel_button;}
    public By getInvalid_UserName_PWD_title() {return Invalid_UserName_PWD_title;}
    public By getInvalid_UserName_PWD_text() {return Invalid_UserName_PWD_text;}
    public By getInvalid_UserName_PWD_UpdatePWD_button() {return Invalid_UserName_PWD_UpdatePWD_button;}
    public By getInvalid_UserName_PWD_Ok_button() {return Invalid_UserName_PWD_Ok_button;}
    public By getRestPassword_Title() {return RestPassword_Title;}
    public By getLogin_Inline_Error() {return Login_Inline_Error;}
    public By getReg_OurPrivacy_Link() {return Reg_OurPrivacy_Link;}
    public By getOurPrivacy_title() {return OurPrivacy_title;}
    public By getOurPrivacy_text() {return OurPrivacy_text;}
    public By getLoginVf_Logo() {return LoginVf_Logo;}
    public By getLoginVf_title() {return LoginVf_title;}
    public By getPhoneOrEmail_TxtField() {return PhoneOrEmail_TxtField;}
    public By getPassword_TxtField() {return Password_TxtField;}
    public By getLogin_button() {return Login_button;}
    public By getKeepMe_Checkbox() {return KeepMe_Checkbox;}
    public By getNeedToRegister_link() {return NeedToRegister_link;}
    public By getForgotPWD_link() {return ForgotPWD_link;}
    public By getLoginOurPrivacy_link() {return LoginOurPrivacy_link;}



}
