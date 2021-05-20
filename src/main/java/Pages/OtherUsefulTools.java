package Pages;

        import com.helger.commons.state.IEnabledIndicator;
        import com.mysql.cj.xdevapi.Schema;
        import com.shaft.gui.element.ElementActions;
        import com.shaft.gui.element.TouchActions;
        import com.shaft.validation.Verifications;
        import groovy.util.ObservableSet;
        import io.appium.java_client.MobileBy;
        import jdk.jfr.Enabled;
        import net.bytebuddy.asm.Advice;
        import org.apache.xmlbeans.impl.xb.xsdschema.Element;
        import org.aspectj.apache.bcel.classfile.annotation.ElementValue;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.testng.Assert;
        import org.testng.asserts.Assertion;

        import java.security.Key;

public class OtherUsefulTools {
    private final WebDriver driver;
    private By WebtextPageHeader_Text;
    private By WebtextHeaderClose_Button;
    private By Recipients_Text;
    private By WebTextInputMessage_Text;
    private By Send_Button;
    private By WebtextInternationalToast_Text;
    private By WebtextInternationalConfirm_Button;
    private By RemainingCharactersText;
    private By Change_Button;
    private By SelectTimeOption_Button;
    private By Select_Button;
    private By SetMessageSendTime_Title;
    private By ChangeDate_Spinner;
    private By SelectedNewDateSpinner_Item;
    private By SendMessageNow_Text;
    private By NacRequestPageHeader_Text;
    private By FewThingsFirst_Title;
    private By FewThingsFirstContent1_Title;
    private By FewThingsUnlockedDescription_Text;
    private By FewThingsFirstContent2_Title;
    private By FewThingsElegibleDescriptionBillPay_Text;
    private By FewThingsElegibleRule0_Text;
    private By FewThingsElegibleBillPayRule0_Text;
    private By FewThingsElegibleBillPayRule1_Text;
    private By FewThingsElegibleBillPayRule2_Text;
    private By FewThingsFirstContent2_Link;
    private By NacFewThingsFirstContinue_Button;
    private By RequestNAC_Title;
    private By NACRequestContentCard_Title;
    private By FewThingsFirstUnlocked_Title;
    private By FewThingsFirstIMEI_Input;
    private By NACRequest_Button;
    private By NACRequestCancelFlow_Button;
    private By InvalidIMEIMessage_Text;
    private By AccessContactsPermissionAllow_button;


    public By getWebtextPageHeader_Text() {
        return WebtextPageHeader_Text;
    }

    public By getWebtextInternationalToast() {
        return WebtextInternationalToast_Text;
    }

