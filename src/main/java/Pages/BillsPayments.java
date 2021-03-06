package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BillsPayments {

    private WebDriver driver;
    private static By CurrentSpendLastBillTitle;
    private static By Bills_Payments_Button;
    private static By BillsPaymentTitle;
    private static By CloseBTN;
    private static By Download_Button;
    private static By MakePayment_Button;
    private static By MakeAdvancePayment_button;
    private static By MakeAPaymentHeader;
    private static By PaymentFirstBill;
    private static By PaymentAmountField;
    private static By PaymentMethod;
    private static By Edit_Button;
    private static By Payment_Button;
    private static By VisaData;
    private static By UseSelectedCard_Button;
    private static By VestaField;
    private static By NewCardAndSaveItForLater_Button;
    private static By NewCardWithoutSaving_Button;
    private static By AccountSettings_Text;
    private static By PaymentMethod_Text;
    private static By CreditCardAsRecurringPayment0_Title;
    private static By CreditCardAsRecurringPaymentSub_Title;
    private static By CreditCardAsRecurringPaymentSaved_Tab;
    private static By CreditCardAsRecurringPaymentDirectDebit_Tab;
    private static By AccountHolder_Text;
    private static By Iban_Text;
    private static By NoneSavedCards_Text;
    private static By NoPaymentMethod_Text;
    private static By AddNewCard_Button;
    private static By AddNewCard_Overlay;
    private static By AddNewCardOverlayClose_Button;
    private static By AddNewCardOverlayNo_Button;
    private static By AddNewCardOverlayContinue_Button;
    private static By UseThisCard_Button;
    private static By UseThisCardOverlay_Text;
    private static By ChangeYourCardOverlayClose_Button;
    private static By ChangeYourCardOverlayNo_Button;
    private static By ChangeYourCardOverlayContinue_Button;
    private static By CheckSavedCardContent0_Text;
    private static By CheckSavedCardContent1_Text;

    public By getCurrentSpendLastBillTitle() {
        return CurrentSpendLastBillTitle;
    }

    public By getBills_Payments_Button() {
        return Bills_Payments_Button;
    }

    public By getCloseBTN() {
        return CloseBTN;
    }

    public By getDownload_Button() {
        return Download_Button;
    }

    public By getMakePayment_Button() {
        return MakePayment_Button;
    }

    public By getMakeAdvancePayment_button() {
        return MakeAdvancePayment_button;
    }

    public By getMakeAPaymentHeader() {
        return MakeAPaymentHeader;
    }

    public By getPaymentFirstBill() {
        return PaymentFirstBill;
    }

    public By getPaymentAmountField() {
        return PaymentAmountField;
    }

    public By getPaymentMethod() {
        return PaymentMethod;
    }

    public By getEdit_Button() {
        return Edit_Button;
    }

    public By getPayment_Button() {
        return Payment_Button;
    }

    public By getVisaData() {
        return VisaData;
    }

    public By getUseSelectedCard_Button() {
        return UseSelectedCard_Button;
    }

    public By getNewCardAndSaveItForLater_Button() {
        return NewCardAndSaveItForLater_Button;
    }

    public By getNewCardWithoutSaving_Button() {
        return NewCardWithoutSaving_Button;
    }

    public By getAccountSettings_Text() {
        return AccountSettings_Text;
    }

    public By getPaymentMethod_Text() {
        return PaymentMethod_Text;
    }

    public By getCreditCardAsRecurringPayment0_Title() {
        return CreditCardAsRecurringPayment0_Title;
    }

    public By getCreditCardAsRecurringPaymentSub_Title() {
        return CreditCardAsRecurringPaymentSub_Title;
    }

    public By getCreditCardAsRecurringPaymentSaved_Tab() {
        return CreditCardAsRecurringPaymentSaved_Tab;
    }

    public By getCreditCardAsRecurringPaymentDirectDebit_Tab() {
        return CreditCardAsRecurringPaymentDirectDebit_Tab;
    }

    public By getAccountHolder_Text() {
        return AccountHolder_Text;
    }

    public By getIban_Text() {
        return Iban_Text;
    }

    public By getNoneSavedCards_Text() {
        return NoneSavedCards_Text;
    }

    public By getNoPaymentMethod_Text() {
        return NoPaymentMethod_Text;
    }

    public By getAddNewCard_Button() {
        return AddNewCard_Button;
    }

    public By getAddNewCard_Overlay() {
        return AddNewCard_Overlay;
    }

    public By getAddNewCardOverlayClose_Button() {
        return AddNewCardOverlayClose_Button;
    }

    public By getAddNewCardOverlayNo_Button() {
        return AddNewCardOverlayNo_Button;
    }

    public By getAddNewCardOverlayContinue_Button() {
        return AddNewCardOverlayContinue_Button;
    }

    public By getUseThisCard_Button() {
        return UseThisCard_Button;
    }

    public By getUseThisCardOverlay_Text() {
        return UseThisCardOverlay_Text;
    }

    public By getChangeYourCardOverlayClose_Button() {
        return ChangeYourCardOverlayClose_Button;
    }

    public By getChangeYourCardOverlayNo_Button() {
        return ChangeYourCardOverlayNo_Button;
    }

    public By getChangeYourCardOverlayContinue_Button() {
        return ChangeYourCardOverlayContinue_Button;
    }

    public By getCheckSavedCardContent0_Text() {
        return CheckSavedCardContent0_Text;
    }

    public By getCheckSavedCardContent1_Text() {
        return CheckSavedCardContent1_Text;
    }

    public By getInvalidIbanOverlay_Title() {
        return InvalidIbanOverlay_Title;
    }

    private static By InvalidIbanOverlay_Title;

    public By getBillsPaymentTitle() {
        return BillsPaymentTitle;
    }

    public BillsPayments(WebDriver driver) {

        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {

            CurrentSpendLastBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_details_title");
            Bills_Payments_Button = By.xpath("//android.view.ViewGroup[@content-desc=\"Button\"]");
            BillsPaymentTitle = new MobileBy.ByAccessibilityId("id_header_title_Bills_&_Payments");
            CloseBTN = new MobileBy.ByAccessibilityId("id_header_close_icon");
            Download_Button = new MobileBy.ByAccessibilityId("Download March 2021 bill");
            MakePayment_Button = By.xpath("(//android.view.ViewGroup[@content-desc=\"Button\"])[1]");
            MakeAdvancePayment_button = new MobileBy.ByAccessibilityId("Make advance payment");
            MakeAPaymentHeader = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_title");
            PaymentFirstBill = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_bill_8_value");
            PaymentAmountField = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_amount_input");
            PaymentMethod = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_payment_method_title");
            Edit_Button = By.xpath("//android.view.ViewGroup[@content-desc=\"Select or add a card to pay ???48.67\"])[2]");
            Payment_Button = new MobileBy.ByAccessibilityId("Make payment");
            VisaData = new MobileBy.ByAccessibilityId("Visa ending in 3363. Selected");
            UseSelectedCard_Button = new MobileBy.ByAccessibilityId("Use selected card");
            VestaField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View");
            NewCardAndSaveItForLater_Button = new MobileBy.ByAccessibilityId("Button. Navigates to add card screen.");
            NewCardWithoutSaving_Button = new MobileBy.ByAccessibilityId("Button. Navigates to payment screen");
            //DirectDebits
            AccountSettings_Text = new MobileBy.ByAccessibilityId("id_dashboard_my_usage_title");
            PaymentMethod_Text = new MobileBy.ByAccessibilityId("id_header_title_Payment_method");
            CreditCardAsRecurringPayment0_Title = new MobileBy.ByAccessibilityId("id_payment_method_header_title");
            CreditCardAsRecurringPaymentSub_Title = new MobileBy.ByAccessibilityId("id_payment_method_header_sub_title1");
            CreditCardAsRecurringPaymentSaved_Tab = new MobileBy.ByAccessibilityId("id_payment_method_list_selector_text_Saved Cards");
            CreditCardAsRecurringPaymentDirectDebit_Tab = new MobileBy.ByAccessibilityId("id_payment_method_list_selector_text_Direct Debit");
            AccountHolder_Text = By.xpath("(//android.widget.EditText[@content-desc=\"id_account_and_email_name_input\"])[1]");
            Iban_Text = By.xpath("(//android.widget.EditText[@content-desc=\"id_account_and_email_name_input\"])[2]");
            NoneSavedCards_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_list_no_cards_info_text");
            NoPaymentMethod_Text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView");
            AddNewCard_Button = new MobileBy.ByAccessibilityId("id_add_new_card_button");
            AddNewCard_Overlay = new MobileBy.ByAccessibilityId("id_payment_method_add_card_description_main_text");
            AddNewCardOverlayClose_Button = By.xpath("//android.widget.ImageView[@content-desc=\"id_payment_method_add_card_overlay_close\"]");
            AddNewCardOverlayNo_Button = new MobileBy.ByAccessibilityId("id_payment_method_add_card_close_button");
            AddNewCardOverlayContinue_Button = new MobileBy.ByAccessibilityId("id_payment_method_add_card_continue_button");
            UseThisCard_Button = MobileBy.xpath("(//android.widget.Button[@content-desc=\\\"id_use_this_card_button\\\"])[1]");
            UseThisCardOverlay_Text = new MobileBy.ByAccessibilityId("id_payment_method_change_card_description_main_text");
            ChangeYourCardOverlayClose_Button = By.xpath("//android.widget.ImageView[@content-desc=\"id_payment_method_change_card_overlay_close\"]");
            ChangeYourCardOverlayNo_Button = new MobileBy.ByAccessibilityId("id_payment_method_change_card_close_button");
            ChangeYourCardOverlayContinue_Button = new MobileBy.ByAccessibilityId("id_payment_method_change_card_continue_button");
            CheckSavedCardContent0_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_item_description_cards_0");
            CheckSavedCardContent1_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_description_cards_0");
            InvalidIbanOverlay_Title = new MobileBy.ByAccessibilityId("id_payment_method_invalid_iban_overlay_title");


        } else {

            CurrentSpendLastBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_details_title");
            Bills_Payments_Button = new MobileBy.ByAccessibilityId("Bills & payments");
            BillsPaymentTitle = new MobileBy.ByAccessibilityId("id_header_title_Bills_&_Payments");
            CloseBTN = By.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            Download_Button = new MobileBy.ByAccessibilityId("Download March 2021 bill");
            MakePayment_Button = new MobileBy.ByAccessibilityId("Make a Payment");
            MakeAdvancePayment_button = new MobileBy.ByAccessibilityId("Make advance payment");
            MakeAPaymentHeader = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_title");
            PaymentFirstBill = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_bill_8_value");
            PaymentAmountField = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_amount_input");
            PaymentMethod = new MobileBy.ByAccessibilityId("Select or add a card to pay ???48.67");
            Edit_Button = new MobileBy.ByAccessibilityId("Select or add a card to pay ???48.67");
            Payment_Button = new MobileBy.ByAccessibilityId("Make payment");
            VisaData = new MobileBy.ByAccessibilityId("Visa ending in 3363. Selected");
            UseSelectedCard_Button = new MobileBy.ByAccessibilityId("Use selected card");
            VestaField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View");
            NewCardAndSaveItForLater_Button = new MobileBy.ByAccessibilityId("Button. Navigates to add card screen.");
            NewCardWithoutSaving_Button = new MobileBy.ByAccessibilityId("Button. Navigates to payment screen");
            //DirectDebits
            AccountSettings_Text = new MobileBy.ByAccessibilityId("id_header_title_Settings");
            PaymentMethod_Text = new MobileBy.ByAccessibilityId("Payment method");
            CreditCardAsRecurringPayment0_Title = new MobileBy.ByAccessibilityId("id_payment_method_header_title");
            CreditCardAsRecurringPaymentSub_Title = new MobileBy.ByAccessibilityId("id_payment_method_header_sub_title1");
            CreditCardAsRecurringPaymentSaved_Tab = By.xpath("(//XCUIElementTypeOther[@name=\"Saved Cards\"])[2]");
            CreditCardAsRecurringPaymentDirectDebit_Tab = By.xpath("(//XCUIElementTypeOther[@name=\"Direct Debit\"])[2]");
            AccountHolder_Text = By.xpath("(//XCUIElementTypeTextField[@name=\"id_account_and_email_name_input\"])[1]");
            Iban_Text = By.xpath("(//XCUIElementTypeTextField[@name=\"id_account_and_email_name_input\"])[2]");
            NoneSavedCards_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_list_no_cards_info_text");
            NoPaymentMethod_Text = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"You don't currently have a payment method set up.\"]");
            AddNewCard_Button = new MobileBy.ByAccessibilityId("id_add_new_card_button");
            AddNewCard_Overlay = new MobileBy.ByAccessibilityId("id_payment_method_add_card_description_main_text");
            AddNewCardOverlayClose_Button = By.xpath("//android.widget.ImageView[@content-desc=\"id_payment_method_add_card_overlay_close\"]");
            AddNewCardOverlayNo_Button = new MobileBy.ByAccessibilityId("id_payment_method_add_card_close_button");
            AddNewCardOverlayContinue_Button = new MobileBy.ByAccessibilityId("id_payment_method_add_card_continue_button");
            UseThisCard_Button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\\\"Use this card\\\"])[2]");
            UseThisCardOverlay_Text = new MobileBy.ByAccessibilityId("id_payment_method_change_card_description_main_text");
            ChangeYourCardOverlayClose_Button = By.xpath("//android.widget.ImageView[@content-desc=\"id_payment_method_change_card_overlay_close\"]");
            ChangeYourCardOverlayNo_Button = new MobileBy.ByAccessibilityId("id_payment_method_change_card_close_button");
            ChangeYourCardOverlayContinue_Button = new MobileBy.ByAccessibilityId("id_payment_method_change_card_continue_button");
            CheckSavedCardContent0_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_item_description_cards_0");
            CheckSavedCardContent1_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_description_cards_0");
            InvalidIbanOverlay_Title = new MobileBy.ByAccessibilityId("id_payment_method_invalid_iban_overlay_title");

        }
    }

    public boolean checkCurrentSpendOverlay() {

        return ElementActions.isElementDisplayed(driver, CurrentSpendLastBillTitle);
    }

    public void pressViewBillsAndPaymentsButton() {
        ElementActions.performTouchAction(driver).tap(Bills_Payments_Button);
    }

    public boolean checkBillsPaymentsHeader() {
        return ElementActions.isElementDisplayed(driver, BillsPaymentTitle);
    }

    public void pressCloseButtonInBillsPaymentsView() {
        ElementActions.performTouchAction(driver).tap(CloseBTN);
    }

    public void pressDownloadBillButton() {
        ElementActions.performTouchAction(driver).tap(Download_Button);
    }

    public void pressMakeAPaymentButton() {
        ElementActions.performTouchAction(driver).tap(MakePayment_Button);
    }

    public void pressMakeAdvancePaymentButton() {
        ElementActions.performTouchAction(driver).tap(MakeAdvancePayment_button);
    }

    public boolean checkMakeAPaymentOverlayHeader() {
        return ElementActions.isElementDisplayed(driver, MakeAPaymentHeader);
    }

    public boolean checkMakeAPaymentOverlayFirstBill() {
        return ElementActions.isElementDisplayed(driver, PaymentFirstBill);
    }

    public boolean checkMakeAPaymentOverlayAmountField() {
        return ElementActions.isElementDisplayed(driver, PaymentAmountField);
    }

    public boolean checkMakeAPaymentOverlayPaymentMethod() {
        return ElementActions.isElementDisplayed(driver, PaymentMethod);
    }

    public void pressPaymentMethodEditButton() {
        ElementActions.performTouchAction(driver).tap(Edit_Button);
    }

    public void pressMakePaymentButton() {
        ElementActions.performTouchAction(driver).tap(Payment_Button);
    }

    public boolean checkMakeAPaymentOverlayPaymentMethodComponentWithSavedCard() {
        return ElementActions.isElementDisplayed(driver, VisaData);
    }

    public void pressPayWithSelectedCardButton() {
        ElementActions.performTouchAction(driver).tap(UseSelectedCard_Button);
    }

    public By getVestaField() {
        return VestaField;
    }

    public void pressPayWithNewCardAndSaveItForLaterButton() {
        ElementActions.performTouchAction(driver).tap(NewCardAndSaveItForLater_Button);
    }

    public void pressPayWithNewCardWithoutSavingItButton() {
        ElementActions.performTouchAction(driver).tap(NewCardWithoutSaving_Button);
    }

    //DirectDebits
    public boolean checkAccountSettingsText() {
        return ElementActions.isElementDisplayed(driver, AccountSettings_Text);
    }

    public boolean checkPaymentMethodText() {
        return ElementActions.isElementDisplayed(driver, PaymentMethod_Text);
    }

    public boolean checkCreditCardAsRecurringPaymentText() {
        Boolean FirstTab = ElementActions.isElementDisplayed(driver, CreditCardAsRecurringPayment0_Title);
        Boolean SecondTab = ElementActions.isElementDisplayed(driver, CreditCardAsRecurringPaymentSub_Title);
        Boolean result;
        if (FirstTab && SecondTab)
            result = true;
        else
            result = false;
        return result;

    }

    public boolean checkTheTwoExistingTabs() {
        Boolean FirstTab = ElementActions.isElementDisplayed(driver, CreditCardAsRecurringPaymentSaved_Tab);
        Boolean SecondTab = ElementActions.isElementDisplayed(driver, CreditCardAsRecurringPaymentDirectDebit_Tab);
        Boolean result;
        if (FirstTab && SecondTab)
            result = true;
        else
            result = false;
        return result;
    }

    public void pressDirectDebitTab() {
        ElementActions.performTouchAction(driver).tap(CreditCardAsRecurringPaymentDirectDebit_Tab);
    }

    public void pressSavedCardsTab() {
        ElementActions.performTouchAction(driver).tap(CreditCardAsRecurringPaymentSaved_Tab);
    }


    public boolean checkThatAccountOlderAndIbanAreFilled() {
        Boolean result;
        if (AccountHolder_Text != null && Iban_Text != null)
            result = true;
        else
            result = false;
        return result;
    }

    public boolean checkThatAccountOlderAndIbanAreNotFilled() {
        Boolean result;
        if (AccountHolder_Text == null && Iban_Text == null)
            result = true;
        else
            result = false;
        return result;

    }

    public boolean checkThatNoneOfTheCardsAreSavedAsRecurringPayment() {

        return ElementActions.isElementDisplayed(driver, NoneSavedCards_Text);
    }

    public boolean checkNoPaymentMethodText() {
        return ElementActions.isElementDisplayed(driver, NoPaymentMethod_Text);
    }

    public void pressAndNewCardButton() {
        ElementActions.performTouchAction(driver).tap(AddNewCard_Button);
    }

    public boolean checkAddNewCardOverlay() {
        return ElementActions.isElementDisplayed(driver, AddNewCard_Overlay);
    }

    public void pressAddNewCardOverlayCloseButton() {
        ElementActions.performTouchAction(driver).tap(AddNewCardOverlayClose_Button);
    }

    public void pressAddNewCardOverlayNoButton() {
        ElementActions.performTouchAction(driver).tap(AddNewCardOverlayNo_Button);
    }

    public void pressAddNewCardOverlayContinueButton() {
        ElementActions.performTouchAction(driver).tap(AddNewCardOverlayContinue_Button);
    }

    public void checkUseThisCardButton() {
        driver.findElement(UseThisCard_Button).click();
        //ElementActions.isElementDisplayed(driver, UseThisCard_Button);
    }

    public void pressUseThisCardButton() {
        ElementActions.performTouchAction(driver).tap(UseThisCard_Button);
    }

    public boolean checkUseThisCardOverlay() {
        return ElementActions.isElementDisplayed(driver, UseThisCardOverlay_Text);
    }

    public void pressChangeYourCardOverlayCloseButton() {
        ElementActions.performTouchAction(driver).tap(ChangeYourCardOverlayClose_Button);
    }

    public boolean checkSavedCardsTabContent() {
        Boolean FirstContent = ElementActions.isElementDisplayed(driver, CheckSavedCardContent0_Text);
        Boolean SecondContent = ElementActions.isElementDisplayed(driver, CheckSavedCardContent1_Text);
        Boolean result;
        if (FirstContent && SecondContent)
            result = true;
        else
            result = false;
        return result;
    }

    public void pressChangeYourCardOverlayNoButton() {
        ElementActions.performTouchAction(driver).tap(ChangeYourCardOverlayNo_Button);
    }

    public void pressChangeYourCardOverlayContinueButton() {
        ElementActions.performTouchAction(driver).tap(ChangeYourCardOverlayContinue_Button);
    }

    public void insertAccountHolderAndInvalidIban() {
        ElementActions.type(driver, AccountHolder_Text, "Test");
        ElementActions.type(driver, Iban_Text, "132rergert5t4grevfrv54");
    }

    public boolean checkErrorMessageForInvalidIban() {
        return ElementActions.isElementDisplayed(driver, InvalidIbanOverlay_Title);
    }

}
