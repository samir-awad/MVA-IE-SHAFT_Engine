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
    private By EmailOption_Button;
    private By EmailPageHeader;
    private By EmailInputField;
    private By SaveButtonBecomesEnabled;
    private By HeaderBackChevron_Button;
    private By BillingDetailsOption;
    private By DetailsPageHeader;
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

    public Account(WebDriver driver) {

        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android"))
        {
            AccountTry_Button = new MobileBy.ByAccessibilityId("id_tray_menu_item_icon_Account");
            AccountOverlay = new MobileBy.ByAccessibilityId("STundefinedMainTitle");
            AccountSettingOption = new MobileBy.ByAccessibilityId("id_account_overlay_Settings_title");
            AccountSettingsPageHeader = new MobileBy.ByAccessibilityId("id_header_title_Settings");
            AccountSettingsSection = new MobileBy.ByAccessibilityId("id_account_settings_title");
            PersonalDetailsSection = new MobileBy.ByAccessibilityId("id_personal_details_title");
            AppSettingsSection = new MobileBy.ByAccessibilityId("id_app_settings_title");
            Close_Button = new MobileBy.ByAccessibilityId("Close button");
            EmailOption_Button= By.xpath("(//android.widget.TextView[@content-desc=\"id_account_settings_item_title\"])[1]");
            EmailPageHeader = new MobileBy.ByAccessibilityId("id_header_title_Account_name_&_email");
            EmailInputField = new MobileBy.ByAccessibilityId("id_account_and_email_email_input");
            SaveButtonBecomesEnabled = new MobileBy.ByAccessibilityId("Button");
            HeaderBackChevron_Button = new MobileBy.ByAccessibilityId("id_header_back_arrow");
            BillingDetailsOption = By.xpath("(//android.widget.TextView[@content-desc=\"id_account_settings_item_title\"])[2]");
            DetailsPageHeader = new MobileBy.ByAccessibilityId("id_header_title_Billing_details");
            DetailsPageContent = new MobileBy.ByAccessibilityId("id_billing_address_content_card_title");
            DetailsHeaderClose_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"Close button\"])[2]");
            DetailsBillingPreferencesSection  = new MobileBy.ByAccessibilityId("id_billing_preferences_content_card_title");
            EnterAddressManuallyLink_Button = new MobileBy.ByAccessibilityId("id_billing_address_address_mode_text");
            AddressSectionFieldsForManualAddress = new MobileBy.ByAccessibilityId("id_billing_address_content_card_title");
            SearchForYourAddressLink_Button = new MobileBy.ByAccessibilityId("id_billing_address_address_mode_text");
            AccountNameField = new MobileBy.ByAccessibilityId("id_account_and_email_name_input");
            AccountHeaderClose_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[2]");
            MyRecordsOption_Button = new MobileBy.ByAccessibilityId("id_account_overlay_My Records_title");
            MyRecordsPageHeader = new MobileBy.ByAccessibilityId("id_header_title_My_Records");
            AvailableTabOptions = By.xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TabWidget");
            OrdersArea = By.id("orders");
            LettersTabOption = By.id("Letter");
            ThatExistsAtLeastOneLetter = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[1]");
            FirstLetterAttachmentsLink = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[7]/android.widget.Button");
            AppToOpenLetterWith = By.xpath("");
            LetterIsOpenedAsPdfDocument = By.xpath("");
            BackToMyRecordsPage = By.xpath("");
            MyRecordsHeaderClose_Button=new MobileBy.ByAccessibilityId("id_header_close_icon");
            OurPrivacyLink = new MobileBy.ByAccessibilityId("id_account_overlay_our_privacy");
            OurPrivacyHeader = new MobileBy.ByAccessibilityId("id_header_title_Our_Privacy");
            CloseInPrivacy_Button = new MobileBy.ByAccessibilityId("id_header_close_icon");
            AppPermissionsOption = By.xpath("(//android.widget.TextView[@content-desc=\"id_app_settings_item_title\"])[1]");
            RateUsOption = By.xpath("(//android.widget.TextView[@content-desc=\"id_app_settings_item_title\"])[2]");
            PersonalDetailsPageHeader=new MobileBy.ByAccessibilityId("id_header_title_Personal_details");
            PersonalDetailsPageContent = new MobileBy.ByAccessibilityId("id_personal_details_card_your_details_title");
            BackForPersonalDetails_Button = new MobileBy.ByAccessibilityId("id_header_back_arrow");
            CloseForPersonalDetails_Button = By.xpath("(//android.widget.ImageView[@content-desc=\"id_header_close_icon\"])[2]");

        } else
            {
        }


    }

    public By getSaveButtonBecomesEnabled() {
        return SaveButtonBecomesEnabled;
    }
    public void pressAccountTrayMenuOption()
    {
        ElementActions.performTouchAction(driver).tap(AccountTry_Button);
    }
    public void pressBackButtonForPersonalDetails(){
        ElementActions.performTouchAction(driver).tap(BackForPersonalDetails_Button);
    }
    public void pressCloseButtonForPersonalDetails(){
        ElementActions.performTouchAction(driver).tap(CloseForPersonalDetails_Button);
    }
    public By getCheckAccountOverlay(){
        return AccountOverlay;
    }
    public void pressPersonalDetailsSection(){
        ElementActions.performTouchAction(driver).tap(PersonalDetailsSection);
    }
    public void pressAccountSettingOption()
    {
        ElementActions.performTouchAction(driver).tap(AccountSettingOption);
    }
    public By getCheckAccountSettingsPageHeader(){
        return AccountSettingsPageHeader;
    }
    public void pressMyRecordsHeaderCloseButton(){
        ElementActions.performTouchAction(driver).tap(MyRecordsHeaderClose_Button);
    }
    public By getCheckPersonalDetailsPageContent(){
        return PersonalDetailsPageContent;
    }

    public void goBackToMyRecordsPage(){
        ElementActions.performTouchAction(driver).tap(BackToMyRecordsPage);
    }
    public void pressMyRecordsOption(){
        ElementActions.performTouchAction(driver).tap(MyRecordsOption_Button);
    }
    public By getCheckFirstLetterAttachmentsLink(){
        return FirstLetterAttachmentsLink;
    }
    public By getCheckLetterIsOpenedAsPdfDocument(){
        return LetterIsOpenedAsPdfDocument;
    }
    public void pressRateUsOption(){
        ElementActions.performTouchAction(driver).tap(RateUsOption);
    }
    public void pressCloseButtonInPrivacy(){
        ElementActions.performTouchAction(driver).tap(CloseInPrivacy_Button);
    }
    public By getCheckOurPrivacyHeaderWithCloseButton(){
        return OurPrivacyHeader;
    }
    public void pressFirstLetterAttachmentsLink(){
        ElementActions.performTouchAction(driver).tap(FirstLetterAttachmentsLink);
    }
    public void pressOurPrivacyLink(){
        ElementActions.performTouchAction(driver).tap(OurPrivacyLink);
    }
    public void chooseAppToOpenLetterWith(){
        ElementActions.performTouchAction(driver).tap(AppToOpenLetterWith);
    }
    public By getCheckThatExistsAtLeastOneLetter(){
        return ThatExistsAtLeastOneLetter;
    }
    public By getCheckMyRecordsPageHeader(){
        return MyRecordsPageHeader;
    }
    public By getCheckAvailableTabOptions(){
        return AvailableTabOptions;
    }
    public void  pressLettersTabOption(){
        ElementActions.performTouchAction(driver).tap(LettersTabOption);
    }
    public void pressFirstLetter(){
        ElementActions.performTouchAction(driver).tap(ThatExistsAtLeastOneLetter);
    }
    public By getCheckOrdersArea(){
        return OrdersArea;
    }
    public By getCheckPersonalDetailsPageHeader(){
        return PersonalDetailsPageHeader;
    }

    public By getCheckAccountSettingsSection(){
        return AccountSettingsSection;
    }
    public By getCheckPersonalDetailsSection(){
        return  PersonalDetailsSection;
    }
    public By getCheckAppSettingsSection(){
        return AppSettingsSection;
    }
    public void pressCloseButton(){
        ElementActions.performTouchAction(driver).tap(Close_Button);
    }

    public void  pressAccountNameAndEmailOption(){
        ElementActions.performTouchAction(driver).tap(EmailOption_Button);
    }
    public By getCheckAccountNameAndEmailPageHeader(){
        return EmailPageHeader;
    }
    public By getCheckAccountNameAndEmailPageContent(){
        return EmailInputField;
    }
    public void fillEmailInputField(){
        ElementActions.type(driver,EmailInputField,"Test@gmail.com");
    }
    public void pressAccountHeaderCloseButton(){
        ElementActions.performTouchAction(driver).tap(AccountHeaderClose_Button);
    }

    public void fillAccountNameField(){
        ElementActions.type(driver,AccountNameField,"Test@gmail.com");
    }
    public void pressAccountHeaderBackChevron(){
        ElementActions.performTouchAction(driver).tap(HeaderBackChevron_Button);
    }
    public void pressBillingDetailsOption(){
        ElementActions.performTouchAction(driver).tap(BillingDetailsOption);
    }
    public By getCheckBillingDetailsPageHeader(){
        return DetailsPageHeader;
    }

    public By getCheckBillingDetailsPageContent(){
        return DetailsPageContent;
    }
    public void pressBillingDetailsHeaderCloseButton(){
        ElementActions.performTouchAction(driver).tap(DetailsHeaderClose_Button);
    }
    public void pressAppPermissionsOption(){
        ElementActions.performTouchAction(driver).tap(AppPermissionsOption);
    }

    public By getCheckBillingDetailsBillingAddressSection(){
        return DetailsPageContent;
    }
    public By getCheckBillingDetailsBillingPreferencesSection(){
        return DetailsBillingPreferencesSection;
    }
    public void pressEnterAddressManuallyLink(){
        ElementActions.performTouchAction(driver).tap(EnterAddressManuallyLink_Button);
    }
    public By getCheckBillingAddressSectionFieldsForManualAddress(){
        return AddressSectionFieldsForManualAddress;
    }
    public void  pressSearchForYourAddressLink(){
        ElementActions.performTouchAction(driver).tap(SearchForYourAddressLink_Button);
    }
}