    public OtherUsefulTools(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            WebtextPageHeader_Text = new MobileBy.ByAccessibilityId("id_dashboard_essentials_change_plan_label");
            WebtextHeaderClose_Button = new MobileBy.ByAccessibilityId("id_header_close_icon");
            Recipients_Text = new MobileBy.ByAccessibilityId("id_dashboard_essentials_mccm_upgrades_description_label");
            WebTextInputMessage_Text = new MobileBy.ByAccessibilityId("id_webtext_input_message");
            Send_Button = new MobileBy.ByAccessibilityId("id_webtext_button_send");
            WebtextInternationalToast_Text = new MobileBy.ByAccessibilityId("id_webtext_international_title");
            WebtextInternationalConfirm_Button = new MobileBy.ByAccessibilityId("id_webtext_international_confirm_button");
            RemainingCharactersText = By.xpath("(//android.widget.TextView[@content-desc=\"id_webtext_message_text\"])[2]");
            Change_Button = By.xpath("(//android.widget.TextView[@content-desc=\"id_webtext_sending_options_title\"])[3]");
            SelectTimeOption_Button = By.xpath("\t(//android.widget.TextView[@content-desc=\"id_webtext_options_hours_item_text\"])[2]");
            Select_Button = new MobileBy.ByAccessibilityId("id_webtext_options_select_button");
            SetMessageSendTime_Title = new MobileBy.ByAccessibilityId("id_webtext_options_title");
            ChangeDate_Spinner = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Spinner");
            SelectedNewDateSpinner_Item = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]");
            SendMessageNow_Text = By.xpath("(//android.widget.TextView[@content-desc=\"id_webtext_sending_options_title\"])[2]");
            NacRequestPageHeader_Text = new MobileBy.ByAccessibilityId("id_dashboard_discover_card_image");
            FewThingsFirst_Title= new MobileBy.ByAccessibilityId("id_nac_request_content_card_title");
            FewThingsFirstContent1_Title=new MobileBy.ByAccessibilityId("id_dashboard_essentials_title");
            FewThingsUnlockedDescription_Text = new MobileBy.ByAccessibilityId("id_a_few_things_unlocked_description");
            FewThingsFirstContent2_Title= new MobileBy.ByAccessibilityId("id_a_few_things_elegible_title");
            FewThingsElegibleDescriptionBillPay_Text= new MobileBy.ByAccessibilityId("id_a_few_things_elegible_description_bill_pay");
            FewThingsElegibleRule0_Text= new MobileBy.ByAccessibilityId("id_a_few_things_elegible_rule0");
            FewThingsElegibleBillPayRule0_Text= new MobileBy.ByAccessibilityId("id_a_few_things_elegible_bill_pay_rule0");
            FewThingsElegibleBillPayRule1_Text= new MobileBy.ByAccessibilityId("id_a_few_things_elegible_bill_pay_rule1");
            FewThingsElegibleBillPayRule2_Text= new MobileBy.ByAccessibilityId("id_a_few_things_elegible_bill_pay_rule2");
            FewThingsFirstContent2_Link= new MobileBy.ByAccessibilityId("id_a_few_things_first_FAQs_bill_pay");
            NacFewThingsFirstContinue_Button= new MobileBy.ByAccessibilityId("id_nac_request_start_flow_button");
            RequestNAC_Title = new MobileBy.ByAccessibilityId("id_header_title_Request_NAC");
            NACRequestContentCard_Title = new MobileBy.ByAccessibilityId("id_nac_request_content_card_title");
            FewThingsFirstUnlocked_Title = new MobileBy.ByAccessibilityId("id_a_few_things_first_unlocked_title");
            FewThingsFirstIMEI_Input = new MobileBy.ByAccessibilityId("id_a_few_things_first_imei_input");
            NACRequest_Button = new MobileBy.ByAccessibilityId("id_nac_request_button");
            NACRequestCancelFlow_Button = new MobileBy.ByAccessibilityId("id_nac_request_cancel_flow_button");
            InvalidIMEIMessage_Text = By.xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]");
            AccessContactsPermissionAllow_button= By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]");
        } else {
        }
    }

    public boolean checkWebtextPageHeader() {
        return ElementActions.isElementDisplayed(driver, WebtextPageHeader_Text);
    }

    public By getRecipients_Text() {
        return Recipients_Text;
    }

    public By getWebTextInputMessage_Text() {
        return WebTextInputMessage_Text;
    }

    public By getSend_Button() {
        return Send_Button;
    }

    public boolean checkWebTextForm() {
        boolean Recipients = ElementActions.isElementDisplayed(driver, Recipients_Text);
        boolean InputMessage = ElementActions.isElementDisplayed(driver, WebTextInputMessage_Text);
        boolean Send = ElementActions.isElementDisplayed(driver, Send_Button);
        boolean result;
        if (Recipients && InputMessage && Send)
            result = true;
        else
            result = false;
        return result;
    }

    public void fillOutTheWebtextForm() {
        ElementActions.type(driver, Recipients_Text, "0871700924");
        ElementActions.type(driver, Recipients_Text, "Hello everyone :) ");

    }

    public void fillOutTheWebtextFormWithMoreThanOneRecipient() {
        ElementActions.type(driver, Recipients_Text, "0871700924 0879512912");
        ElementActions.type(driver, Recipients_Text, "Hello everyone :) ");

    }

    public void fillInTheMessageWithMoreThanTheAllowedCharacters() {
        ElementActions.type(driver, Recipients_Text, "0871700924");
        ElementActions.type(driver, Recipients_Text, "Disneyland Park, originally Disneyland, is the first of two theme parks built at the Disneyland Resort in Anaheim, California, which opened on July 17, 1955. It is the only theme park designed and built to completion under the direct supervision of Walt Disney. It was originally the only attraction on the property; its official name was changed to Disneyland Park to distinguish it from the expanding complex in the 1990s. It was the first Disney theme park. It has undergone expansions and major renovations.");

    }

    public void pressSendButton() {
        ElementActions.performTouchAction(driver).tap(Send_Button);
    }

    public boolean WebtextInternationalToast() {
        return ElementActions.isElementDisplayed(driver, WebtextInternationalToast_Text);
    }

    public void pressWebtextInternationalConfirmButton() {
        ElementActions.performTouchAction(driver).tap(WebtextInternationalConfirm_Button);
    }

    public void checkRemainingCharactersText() {
        Assert.assertEquals(RemainingCharactersText, "459/459 (3 messages)");

    }

    public void fillInRecipient() {
        ElementActions.type(driver, Recipients_Text, "0871700924");
    }

    public void fillInMessage() {
        ElementActions.type(driver, Recipients_Text, "Disneyland Park, originally Disneyland, is the first of two theme parks built at the Disneyland Resort in Anaheim, California, which opened on July 17, 1955. It is the only theme park designed and built to completion under the direct supervision of Walt Disney. It was originally the only attraction on the property; its official name was changed to Disneyland Park to distinguish it from the expanding complex in the 1990s. It was the first Disney theme park. It has undergone expansions and major renovations.");
    }

    public boolean checkSendButtonStillDisabled() {
            if (ElementActions.isElementClickable(driver, Send_Button)) {
                return false;
            } else
                return true;
    }

    public void pressSendingOptionsChangeButton() {
        ElementActions.performTouchAction(driver).tap(Change_Button);
    }

    public boolean checkSetSendTimeOverlay() {
        return ElementActions.isElementDisplayed(driver, SetMessageSendTime_Title);
    }

    public void chooseAnotherTime(){
        ElementActions.performTouchAction(driver).tap(ChangeDate_Spinner);
        driver.findElement(By.xpath("SelectedNewDateSpinner_Item")).click();
        ElementActions.performTouchAction(driver).tap(SelectTimeOption_Button);
        ElementActions.performTouchAction(driver).tap(Select_Button);

    }

    public boolean checkNacFewThingsFirstPageContent(){
        if (ElementActions.isElementDisplayed(driver, FewThingsFirst_Title) &&
                ElementActions.isElementDisplayed(driver, FewThingsFirstContent1_Title) &&
                ElementActions.isElementDisplayed(driver, FewThingsUnlockedDescription_Text) &&
                ElementActions.isElementDisplayed(driver, FewThingsFirstContent2_Title) &&
                ElementActions.isElementDisplayed(driver, FewThingsElegibleDescriptionBillPay_Text) &&
                ElementActions.isElementDisplayed(driver, FewThingsElegibleRule0_Text) &&
                ElementActions.isElementDisplayed(driver, FewThingsElegibleBillPayRule0_Text) &&
                ElementActions.isElementDisplayed(driver, FewThingsElegibleBillPayRule1_Text) &&
                ElementActions.isElementDisplayed(driver, FewThingsElegibleBillPayRule2_Text) &&
                ElementActions.isElementDisplayed(driver, FewThingsFirstContent2_Link) &&
                ElementActions.isElementDisplayed(driver, NacFewThingsFirstContinue_Button))
            return true;
        else
            return false;
    }

    public void pressNacFewThingsFirstContinueButton(){
        ElementActions.performTouchAction(driver).tap(NacFewThingsFirstContinue_Button);
    }

    public boolean checkNacRequestWithDevicePageContent(){
        if (ElementActions.isElementDisplayed(driver, RequestNAC_Title) &&
                ElementActions.isElementDisplayed(driver, NACRequestContentCard_Title) &&
                ElementActions.isElementDisplayed(driver, FewThingsFirstUnlocked_Title) &&
                ElementActions.isElementDisplayed(driver, FewThingsFirstIMEI_Input) &&
                ElementActions.isElementDisplayed(driver, NACRequest_Button) &&
                ElementActions.isElementDisplayed(driver, NACRequestCancelFlow_Button))
            return true;
        else
            return false;
    }

    public void addAnInvalidImei(){
        ElementActions.type(driver, FewThingsFirstIMEI_Input , "123abc");
        ElementActions.keyPress(driver, FewThingsFirstIMEI_Input, "Enter");
    }

    public void addAValidImeiButNotExistingInTheSystem(){
        ElementActions.type(driver, FewThingsFirstIMEI_Input , "2720180139982648935301190402004372");
        ElementActions.keyPress(driver, FewThingsFirstIMEI_Input, "Enter");
    }

    public boolean checkErrorMessageAndThatNacRequestContinueButtonStillDisabled(){

        return ElementActions.isElementDisplayed(driver, InvalidIMEIMessage_Text)
                && !ElementActions.isElementClickable(driver, NACRequest_Button );

    }

    public void clearTheNACRequestInput() {
        driver.findElement(FewThingsFirstIMEI_Input).clear();
    }

    public void pressWebTextHeaderCloseButton(){
        ElementActions.performTouchAction(driver).tap(WebtextHeaderClose_Button);
    }

    public void acceptAccessYourContactsPermissions(){
        ElementActions.performTouchAction(driver).tap(AccessContactsPermissionAllow_button);
    }
}

