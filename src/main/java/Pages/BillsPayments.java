package Pages;
import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BillsPayments {

    private WebDriver driver;
    private By CurrentSpendLastBillTitle;
    private By Bills_Payments_Button;
    private By BillsPaymentTitle;
    private By CloseBTN;
    private By  Download_Button ;
    private By  MakePayment_Button ;
    private By  MakeAPaymentHeader ;
    private By PaymentFirstBill ;
    private By PaymentAmountField ;
    private By PaymentMethod;
    private By Edit_Button;
    private By Payment_Button;
    private By VisaData;
    private By UseSelectedCard_Button;
    private By VestaFiled;
    private By NewCardAndSaveItForLater_Button;
    private By NewCardWithoutSaving_Button;


    public BillsPayments(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")){
            CurrentSpendLastBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_details_title");
            Bills_Payments_Button = By.xpath("//android.view.ViewGroup[@content-desc=\"Button\"]");
            BillsPaymentTitle = new MobileBy.ByAccessibilityId("id_header_title_Bills_&_Payments");
            CloseBTN = new MobileBy.ByAccessibilityId("id_header_close_icon");
            Download_Button= new MobileBy.ByAccessibilityId("Download March 2021 bill");
            MakePayment_Button= By.xpath("(//android.view.ViewGroup[@content-desc=\"Button\"])[1]");
            MakeAPaymentHeader= new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_title");
            PaymentFirstBill = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_bill_8_value");
            PaymentAmountField =new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_amount_input");
            PaymentMethod = new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_payment_method_title");
            Edit_Button = By.xpath("//android.view.ViewGroup[@content-desc=\"Select or add a card to pay €48.67\"])[2]");
            Payment_Button=new MobileBy.ByAccessibilityId("Make payment");
            VisaData = new MobileBy.ByAccessibilityId("Visa ending in 3363. Selected");
            UseSelectedCard_Button= new MobileBy.ByAccessibilityId("Use selected card");
            VestaFiled = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View");
            NewCardAndSaveItForLater_Button=new MobileBy.ByAccessibilityId("Button. Navigates to add card screen.");
            NewCardWithoutSaving_Button=new MobileBy.ByAccessibilityId("Button. Navigates to payment screen");



        }else{
        }
    }
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
        return VestaFiled;
    }

    public void pressPayWithNewCardAndSaveItForLaterButton()
    {
        ElementActions.performTouchAction(driver).tap(NewCardAndSaveItForLater_Button);
    }

    public void pressPayWithNewCardWithoutSavingItButton()
    {
        ElementActions.performTouchAction(driver).tap(NewCardWithoutSaving_Button);
    }
}
