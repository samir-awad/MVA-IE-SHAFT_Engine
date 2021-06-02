package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
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
    private By EmailOption_Button;
    private By EmailPageHeader;
    private By EmailInputField;
    private By SaveButtonBecomesEnabled;
    private By HeaderBackChevron_Button;
    private By BillingDetailsOption;
    private By BillingDetailsPageHeader;
    private By DetailsPageContent;
    private By DetailsHeaderClose_Button;
    private By DetailsBillingPreferencesSection;
    private By EnterAddressManuallyLink_Button;
    private By AddressSectionFieldsForManualAddress;
    private By SearchForYourAddressLink_Button;
    private By AccountNameField;
    private By AccountHeaderClose_Button;
    private By MyRecordsOption_Button;
    private By MyRecordsPageHeader;
    private By AvailableTabOptions;
    private By OrdersArea;
    private By LettersTabOption;
    private By ThatExistsAtLeastOneLetter;
    private By FirstLetterAttachmentsLink;
    private By AppToOpenLetterWith;
    private By LetterIsOpenedAsPdfDocument;
    private By BackToMyRecordsPage;
    private By MyRecordsHeaderClose_Button;
    private By OurPrivacyLink;
    private By OurPrivacyHeader;
    private By CloseInPrivacy_Button;
    private By AppPermissionsOption;
    private By RateUsOption;
    private By PersonalDetailsPageHeader;
    private By PersonalDetailsPageContent;
    private By BackForPersonalDetails_Button;
    private By CloseForPersonalDetails_Button;
    private By YourDetailsSection;
    private By YourDetailsPageHeader;
    private By YourDetailsPageContent;
    private By YourDetailsEdit_Button;
    private By YourDetailsCancel_Button;
    private By BackForDetailsPage_Button;
    private By CloseForDetailsPage_Button;
    private By ManagePersonalInformation_Section;
    private By ManagePersonalInformationPageHeader;
    private By ManagePersonalInformationPageContent;
    private By ManagePersonalInformationEdit_Button;
    private By ManagePersonalInformationEditContent;
    private By DownloadDataRequestForm_Button;
    private By DeletionRequestForm_Button;
    private By BackForTheRequestInformationPage_Button;
    private By CloseForManagePersonalInformationSection_Button;
    private By SubjectAccessRequestFormPdfIsOpened;
    private By PdfBack_Button;
    private By Chrome_driver;
    private By MarketingPreferences_Section;
    private By MarketingPreferencesPageHeader;
    private By MarketingPreferencesPageContent;
    private By MarketingPreferencesEdit_Button;
    private By MarketingPreferencesEditContent;
    private By MarketingPreferencesCancel_Button;
    private By BackForMarketingPreferencesPage_Button;
    private By CloseForMarketingPreferencesPage_Button;
    private By DataPreferencesSection;
    private By DataPreferencesPageHeader;
    private By DataPreferencesPageContent;
    private By DataPreferencesEdit_Button;
    private By DataPreferencesEditContent;
    private By DataPreferencesCancel_Button;
    private By BackForDataPreferences_Button;
    private By CloseForDataPreference_Button;
    private By SecuritySection;
    private By SecurityPageHeader;
    private By SecurityPageContent;
    private By SecurityEditPassword_Button;
    private By ChangePasswordPageHeader;
    private By ChangePasswordPageContent;
    private By ChangePasswordCancel_Button;
    private By SecurityEditPin_Button;
    private By ChangePinPageHeader;
    private By ChangePinPageContent;
    private By ChangePinCancel_Button;
    private By BackForSecurityPage_Button;
    private By CloseForSecurityPage_Button;
    private By BiometricsOption;


    public Account(WebDriver driver) {

        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            AccountTry_Button = MobileBy.AccessibilityId("id_tray_menu_item_icon_Account");
            AccountOverlay = MobileBy.AccessibilityId("STundefinedMainTitle");
            AccountSettingOption = MobileBy.AccessibilityId("id_account_overlay_Settings_title");
            AccountSettingsPageHeader = MobileBy.AccessibilityId("id_header_title_Settings");
            AccountSettingsSection = MobileBy.AccessibilityId("id_account_settings_title");
            PersonalDetailsSection = MobileBy.AccessibilityId("id_personal_details_title");
            AppSettingsSection = MobileBy.AccessibilityId("id_app_settings_title");
            Close_Button = MobileBy.AccessibilityId("Close button");
            EmailOption_Button = By.xpath("(//android.widget.TextView[@content-desc=\"id_account_settings_item_title\"])[1]");
            EmailPageHeader = MobileBy.AccessibilityId("id_header_title_Account_name_&_email");
            EmailInputField = MobileBy.AccessibilityId("id_account_and_email_email_input");
            SaveButtonBecomesEnabled = MobileBy.AccessibilityId("Button");
            HeaderBackChevron_Button = MobileBy.AccessibilityId("id_header_back_arrow");
            BillingDetailsOption = By.xpath("(//android.widget.TextView[@content-desc=\"id_account_settings_item_title\"])[2]");
            BillingDetailsPageHeader = MobileBy.AccessibilityId("id_header_title_Billing_details");
            DetailsPageContent = MobileBy.AccessibilityId("id_billing_address_content_card_title");
            DetailsHeaderClose_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"Close button\"])[2]");
            DetailsBillingPreferencesSection = MobileBy.AccessibilityId("id_billing_preferences_content_card_title");
            EnterAddressManuallyLink_Button = MobileBy.AccessibilityId("id_billing_address_address_mode_text");
            AddressSectionFieldsForManualAddress = MobileBy.AccessibilityId("id_billing_address_content_card_title");
            SearchForYourAddressLink_Button = MobileBy.AccessibilityId("id_billing_address_address_mode_text");
            AccountNameField = MobileBy.AccessibilityId("id_account_and_email_name_input");
            AccountHeaderClose_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[2]");
            MyRecordsOption_Button = MobileBy.AccessibilityId("id_account_overlay_My Records_title");
            MyRecordsPageHeader = MobileBy.AccessibilityId("id_header_title_My_Records");
            AvailableTabOptions = By.xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TabWidget");
            OrdersArea = By.id("orders");
            LettersTabOption = By.id("Letter");
            ThatExistsAtLeastOneLetter = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[1]");
            FirstLetterAttachmentsLink = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[7]/android.widget.Button");
            //AppToOpenLetterWith = By.xpath("");
            //  LetterIsOpenedAsPdfDocument = By.xpath("");
            // BackToMyRecordsPage = By.xpath("");
            MyRecordsHeaderClose_Button = MobileBy.AccessibilityId("id_header_close_icon");
            OurPrivacyLink = MobileBy.AccessibilityId("id_account_overlay_our_privacy");
            OurPrivacyHeader = MobileBy.AccessibilityId("id_header_title_Our_Privacy");
            CloseInPrivacy_Button = MobileBy.AccessibilityId("id_header_close_icon");
            AppPermissionsOption = By.xpath("(//android.widget.TextView[@content-desc=\"id_app_settings_item_title\"])[1]");
            RateUsOption = By.xpath("(//android.widget.TextView[@content-desc=\"id_app_settings_item_title\"])[2]");
            PersonalDetailsPageHeader = MobileBy.AccessibilityId("id_header_title_Personal_details");
            PersonalDetailsPageContent = MobileBy.AccessibilityId("id_personal_details_card_your_details_title");
            BackForPersonalDetails_Button = MobileBy.AccessibilityId("id_header_back_arrow");
            CloseForPersonalDetails_Button = MobileBy.AccessibilityId("id_header_close_icon");
            //CloseForPersonalDetails_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[2]");
            YourDetailsSection = MobileBy.iOSClassChain("**/XCUIElementTypeOther[`label == \"Your details Name, date of birth, contact information and address\"`][2]");
            YourDetailsPageHeader = MobileBy.AccessibilityId("id_header_title_Your_details");
            YourDetailsPageContent = MobileBy.AccessibilityId("id_personal_details_your_details_title");
            YourDetailsEdit_Button = MobileBy.AccessibilityId("id_personal_details_your_details_button_edit");
            YourDetailsCancel_Button = MobileBy.AccessibilityId("id_personal_details_your_details_button_cancel");
            BackForDetailsPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForDetailsPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            ManagePersonalInformation_Section = MobileBy.AccessibilityId("id_personal_details_card_personal_information_title");
            ManagePersonalInformationPageHeader = MobileBy.AccessibilityId("id_header_title_Request_Information");
            ManagePersonalInformationPageContent = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_content_card_data_protection_your_rights_title");
            ManagePersonalInformationEdit_Button = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_button_data_protection_your_rights");
            ManagePersonalInformationEditContent = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_subject_access_request_title");
            DownloadDataRequestForm_Button = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_button_subject_access_request");
            DeletionRequestForm_Button = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_button_request_deletion");
            BackForTheRequestInformationPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForManagePersonalInformationSection_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            SubjectAccessRequestFormPdfIsOpened = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
            PdfBack_Button = MobileBy.AccessibilityId("Navigate up");
            Chrome_driver = By.id("com.android.chrome:id/url_bar");
            MarketingPreferences_Section = MobileBy.AccessibilityId("id_personal_details_card_marketing_preferences_title");
            MarketingPreferencesPageHeader = MobileBy.AccessibilityId("id_header_title_Marketing_preferences");
            MarketingPreferencesPageContent = MobileBy.AccessibilityId("id_personal_details_marketing_preferences_title");
            MarketingPreferencesEdit_Button = MobileBy.AccessibilityId("id_personal_details_marketing_preferences_button_edit");
            MarketingPreferencesEditContent = MobileBy.AccessibilityId("id_personal_details_marketing_preferences_edit_description");
            MarketingPreferencesCancel_Button = MobileBy.AccessibilityId("id_personal_details_marketing_preferences_edit_button_cancel");
            BackForMarketingPreferencesPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForMarketingPreferencesPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            DataPreferencesSection = MobileBy.AccessibilityId("id_personal_details_card_data_preferences_title");
            DataPreferencesPageHeader = MobileBy.AccessibilityId("id_header_title_Data_preferences");
            DataPreferencesPageContent = MobileBy.AccessibilityId("id_personal_details_data_preferences_title");
            DataPreferencesEdit_Button = MobileBy.AccessibilityId("id_personal_details_data_preferences_edit_button");
            DataPreferencesEditContent = MobileBy.AccessibilityId("id_personal_details_data_preferences_basic_permissions_title");
            DataPreferencesCancel_Button = MobileBy.AccessibilityId("id_personal_details_data_preferences_cancel_button");
            BackForDataPreferences_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForDataPreference_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            SecuritySection = MobileBy.AccessibilityId("id_personal_details_card_security_title");
            SecurityPageHeader = MobileBy.AccessibilityId("id_header_title_Security");
            SecurityPageContent = MobileBy.AccessibilityId("id_personal_details_security_title");
            SecurityEditPassword_Button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView");
            ChangePasswordPageHeader = MobileBy.AccessibilityId("id_header_title_Change_Password");
            ChangePasswordPageContent = MobileBy.AccessibilityId("id_personal_details_security_change_password_title");
            ChangePasswordCancel_Button = MobileBy.AccessibilityId("id_change_password_cancel_button");
            SecurityEditPin_Button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.ImageView");
            ChangePinPageHeader = MobileBy.AccessibilityId("id_header_title_Change_PIN");
            ChangePinPageContent = MobileBy.AccessibilityId("id_personal_details_security_change_PIN_title");
            ChangePinCancel_Button = MobileBy.AccessibilityId("id_change_pin_cancel_button");
            BackForSecurityPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForSecurityPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            //BiometricsOption = MobileBy.AccessibilityId("");
        } else {
            AccountTry_Button = MobileBy.AccessibilityId("id_tray_menu_item_Account");
            AccountOverlay = MobileBy.AccessibilityId("STundefinedMainTitle");
            AccountSettingOption = MobileBy.AccessibilityId("Settings Account, personal details & app settings");
            AccountSettingsPageHeader = MobileBy.AccessibilityId("id_header_title_Settings");
            AccountSettingsSection = MobileBy.AccessibilityId("Account settings");
            PersonalDetailsSection = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Personal details Details, privacy & preferences\"])[2]");
            AppSettingsSection = MobileBy.AccessibilityId("App settings");
            Close_Button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            EmailOption_Button = MobileBy.AccessibilityId("Account name & email");
            EmailPageHeader = MobileBy.AccessibilityId("id_header_title_Account_name_&_email");
            EmailInputField = MobileBy.AccessibilityId("id_account_and_email_email_input");
            SaveButtonBecomesEnabled = MobileBy.AccessibilityId("Save");
            HeaderBackChevron_Button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_back_arrow\"])[2]");
            BillingDetailsOption = MobileBy.AccessibilityId("Billing details");
            BillingDetailsPageHeader = MobileBy.AccessibilityId("id_header_title_Billing_details");
            DetailsPageContent = MobileBy.AccessibilityId("Billing address");
            DetailsHeaderClose_Button = By.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            DetailsBillingPreferencesSection = MobileBy.AccessibilityId("Billing preferences");
            EnterAddressManuallyLink_Button = MobileBy.AccessibilityId("Or enter address manually");
            AddressSectionFieldsForManualAddress = MobileBy.AccessibilityId("id_billing_address_content_card_title");
            SearchForYourAddressLink_Button = MobileBy.AccessibilityId("id_billing_address_address_mode_text");
            AccountNameField = MobileBy.AccessibilityId("id_account_and_email_name_input");
            AccountHeaderClose_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[2]");
            MyRecordsOption_Button = MobileBy.AccessibilityId("My Records Documents & contracts");
            MyRecordsPageHeader = MobileBy.AccessibilityId("id_header_title_My_Records");
            AvailableTabOptions = By.xpath("//XCUIElementTypeOther[@name=\"My Records | Vodafone\"]/XCUIElementTypeOther[6]");
            OrdersArea = MobileBy.AccessibilityId("Bills");
            LettersTabOption = MobileBy.xpath("(//XCUIElementTypeButton[@name=\"Payments\"])[2]");
            ThatExistsAtLeastOneLetter = By.xpath("(//XCUIElementTypeStaticText[@name=\"Letter\"])[1]");
            FirstLetterAttachmentsLink = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[7]/android.widget.Button");
            //AppToOpenLetterWith = By.xpath("");
            //  LetterIsOpenedAsPdfDocument = By.xpath("");
            // BackToMyRecordsPage = By.xpath("");
            MyRecordsHeaderClose_Button = MobileBy.AccessibilityId("id_header_close_icon");
            OurPrivacyLink = MobileBy.AccessibilityId("id_account_overlay_our_privacy");
            OurPrivacyHeader = MobileBy.AccessibilityId("id_header_title_Our_Privacy");
            CloseInPrivacy_Button = MobileBy.AccessibilityId("id_header_close_icon");
            AppPermissionsOption = By.xpath("(//android.widget.TextView[@content-desc=\"id_app_settings_item_title\"])[1]");
            RateUsOption = By.xpath("(//android.widget.TextView[@content-desc=\"id_app_settings_item_title\"])[2]");
            PersonalDetailsPageHeader = MobileBy.AccessibilityId("id_header_title_Personal_details");
            PersonalDetailsPageContent = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Your details Name, date of birth, contact information and address\"])[2]\n");
            BackForPersonalDetails_Button = MobileBy.AccessibilityId("id_header_back_arrow");
            CloseForPersonalDetails_Button = MobileBy.AccessibilityId("id_header_close_icon");
            //CloseForPersonalDetails_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[2]");
            YourDetailsSection = MobileBy.iOSClassChain("**/XCUIElementTypeOther[`label == \"Your details Name, date of birth, contact information and address\"`][2]");
            YourDetailsPageHeader = MobileBy.iOSClassChain("**/XCUIElementTypeOther[`label == \"id_header_close_icon\"`][2]");
            YourDetailsPageContent = MobileBy.AccessibilityId("Your personal details");
            YourDetailsEdit_Button = MobileBy.AccessibilityId("Edit");
            YourDetailsCancel_Button = MobileBy.AccessibilityId("Cancel");
            BackForDetailsPage_Button = MobileBy.iOSClassChain("**/XCUIElementTypeOther[`label == \"id_header_back_arrow\"`][2]");
            CloseForDetailsPage_Button = By.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            ManagePersonalInformation_Section = MobileBy.AccessibilityId("id_personal_details_card_personal_information_title");
            ManagePersonalInformationPageHeader = MobileBy.AccessibilityId("id_header_title_Request_Information");
            ManagePersonalInformationPageContent = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_content_card_data_protection_your_rights_title");
            ManagePersonalInformationEdit_Button = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_button_data_protection_your_rights");
            ManagePersonalInformationEditContent = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_subject_access_request_title");
            DownloadDataRequestForm_Button = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_button_subject_access_request");
            DeletionRequestForm_Button = MobileBy.AccessibilityId("id_personal_details_manage_personal_information_button_request_deletion");
            BackForTheRequestInformationPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForManagePersonalInformationSection_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            SubjectAccessRequestFormPdfIsOpened = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
            PdfBack_Button = MobileBy.AccessibilityId("Navigate up");
            Chrome_driver = By.id("com.android.chrome:id/url_bar");
            MarketingPreferences_Section = MobileBy.AccessibilityId("id_personal_details_card_marketing_preferences_title");
            MarketingPreferencesPageHeader = MobileBy.AccessibilityId("id_header_title_Marketing_preferences");
            MarketingPreferencesPageContent = MobileBy.AccessibilityId("id_personal_details_marketing_preferences_title");
            MarketingPreferencesEdit_Button = MobileBy.AccessibilityId("id_personal_details_marketing_preferences_button_edit");
            MarketingPreferencesEditContent = MobileBy.AccessibilityId("id_personal_details_marketing_preferences_edit_description");
            MarketingPreferencesCancel_Button = MobileBy.AccessibilityId("id_personal_details_marketing_preferences_edit_button_cancel");
            BackForMarketingPreferencesPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForMarketingPreferencesPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            DataPreferencesSection = MobileBy.AccessibilityId("id_personal_details_card_data_preferences_title");
            DataPreferencesPageHeader = MobileBy.AccessibilityId("id_header_title_Data_preferences");
            DataPreferencesPageContent = MobileBy.AccessibilityId("id_personal_details_data_preferences_title");
            DataPreferencesEdit_Button = MobileBy.AccessibilityId("id_personal_details_data_preferences_edit_button");
            DataPreferencesEditContent = MobileBy.AccessibilityId("id_personal_details_data_preferences_basic_permissions_title");
            DataPreferencesCancel_Button = MobileBy.AccessibilityId("id_personal_details_data_preferences_cancel_button");
            BackForDataPreferences_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForDataPreference_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            SecuritySection = MobileBy.AccessibilityId("id_personal_details_card_security_title");
            SecurityPageHeader = MobileBy.AccessibilityId("id_header_title_Security");
            SecurityPageContent = MobileBy.AccessibilityId("id_personal_details_security_title");
            SecurityEditPassword_Button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView");
            ChangePasswordPageHeader = MobileBy.AccessibilityId("id_header_title_Change_Password");
            ChangePasswordPageContent = MobileBy.AccessibilityId("id_personal_details_security_change_password_title");
            ChangePasswordCancel_Button = MobileBy.AccessibilityId("id_change_password_cancel_button");
            SecurityEditPin_Button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.ImageView");
            ChangePinPageHeader = MobileBy.AccessibilityId("id_header_title_Change_PIN");
            ChangePinPageContent = MobileBy.AccessibilityId("id_personal_details_security_change_PIN_title");
            ChangePinCancel_Button = MobileBy.AccessibilityId("id_change_pin_cancel_button");
            BackForSecurityPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_back_arrow\"])[2]");
            CloseForSecurityPage_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[3]");
            //BiometricsOption = MobileBy.AccessibilityId("");
        }


    }

    public By getSaveButtonBecomesEnabled() {
        return SaveButtonBecomesEnabled;
    }

    public By getCheckMarketingPreferencesPageHeader() {
        return MarketingPreferencesPageHeader;
    }

    public By getCheckMarketingPreferencesEditContent() {
        return MarketingPreferencesEditContent;
    }

    public By getCheckMarketingPreferencesPageContent() {
        return MarketingPreferencesPageContent;
    }

    public By getCheckDataPreferencesEditContent() {
        return DataPreferencesEditContent;
    }

    public By getCheckDataPreferencesPageContent() {
        return DataPreferencesPageContent;
    }

    public By getCheckDataPreferencesPageHeader() {
        return DataPreferencesPageHeader;
    }

    public By getCheckSecurityPageHeader() {
        return SecurityPageHeader;
    }

    public By getCheckSecurityPageContent() {
        return SecurityPageContent;
    }

    public By getCheckChangePasswordPageHeader() {
        return ChangePasswordPageHeader;
    }

    public By getCheckChangePasswordPageContent() {
        return ChangePasswordPageContent;
    }

    public By getCheckChangePinPageHeader() {
        return ChangePinPageHeader;
    }

    public By getCheckChangePinPageContent() {
        return ChangePinPageContent;
    }

    public By getCheckBiometricsOption() {
        return BiometricsOption;
    }

    public void pressDataPreferencesEditButton() {
        ElementActions.performTouchAction(driver).tap(DataPreferencesEdit_Button);
    }

    public void pressChangePinCancelButton() {
        ElementActions.performTouchAction(driver).tap(ChangePinCancel_Button);
    }

    public void pressBackButtonForSecurityPage() {
        ElementActions.performTouchAction(driver).tap(BackForSecurityPage_Button);
    }

    public void pressCloseButtonForSecurityPage() {
        ElementActions.performTouchAction(driver).tap(CloseForSecurityPage_Button);
    }

    public void pressChangePasswordCancelButton() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(ChangePasswordCancel_Button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(ChangePasswordCancel_Button);
    }

    public void pressSecurityEditPinButton() {
        ElementActions.performTouchAction(driver).tap(SecurityEditPin_Button);
    }

    public void pressSecurityEditPasswordButton() {
        ElementActions.performTouchAction(driver).tap(SecurityEditPassword_Button);
    }

    public void pressDataPreferencesCancelButton() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(DataPreferencesCancel_Button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(DataPreferencesCancel_Button);
    }

    public void pressSecuritySection() {
        ElementActions.performTouchAction(driver).tap(SecuritySection);
    }

    public void pressBackButtonForDataPreferences() {
        ElementActions.performTouchAction(driver).tap(BackForDataPreferences_Button);
    }

    public void pressCloseButtonForDataPreference() {
        ElementActions.performTouchAction(driver).tap(CloseForDataPreference_Button);
    }

    public void pressMarketingPreferencesCancelButton() {
        ElementActions.performTouchAction(driver).tap(MarketingPreferencesCancel_Button);
    }

    public void pressDataPreferencesSection() {
        ElementActions.performTouchAction(driver).tap(DataPreferencesSection);
    }

    public void pressBackButtonForMarketingPreferencesPage() {
        ElementActions.performTouchAction(driver).tap(BackForMarketingPreferencesPage_Button);
    }

    public void pressCloseButtonForMarketingPreferencesPage() {
        ElementActions.performTouchAction(driver).tap(CloseForMarketingPreferencesPage_Button);
    }

    public void pressAccountTrayMenuOption() {
        ElementActions.performTouchAction(driver).tap(AccountTry_Button);
    }

    public void pressBackButtonForPersonalDetails() {
        ElementActions.performTouchAction(driver).tap(BackForPersonalDetails_Button);
    }

    public void pressMarketingPreferencesEditButton() {
        ElementActions.performTouchAction(driver).tap(MarketingPreferencesEdit_Button);
    }

    public void pressPdfBackButton() {
        ElementActions.performTouchAction(driver).tap(PdfBack_Button);
    }

    public void pressYourDetailsSection() {
        ElementActions.performTouchAction(driver).tap(YourDetailsSection);
    }

    public void pressYourDetailsCancelButton() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(YourDetailsCancel_Button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(YourDetailsCancel_Button);
    }

    public void pressBackButtonForDetailsPage() {
        ElementActions.performTouchAction(driver).tap(BackForDetailsPage_Button);
    }

    public void pressCloseButtonForDetailsPage() {
        ElementActions.performTouchAction(driver).tap(CloseForDetailsPage_Button);
    }

    public boolean CheckDeletionRequestFormExternalPage() {
        return ElementActions.isElementDisplayed(driver, Chrome_driver);
    }

    public void pressCloseButtonForPersonalDetails() {
        ElementActions.performTouchAction(driver).tap(CloseForPersonalDetails_Button);
    }

    public void pressBackButtonForTheRequestInformationPage() {
        ElementActions.performTouchAction(driver).tap(BackForTheRequestInformationPage_Button);
    }

    public void pressCloseButtonForManagePersonalInformationSection() {
        ElementActions.performTouchAction(driver).tap(CloseForManagePersonalInformationSection_Button);
    }

    public void pressManagePersonalInformationSection() {
        ElementActions.performTouchAction(driver).tap(ManagePersonalInformation_Section);
    }

    public By getCheckSubjectAccessRequestFormPdfIsOpened() {
        return SubjectAccessRequestFormPdfIsOpened;
    }

    public void goBackToTheRequestInformationPage() {
        driver.navigate().back();
    }

    public void pressManagePersonalInformationEditButton() {
        ElementActions.performTouchAction(driver).tap(ManagePersonalInformationEdit_Button);
    }

    public void pressMarketingPreferencesSection() {
        ElementActions.performTouchAction(driver).tap(MarketingPreferences_Section);
    }

    public void pressDeletionRequestForm() {
        ElementActions.performTouchAction(driver).tap(DeletionRequestForm_Button);
    }

    public void pressYourDetailsEditButton() {
        ElementActions.performTouchAction(driver).swipeElementIntoView(YourDetailsEdit_Button, TouchActions.SwipeDirection.UP);
        ElementActions.performTouchAction(driver).tap(YourDetailsEdit_Button);
    }

    public By getCheckAccountOverlay() {
        return AccountOverlay;
    }

    public By getCheckYourDetailsPageHeader() {
        return YourDetailsPageHeader;
    }

    public By getCheckYourDetailsPageContent() {
        return YourDetailsPageContent;
    }

    public By getCheckManagePersonalInformationEditContent() {
        return ManagePersonalInformationEditContent;
    }

    public void pressDownloadDataRequestForm() {
        ElementActions.performTouchAction(driver).tap(DownloadDataRequestForm_Button);
    }

    public void pressPersonalDetailsSection() {
        ElementActions.performTouchAction(driver).tap(PersonalDetailsSection);
    }

    public void pressAccountSettingOption() {
        ElementActions.performTouchAction(driver).tap(AccountSettingOption);
    }

    public By getCheckAccountSettingsPageHeader() {
        return AccountSettingsPageHeader;
    }

    public void pressMyRecordsHeaderCloseButton() {
        ElementActions.performTouchAction(driver).tap(MyRecordsHeaderClose_Button);
    }

    public By getCheckManagePersonalInformationPageContent() {
        return ManagePersonalInformationPageContent;
    }

    public By getCheckPersonalDetailsPageContent() {
        return PersonalDetailsPageContent;
    }

    public By getCheckManagePersonalInformationPageHeader() {
        return ManagePersonalInformationPageHeader;
    }

    public void goBackToMyRecordsPage() {
        ElementActions.performTouchAction(driver).tap(BackToMyRecordsPage);
    }

    public void pressMyRecordsOption() {
        ElementActions.performTouchAction(driver).tap(MyRecordsOption_Button);
    }

    public By getCheckFirstLetterAttachmentsLink() {
        return FirstLetterAttachmentsLink;
    }

    public By getCheckLetterIsOpenedAsPdfDocument() {
        return LetterIsOpenedAsPdfDocument;
    }

    public void pressRateUsOption() {
        ElementActions.performTouchAction(driver).tap(RateUsOption);
    }

    public void pressCloseButtonInPrivacy() {
        ElementActions.performTouchAction(driver).tap(CloseInPrivacy_Button);
    }

    public By getCheckOurPrivacyHeaderWithCloseButton() {
        return OurPrivacyHeader;
    }

    public void pressFirstLetterAttachmentsLink() {
        ElementActions.performTouchAction(driver).tap(FirstLetterAttachmentsLink);
    }

    public void pressOurPrivacyLink() {
        ElementActions.performTouchAction(driver).tap(OurPrivacyLink);
    }

    public void chooseAppToOpenLetterWith() {
        ElementActions.performTouchAction(driver).tap(AppToOpenLetterWith);
    }

    public By getCheckThatExistsAtLeastOneLetter() {
        return ThatExistsAtLeastOneLetter;
    }

    public By getCheckMyRecordsPageHeader() {
        return MyRecordsPageHeader;
    }

    public By getCheckAvailableTabOptions() {
        return AvailableTabOptions;
    }

    public void pressLettersTabOption() {
        ElementActions.performTouchAction(driver).tap(LettersTabOption);
    }

    public void pressFirstLetter() {
        ElementActions.performTouchAction(driver).tap(ThatExistsAtLeastOneLetter);
    }

    public By getCheckOrdersArea() {
        return OrdersArea;
    }

    public By getCheckPersonalDetailsPageHeader() {
        return PersonalDetailsPageHeader;
    }

    public By getCheckAccountSettingsSection() {
        return AccountSettingsSection;
    }

    public By getCheckPersonalDetailsSection() {
        return PersonalDetailsSection;
    }

    public By getCheckAppSettingsSection() {
        return AppSettingsSection;
    }

    public void pressCloseButton() {
        ElementActions.performTouchAction(driver).tap(Close_Button);
    }

    public void pressAccountNameAndEmailOption() {
        ElementActions.performTouchAction(driver).tap(EmailOption_Button);
    }

    public By getCheckAccountNameAndEmailPageHeader() {
        return EmailPageHeader;
    }

    public By getCheckAccountNameAndEmailPageContent() {
        return EmailInputField;
    }

    public void fillEmailInputField() {
        ElementActions.type(driver, EmailInputField, "Test@gmail.com");
    }

    public void pressAccountHeaderCloseButton() {
        ElementActions.performTouchAction(driver).tap(AccountHeaderClose_Button);
    }

    public void fillAccountNameField() {
        ElementActions.type(driver, AccountNameField, "Test@gmail.com");
    }

    public void pressAccountHeaderBackChevron() {
        ElementActions.performTouchAction(driver).tap(HeaderBackChevron_Button);
    }

    public void pressBillingDetailsOption() {
        ElementActions.performTouchAction(driver).tap(BillingDetailsOption);
    }

    public By getCheckBillingDetailsPageHeader() {
        return BillingDetailsPageHeader;
    }

    public By getCheckBillingDetailsPageContent() {
        return DetailsPageContent;
    }

    public void pressBillingDetailsHeaderCloseButton() {
        ElementActions.performTouchAction(driver).tap(DetailsHeaderClose_Button);
    }

    public void pressAppPermissionsOption() {
        ElementActions.performTouchAction(driver).tap(AppPermissionsOption);
    }

    public By getCheckBillingDetailsBillingAddressSection() {
        return DetailsPageContent;
    }

    public By getCheckBillingDetailsBillingPreferencesSection() {
        return DetailsBillingPreferencesSection;
    }

    public void pressEnterAddressManuallyLink() {
        ElementActions.performTouchAction(driver).tap(EnterAddressManuallyLink_Button);
    }

    public By getCheckBillingAddressSectionFieldsForManualAddress() {
        return AddressSectionFieldsForManualAddress;
    }

    public void pressSearchForYourAddressLink() {
        ElementActions.performTouchAction(driver).tap(SearchForYourAddressLink_Button);
    }
}

