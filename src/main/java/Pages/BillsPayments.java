package Pages;
import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class BillsPayments {
    public BillsPayments(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    private  By CurrentSpendLastBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_details_title");
    private By Bills_Payments_Button = By.xpath("//android.view.ViewGroup[@content-desc=\"Button\"]");
    private  By BillsPaymentTitle = new MobileBy.ByAccessibilityId("id_header_title_Bills_&_Payments");
    private By CloseBTN = new MobileBy.ByAccessibilityId("id_header_close_icon");
    private By  Download_Button= new MobileBy.ByAccessibilityId("Download March 2021 bill");
    private By  MakePayment_Button= By.xpath("(//android.view.ViewGroup[@content-desc=\"Button\"])[1]");
    private By  MakeAPaymentHeader= new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_title");
    private By PaymentFirstBill = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_bill_8_value");
    private By PaymentAmountField =new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_amount_input");
    private By PaymentMethod = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_payment_method_title");
    private By Edit_Button = By.xpath("//android.view.ViewGroup[@content-desc=\"Select or add a card to pay €48.67\"])[2]");
    private By Payment_Button=new MobileBy.ByAccessibilityId("Make payment");
    private By VisaData = new MobileBy.ByAccessibilityId("Visa ending in 3363. Selected");
    private By UseSelectedCard_Button= new MobileBy.ByAccessibilityId("Use selected card");
    private By VestaField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View");
    private By NewCardAndSaveItForLater_Button=new MobileBy.ByAccessibilityId("Button. Navigates to add card screen.");
    private By NewCardWithoutSaving_Button=new MobileBy.ByAccessibilityId("Button. Navigates to payment screen");
    //DirectDebits
    private By AccountSettings_Text = new MobileBy.ByAccessibilityId("id_dashboard_my_usage_title");
    private By PaymentMethod_Text = new MobileBy.ByAccessibilityId("id_header_title_Payment_method");
    private By CreditCardAsRecurringPayment0_Title = new MobileBy.ByAccessibilityId("id_payment_method_header_title");
    private By CreditCardAsRecurringPaymentSub_Title = new MobileBy.ByAccessibilityId("id_payment_method_header_sub_title1");
    private By CreditCardAsRecurringPaymentSaved_Tab = new MobileBy.ByAccessibilityId("id_payment_method_list_selector_text_Saved Cards");
    private By CreditCardAsRecurringPaymentDirectDebit_Tab = new MobileBy.ByAccessibilityId("id_payment_method_list_selector_text_Direct Debit");
    private By AccountHolder_Text = By.xpath("(//android.widget.EditText[@content-desc=\"id_account_and_email_name_input\"])[1]");
    private By Iban_Text = By.xpath("(//android.widget.EditText[@content-desc=\"id_account_and_email_name_input\"])[2]");
    private By NoneSavedCards_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_list_no_cards_info_text");
    private By NoPaymentMethod_Text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView");
    private By AddNewCard_Button = new MobileBy.ByAccessibilityId("id_add_new_card_button");
    private By AddNewCard_Overlay = new MobileBy.ByAccessibilityId("id_payment_method_add_card_description_main_text");
    private By AddNewCardOverlayClose_Button = By.xpath("//android.widget.ImageView[@content-desc=\"id_payment_method_add_card_overlay_close\"]");
    private By AddNewCardOverlayNo_Button = new MobileBy.ByAccessibilityId("id_payment_method_add_card_close_button");
    private By AddNewCardOverlayContinue_Button = new MobileBy.ByAccessibilityId("id_payment_method_add_card_continue_button");
    private By UseThisCard_Button = By.xpath("(//android.widget.Button[@content-desc=\"id_use_this_card_button\"])[1]");
    private By UseThisCardOverlay_Text = new MobileBy.ByAccessibilityId("id_payment_method_change_card_description_main_text");
    private By ChangeYourCardOverlayClose_Button = By.xpath("//android.widget.ImageView[@content-desc=\"id_payment_method_change_card_overlay_close\"]");
    private By ChangeYourCardOverlayNo_Button = new MobileBy.ByAccessibilityId("id_payment_method_change_card_close_button");
    private By ChangeYourCardOverlayContinue_Button = new MobileBy.ByAccessibilityId("id_payment_method_change_card_continue_button");
    private By CheckSavedCardContent0_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_item_description_cards_0");
    private By CheckSavedCardContent1_Text = new MobileBy.ByAccessibilityId("id_payment_method_card_description_cards_0");
    private By InvalidIbanOverlay_Title = new MobileBy.ByAccessibilityId("id_payment_method_invalid_iban_overlay_title");

    public Boolean checkCurrentSpendOverlay()
    {
        return ElementActions.isElementDisplayed(driver, CurrentSpendLastBillTitle);
    }

    public void pressViewBillsAndPaymentsButton()
    {
        ElementActions.performTouchAction(driver).tap(Bills_Payments_Button);
    }

    public Boolean checkBillsPaymentsHeader()
    {

        return  ElementActions.isElementDisplayed(driver, BillsPaymentTitle);
    }
    public void pressCloseButtonInBillsPaymentsView()
    {
        ElementActions.performTouchAction(driver).tap(CloseBTN);
    }

    public void  pressDownloadBillButton()
    {
        ElementActions.performTouchAction(driver).tap(Download_Button);
    }

    public void  pressMakeAPaymentButton()
    {
        ElementActions.performTouchAction(driver).tap(MakePayment_Button);
    }
    public Boolean checkMakeAPaymentOverlayHeader()
    {
        return  ElementActions.isElementDisplayed(driver, MakeAPaymentHeader);
    }

    public Boolean checkMakeAPaymentOverlayFirstBill()
    {
        return  ElementActions.isElementDisplayed(driver, PaymentFirstBill);
    }
    public Boolean checkMakeAPaymentOverlayAmountField()
    {
        return  ElementActions.isElementDisplayed(driver, PaymentAmountField);
    }
    public Boolean checkMakeAPaymentOverlayPaymentMethod()
    {
        return  ElementActions.isElementDisplayed(driver, PaymentMethod);
    }
    public void pressPaymentMethodEditButton()
    {
        ElementActions.performTouchAction(driver).tap(Edit_Button);
    }
    public void pressMakePaymentButton()
    {
        ElementActions.performTouchAction(driver).tap(Payment_Button);
    }

    public  Boolean checkMakeAPaymentOverlayPaymentMethodComponentWithSavedCard()
    {
        return  ElementActions.isElementDisplayed(driver, VisaData);
    }
    public void  pressPayWithSelectedCardButton()
    {
        ElementActions.performTouchAction(driver).tap(UseSelectedCard_Button);
    }

    public By getVestaField() {
        return VestaField;
    }

    public void pressPayWithNewCardAndSaveItForLaterButton()
    {
        ElementActions.performTouchAction(driver).tap(NewCardAndSaveItForLater_Button);
    }

    public void pressPayWithNewCardWithoutSavingItButton()
    {
        ElementActions.performTouchAction(driver).tap(NewCardWithoutSaving_Button);
    }

    //DirectDebits
    public boolean checkAccountSettingsText()
    {
        return  ElementActions.isElementDisplayed(driver, AccountSettings_Text);
    }

    public Boolean checkPaymentMethodText()
    {
        return ElementActions.isElementDisplayed(driver, PaymentMethod_Text);
    }

    public Boolean checkCreditCardAsRecurringPaymentText()
    {
        Boolean FirstTab = ElementActions.isElementDisplayed(driver, CreditCardAsRecurringPayment0_Title);
        Boolean SecondTab = ElementActions.isElementDisplayed(driver, CreditCardAsRecurringPaymentSub_Title);
        Boolean result;
        if (FirstTab && SecondTab)
            result = true;
        else
            result = false;
        return result;

    }

    public Boolean checkTheTwoExistingTabs()
    {
        Boolean FirstTab = ElementActions.isElementDisplayed(driver, CreditCardAsRecurringPaymentSaved_Tab);
        Boolean SecondTab = ElementActions.isElementDisplayed(driver, CreditCardAsRecurringPaymentDirectDebit_Tab);
        Boolean result;
        if (FirstTab && SecondTab)
            result = true;
        else
            result = false;
        return result;
    }

    public void pressDirectDebitTab()
    {
        ElementActions.performTouchAction(driver).tap(CreditCardAsRecurringPaymentDirectDebit_Tab);
    }

    public void pressSavedCardsTab()
    {
        ElementActions.performTouchAction(driver).tap(CreditCardAsRecurringPaymentSaved_Tab);
    }

    public Boolean checkThatAccountOlderAndIbanAreFilled()
    {
        Boolean result;
        if (AccountHolder_Text != null && Iban_Text != null)
            result = true;
        else
            result = false;
        return result;

    }

    public Boolean checkThatAccountOlderAndIbanAreNotFilled()
    {
        Boolean result;
        if (AccountHolder_Text == null && Iban_Text == null)
            result = true;
        else
            result = false;
        return result;

    }

    public Boolean checkThatNoneOfTheCardsAreSavedAsRecurringPayment()
    {
        return ElementActions.isElementDisplayed(driver, NoneSavedCards_Text);
    }

    public boolean checkNoPaymentMethodText()
    {
        return ElementActions.isElementDisplayed(driver, NoPaymentMethod_Text);
    }

    public void pressAndNewCardButton()
    {
        ElementActions.performTouchAction(driver).tap(AddNewCard_Button);
    }

    public Boolean checkAddNewCardOverlay()
    {
        return ElementActions.isElementDisplayed(driver, AddNewCard_Overlay);
    }

    public void pressAddNewCardOverlayCloseButton()
    {
        ElementActions.performTouchAction(driver).tap(AddNewCardOverlayClose_Button);
    }

    public void pressAddNewCardOverlayNoButton()
    {
        ElementActions.performTouchAction(driver).tap(AddNewCardOverlayNo_Button);
    }

    public void pressAddNewCardOverlayContinueButton()
    {
        ElementActions.performTouchAction(driver).tap(AddNewCardOverlayContinue_Button);
    }

    public Boolean checkUseThisCardButton()
    {
        return ElementActions.isElementDisplayed(driver, UseThisCard_Button);
    }

    public void pressUseThisCardButton()
    {
        ElementActions.performTouchAction(driver).tap(UseThisCard_Button);
    }

    public Boolean checkUseThisCardOverlay()
    {
        return ElementActions.isElementDisplayed(driver, UseThisCardOverlay_Text);
    }

    public void pressChangeYourCardOverlayCloseButton()
    {
        ElementActions.performTouchAction(driver).tap(ChangeYourCardOverlayClose_Button);
    }

    public Boolean checkSavedCardsTabContent() {
        Boolean FirstContent = ElementActions.isElementDisplayed(driver, CheckSavedCardContent0_Text);
        Boolean SecondContent = ElementActions.isElementDisplayed(driver, CheckSavedCardContent1_Text);
        Boolean result;
        if (FirstContent && SecondContent)
            result = true;
        else
            result = false;
        return result;
    }

    public void pressChangeYourCardOverlayNoButton()
    {
        ElementActions.performTouchAction(driver).tap(ChangeYourCardOverlayNo_Button);
    }

    public void pressChangeYourCardOverlayContinueButton()
    {
        ElementActions.performTouchAction(driver).tap(ChangeYourCardOverlayContinue_Button);
    }

    public void insertAccountHolderAndInvalidIban()
    {
        ElementActions.type(driver, AccountHolder_Text , "Test");
        ElementActions.type(driver, Iban_Text , "132rergert5t4grevfrv54");
    }

    public Boolean checkErrorMessageForInvalidIban()
    {
        return ElementActions.isElementDisplayed(driver,InvalidIbanOverlay_Title);
    }

}
