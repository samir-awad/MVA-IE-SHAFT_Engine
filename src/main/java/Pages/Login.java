package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private final AppiumDriver driver;
    private Home HomePage;
    private static By termsAndConditions_Header;
    private static By termsAndConditions_Txt;
    private static By AcceptTerms_button;
    private static By Continue_button;
    private static By Vodafone_Logo;
    private static By Reg_Login_Txt;
    private static By Reg_Login_Button;
    private static By Reg_Register_Txt;
    private static By Reg_Register_button;
    private static By Reg_OurPrivacy_Link;
    private static By Registration_Title;
    private static By Registration_SendToken;
    private static By Registration_OurPrivacy;
    private static By Registration_ResetYourPassword_RedirectText;
    private static By Registration_ResetYourPassword_RedirectLink;
    private static By Registration_UserName;
    private static By RestPassword_Title;
    private static By RestPassword_SendToken;
    private static By RestPassword_OurPrivacy;
    private static By RestPassword_RegisterHere_RedirectText;
    private static By RestPassword_RegisterHere_RedirectLink;
    private static By RestPassword_UserName;
    private static By Back_Arrow;
    private static By LoginVf_Logo;
    private static By LoginVf_title;
    private static By PhoneOrEmail_TxtField;
    private static By Password_TxtField;
    private static By KeepMe_Checkbox;
    private static By Login_button;
    private static By NeedToRegister_link;
    private static By ForgotPWD_link;
    private static By LoginOurPrivacy_link;
    private static By LegacyOverlay_title;
    private static By LegacyOverlay_text;
    private static By LegacyGoToMyVfWeb_button;
    private static By LegacyCancel_button;
    private static By Invalid_UserName_PWD_title;
    private static By Invalid_UserName_PWD_text;
    private static By Invalid_UserName_PWD_UpdatePWD_button;
    private static By Invalid_UserName_PWD_Ok_button;
    private static By Login_Inline_Error;
    private static By OurPrivacy_title;
    private static By OurPrivacy_text;
    private static By LetsGo_Button;
    private static By PrivacyContinue_button;
    private static By PaymentMethod_Continue_button;
    private static By PersonalPreferencesContinue_button;
    private static By Yes_Button;
    private static By NotNow_Button;
    private static By OnboardingPersonalDetailsContinue_button;
    private static By PermissionsContinue_button;
    private static By GoToTheApp_button;
    private static By Tutorials_button;
    private static By GoToMyVodafone_button;
    private static By OnboardingPersonalDetailsContinuePAYG_button;
    private static By Logout_button;
    private static By Skip_button;


    public Login(WebDriver driver) {
        this.driver = (AppiumDriver) driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            termsAndConditions_Header = MobileBy.AccessibilityId("id_accordion_description_title");
            termsAndConditions_Txt = MobileBy.xpath("(//android.widget.TextView[@content-desc=\"id_tc_content_item\"])[2]");
            AcceptTerms_button = MobileBy.AccessibilityId("id_TC_switch_accept_terms");
            Continue_button = MobileBy.AccessibilityId("id_tc_agree_button");
            Vodafone_Logo = MobileBy.AccessibilityId("id_login_and_register_logo");
            Reg_Login_Txt = MobileBy.AccessibilityId("id_login_and_register_login_text");
            Reg_Login_Button = MobileBy.AccessibilityId("signup_signin_login_btn");
            Reg_Register_Txt = MobileBy.AccessibilityId("id_login_and_register_register_text");
            Reg_Register_button = MobileBy.AccessibilityId("signup_signin_signup_btn");
            Reg_OurPrivacy_Link = MobileBy.AccessibilityId("tv_our_privacy");
            OurPrivacy_title = MobileBy.AccessibilityId("id_header_title_Our_Privacy");
            OurPrivacy_text = MobileBy.AccessibilityId("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]");
            Registration_Title = MobileBy.AccessibilityId("signup_signin_signup_btn");
            Registration_UserName = MobileBy.AccessibilityId("id_registration_edittext_username");
            Registration_SendToken = MobileBy.AccessibilityId("id_registration_button_sendtoken");
            Registration_OurPrivacy = MobileBy.AccessibilityId("id_registration_textview_ourprivacy");
            Registration_ResetYourPassword_RedirectText = MobileBy.AccessibilityId("id_registration_textview_beside_redirect");
            Registration_ResetYourPassword_RedirectLink = MobileBy.AccessibilityId("id_registration_textview_redirect");
            RestPassword_Title = MobileBy.AccessibilityId("id_forgotpassword_title");
//            RestPassword_SendToken =  MobileBy.AccessibilityId("");
//            RestPassword_OurPrivacy =  MobileBy.AccessibilityId("");
//            RestPassword_RegisterHere_RedirectText =  MobileBy.AccessibilityId("");
//            RestPassword_RegisterHere_RedirectLink =  MobileBy.AccessibilityId("");
//            RestPassword_UserName =  MobileBy.AccessibilityId("");
            Back_Arrow = MobileBy.AccessibilityId("id_header_back_arrow");
            LoginVf_Logo = MobileBy.AccessibilityId("id_login_vf_logo");
            LoginVf_title = MobileBy.AccessibilityId("id_login_title_text");
            PhoneOrEmail_TxtField = MobileBy.AccessibilityId("id_login_edittext_username");
            Password_TxtField = MobileBy.AccessibilityId("id_login_edittext_password");
//            KeepMe_Checkbox =  MobileBy.AccessibilityId("");
            Login_button = MobileBy.AccessibilityId("id_login_button_login");
            LegacyOverlay_title = MobileBy.AccessibilityId("error_pop_up_title");
            LegacyOverlay_text = MobileBy.AccessibilityId("id_error_pop_up_message");
            LegacyGoToMyVfWeb_button = MobileBy.AccessibilityId("Go to My Vodafone web");
            LegacyCancel_button = MobileBy.AccessibilityId("Cancel");
            Invalid_UserName_PWD_title = MobileBy.AccessibilityId("error_pop_up_title");
            Invalid_UserName_PWD_text = MobileBy.AccessibilityId("id_error_pop_up_message");
            Invalid_UserName_PWD_Ok_button = MobileBy.AccessibilityId("Ok");
            Invalid_UserName_PWD_UpdatePWD_button = MobileBy.AccessibilityId("Update Password");
            LetsGo_Button = MobileBy.xpath("//android.widget.TextView[@content-desc=\"OBstartButton\"]");
            PrivacyContinue_button = MobileBy.AccessibilityId("id_privacy_policy_continue_button");
            PersonalPreferencesContinue_button = MobileBy.AccessibilityId("id_onboarding_personal_preferences_continue_button");
            PaymentMethod_Continue_button = MobileBy.AccessibilityId("id_onboarding_payment_method_continue_button");
            Yes_Button = MobileBy.xpath("//android.widget.Button[@content-desc=\"Yes\"]/android.widget.TextView");
            OnboardingPersonalDetailsContinue_button = MobileBy.AccessibilityId("id_onboarding_payment_method_continue_button");
            OnboardingPersonalDetailsContinuePAYG_button = MobileBy.AccessibilityId("id_onboarding_personal_details_continue_button");
            PermissionsContinue_button = MobileBy.AccessibilityId("id_onboarding_permissions_continue_button");
            GoToTheApp_button = MobileBy.AccessibilityId("OBgetStartedButton");
            Tutorials_button = MobileBy.AccessibilityId("id_tutorials_tour_button");
            GoToMyVodafone_button = MobileBy.AccessibilityId("id_tutorials_dismiss_button");
            NotNow_Button = MobileBy.AccessibilityId("id_biometric_login_no_button");


        } else {

            termsAndConditions_Header = MobileBy.AccessibilityId("id_accordion_description_title");
            termsAndConditions_Txt = MobileBy.xpath("(//XCUIElementTypeStaticText[@name=\"id_tc_content_item\"])[2]");
            AcceptTerms_button = MobileBy.xpath("//XCUIElementTypeOther[@name=\"id_TC_switch_accept_terms\"]");
            Continue_button = MobileBy.AccessibilityId("Continue");
            Vodafone_Logo = MobileBy.AccessibilityId("id_login_and_register_logo");
            Reg_Login_Button = MobileBy.AccessibilityId("Login");
            OurPrivacy_title = MobileBy.AccessibilityId("id_header_title_Our_Privacy");
            OurPrivacy_text = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"We're committed to keeping you informed about the information we use to bring you our products and services. Each section gives detail on the information we collect, what we do with it and how you can manage it.\"]");
            LoginVf_Logo = MobileBy.AccessibilityId("id_login_vf_logo");
            LoginVf_title = MobileBy.AccessibilityId("id_login_title_text");
            PhoneOrEmail_TxtField = MobileBy.AccessibilityId("id_login_edittext_username");
            Password_TxtField = MobileBy.AccessibilityId("id_login_edittext_password");
            KeepMe_Checkbox = MobileBy.AccessibilityId("id_login_switch_keepmeloggedin");
            Login_button = MobileBy.AccessibilityId("Login");
            NeedToRegister_link = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"id_login_textview_needtoregister\"]");
            ForgotPWD_link = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"id_login_textview_forgotyourpassword\"]");
            LoginOurPrivacy_link = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"id_login_textview_ourprivacy\"]");
            LegacyOverlay_title = MobileBy.AccessibilityId("error_pop_up_title");
            LegacyOverlay_text = MobileBy.AccessibilityId("id_error_pop_up_message");
            LegacyGoToMyVfWeb_button = MobileBy.AccessibilityId("Go to My Vodafone web");
            LegacyCancel_button = MobileBy.AccessibilityId("Cancel");
            LetsGo_Button = MobileBy.AccessibilityId("OBstartButton");
            Invalid_UserName_PWD_title = MobileBy.AccessibilityId("error_pop_up_title");
            Invalid_UserName_PWD_text = MobileBy.AccessibilityId("id_error_pop_up_message");
            Invalid_UserName_PWD_Ok_button = MobileBy.AccessibilityId("Ok");
            Invalid_UserName_PWD_UpdatePWD_button = MobileBy.AccessibilityId("Update Password");
            Login_Inline_Error = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"Email is not valid\"]");
            PrivacyContinue_button = MobileBy.AccessibilityId("Continue");
            PersonalPreferencesContinue_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Continue\"])[2]");
            PaymentMethod_Continue_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Continue\"])[2]");
            Yes_Button = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Yes\"]");
            PermissionsContinue_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Continue\"])[2]");
            GoToTheApp_button = MobileBy.AccessibilityId("OBgetStartedButton");
            Tutorials_button = MobileBy.AccessibilityId("Take a quick tour");
            Skip_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Skip\"])[2]");
            GoToMyVodafone_button = MobileBy.AccessibilityId("Go to My Vodafone");
            RestPassword_Title = MobileBy.AccessibilityId("id_forgotpassword_title");
            Reg_Login_Txt = MobileBy.AccessibilityId("id_login_and_register_login_text");
            Reg_Register_Txt = MobileBy.AccessibilityId("id_login_and_register_register_text");
            Reg_OurPrivacy_Link = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"tv_our_privacy\"]");
            Reg_Register_button = MobileBy.AccessibilityId("Register");
            Back_Arrow = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_back_arrow\"])[2]");
            OnboardingPersonalDetailsContinuePAYG_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Continue\"])[2]");
            NotNow_Button = MobileBy.AccessibilityId("Not now");
        }
    }

    public Login acceptTermsAndConditions() {
        ElementActions.waitForElementToBePresent(driver, AcceptTerms_button, 5, true);
        ElementActions.performTouchAction(driver).tap(AcceptTerms_button);
        ElementActions.performTouchAction(driver).tap(Continue_button);
        return this;
    }

    public Login EnterPasswordAndLogin(String password) {
        ElementActions.type(driver, Password_TxtField, password);
        ElementActions.performTouchAction(driver).tap(Login_button);
        return this;
    }

    public Login EnterUserName(String username) {
        ElementActions.type(driver, PhoneOrEmail_TxtField, username);
        return this;
    }

    public Login login(String username, String password) {
        //ElementActions.performTouchAction(driver).tap(Reg_Login_Button);
        ElementActions.type(driver, PhoneOrEmail_TxtField, username);
        ElementActions.type(driver, Password_TxtField, password);
        ElementActions.performTouchAction(driver).tap(Login_button);
        return this;
    }

    public void acceptPermissions() {
        ElementActions.isElementDisplayed(driver, LetsGo_Button);
        ElementActions.performTouchAction(driver).tap(LetsGo_Button);
        ElementActions.isElementDisplayed(driver, PrivacyContinue_button);
        ElementActions.performTouchAction(driver).tap(PrivacyContinue_button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PersonalPreferencesContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.isElementDisplayed(driver, PersonalPreferencesContinue_button);
        driver.findElement(PersonalPreferencesContinue_button).click();
//        ElementActions.performTouchAction(driver).tap(PersonalPreferencesContinue_button);
        ElementActions.isElementDisplayed(driver, PaymentMethod_Continue_button);
        ElementActions.performTouchAction(driver).tap(PaymentMethod_Continue_button);
        ElementActions.isElementDisplayed(driver, NotNow_Button);
        ElementActions.performTouchAction(driver).tap(NotNow_Button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PermissionsContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.isElementDisplayed(driver, PermissionsContinue_button);
        driver.findElement(PermissionsContinue_button).click();
//        ElementActions.performTouchAction(driver).tap(PermissionsContinue_button);
        ElementActions.isElementDisplayed(driver, GoToTheApp_button);
        ElementActions.performTouchAction(driver).tap(GoToTheApp_button);
        ElementActions.isElementDisplayed(driver, GoToMyVodafone_button);
        ElementActions.performTouchAction(driver).tap(GoToMyVodafone_button);
    }

    public void acceptPermissionsWithoutSkipingTutorials() {
        ElementActions.performTouchAction(driver).tap(LetsGo_Button);
        ElementActions.performTouchAction(driver).tap(PrivacyContinue_button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PersonalPreferencesContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(PersonalPreferencesContinue_button);
        ElementActions.performTouchAction(driver).tap(PaymentMethod_Continue_button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PermissionsContinue_button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(PermissionsContinue_button);
        ElementActions.performTouchAction(driver).tap(GoToTheApp_button);
        ElementActions.performTouchAction(driver).tap(Tutorials_button);
    }

    public void acceptPermissionsPAYGUser() {
        ElementActions.performTouchAction(driver).tap(LetsGo_Button);
        ElementActions.performTouchAction(driver).tap(PrivacyContinue_button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PersonalPreferencesContinue_button, TouchActions.SwipeDirection.UP);
        driver.findElement(PersonalPreferencesContinue_button).click();
//        ElementActions.performTouchAction(driver).tap(PersonalPreferencesContinue_button);
        ElementActions.performTouchAction(driver).tap(OnboardingPersonalDetailsContinuePAYG_button);
        ElementActions.isElementDisplayed(driver, NotNow_Button);
        ElementActions.performTouchAction(driver).tap(NotNow_Button);
        ElementActions.performTouchAction(driver).swipeElementIntoView(PermissionsContinue_button, TouchActions.SwipeDirection.UP);
        driver.findElement(PermissionsContinue_button).click();
//        ElementActions.performTouchAction(driver).tap(PermissionsContinue_button);
        ElementActions.performTouchAction(driver).tap(GoToTheApp_button);
        ElementActions.performTouchAction(driver).tap(GoToMyVodafone_button);
    }


    public void PressReg_LoginButton() {
        ElementActions.performTouchAction(driver).tap(Reg_Login_Button);
    }

    public void PressBack() {
        ElementActions.performTouchAction(driver).tap(Back_Arrow);
    }

    public void Logout() {
        ElementActions.performTouchAction(driver).tap(HomePage.getAccount());
        ElementActions.performTouchAction(driver).tap(getLogout_button());
    }

    public By getLetsGo_Button() {
        return LetsGo_Button;
    }

    public By getVodafone_Logo() {
        return Vodafone_Logo;
    }

    public By getAcceptTerms_button() {
        return AcceptTerms_button;
    }

    public By getContinue_button() {
        return Continue_button;
    }

    public By getTermsAndConditions_Header() {
        return termsAndConditions_Header;
    }

    public By getTermsAndConditions_Txt() {
        return termsAndConditions_Txt;
    }

    public By getReg_Login_Button() {
        return Reg_Login_Button;
    }

    public By getReg_Login_Txt() {
        return Reg_Login_Txt;
    }

    public By getReg_Register_Txt() {
        return Reg_Register_Txt;
    }

    public By getReg_Register_button() {
        return Reg_Register_button;
    }

    public By getLegacyOverlay_title() {
        return LegacyOverlay_title;
    }

    public By getLegacyOverlay_text() {
        return LegacyOverlay_text;
    }

    public By getLegacyGoToMyVfWeb_button() {
        return LegacyGoToMyVfWeb_button;
    }

    public By getLegacyCancel_button() {
        return LegacyCancel_button;
    }

    public By getInvalid_UserName_PWD_title() {
        return Invalid_UserName_PWD_title;
    }

    public By getInvalid_UserName_PWD_text() {
        return Invalid_UserName_PWD_text;
    }

    public By getInvalid_UserName_PWD_UpdatePWD_button() {
        return Invalid_UserName_PWD_UpdatePWD_button;
    }

    public By getInvalid_UserName_PWD_Ok_button() {
        return Invalid_UserName_PWD_Ok_button;
    }

    public By getRestPassword_Title() {
        return RestPassword_Title;
    }

    public By getLogin_Inline_Error() {
        return Login_Inline_Error;
    }

    public By getReg_OurPrivacy_Link() {
        return Reg_OurPrivacy_Link;
    }

    public By getOurPrivacy_title() {
        return OurPrivacy_title;
    }

    public By getOurPrivacy_text() {
        return OurPrivacy_text;
    }

    public By getLoginVf_Logo() {
        return LoginVf_Logo;
    }

    public By getLoginVf_title() {
        return LoginVf_title;
    }

    public By getPhoneOrEmail_TxtField() {
        return PhoneOrEmail_TxtField;
    }

    public By getPassword_TxtField() {
        return Password_TxtField;
    }

    public By getLogin_button() {
        return Login_button;
    }

    public By getKeepMe_Checkbox() {
        return KeepMe_Checkbox;
    }

    public By getNeedToRegister_link() {
        return NeedToRegister_link;
    }

    public By getForgotPWD_link() {
        return ForgotPWD_link;
    }

    public By getLoginOurPrivacy_link() {
        return LoginOurPrivacy_link;
    }

    public By getLogout_button() {
        return Logout_button;
    }

    public By getTutorials_button() {
        return Tutorials_button;
    }

    public By getSkip_button() {
        return Skip_button;
    }

    public By getRegistration_Title() {
        return Registration_Title;
    }

    public By getRegistration_SendToken() {
        return Registration_SendToken;
    }

    public By getRegistration_OurPrivacy() {
        return Registration_OurPrivacy;
    }

    public By getRegistration_ResetYourPassword_RedirectText() {
        return Registration_ResetYourPassword_RedirectText;
    }

    public By getRegistration_ResetYourPassword_RedirectLink() {
        return Registration_ResetYourPassword_RedirectLink;
    }

    public By getRegistration_UserName() {
        return Registration_UserName;
    }

    public By getRestPassword_SendToken() {
        return RestPassword_SendToken;
    }

    public By getRestPassword_OurPrivacy() {
        return RestPassword_OurPrivacy;
    }

    public By getRestPassword_RegisterHere_RedirectText() {
        return RestPassword_RegisterHere_RedirectText;
    }

    public By getRestPassword_RegisterHere_RedirectLink() {
        return RestPassword_RegisterHere_RedirectLink;
    }

    public By getRestPassword_UserName() {
        return RestPassword_UserName;
    }

    public By getBack_Arrow() {
        return Back_Arrow;
    }

    public By getPrivacyContinue_button() {
        return PrivacyContinue_button;
    }

    public By getPaymentMethod_Continue_button() {
        return PaymentMethod_Continue_button;
    }

    public By getPersonalPreferencesContinue_button() {
        return PersonalPreferencesContinue_button;
    }

    public By getYes_Button() {
        return Yes_Button;
    }

    public By getNotNow_Button() {
        return NotNow_Button;
    }

    public By getOnboardingPersonalDetailsContinue_button() {
        return OnboardingPersonalDetailsContinue_button;
    }

    public By getPermissionsContinue_button() {
        return PermissionsContinue_button;
    }

    public By getGoToTheApp_button() {
        return GoToTheApp_button;
    }

    public By getGoToMyVodafone_button() {
        return GoToMyVodafone_button;
    }

    public By getOnboardingPersonalDetailsContinuePAYG_button() {
        return OnboardingPersonalDetailsContinuePAYG_button;
    }
}
