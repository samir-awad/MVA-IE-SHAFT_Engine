package Pages;
import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillsPayments {
    public BillsPayments(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    private  By CurrentSpendLastBillTitle = new MobileBy.ByAccessibilityId("id_dashboard_next_bill_details_title");
    private By Bills_PaymentsBTN = By.xpath("//android.view.ViewGroup[@content-desc=\"Button\"]");
    private  By BillsPaymentTitle = new MobileBy.ByAccessibilityId("id_header_title_Bills_&_Payments");
    private By CloseBTN = new MobileBy.ByAccessibilityId("id_header_close_icon");
    private By  DownloadBtn= new MobileBy.ByAccessibilityId("Download March 2021 bill");
    private By  MakePaymentBtn= new MobileBy.ByAccessibilityId("Button");
    private By  MakeAPaymentHeader= new MobileBy.ByAccessibilityId("id_bills_payments_make_payment_title");

    public Boolean checkCurrentSpendOverlay()
    {
        return ElementActions.isElementDisplayed(driver, CurrentSpendLastBillTitle);
    }

    public void pressViewBillsAndPaymentsButton()
    {
        ElementActions.performTouchAction(driver).tap(Bills_PaymentsBTN);
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
        ElementActions.performTouchAction(driver).tap(DownloadBtn);
    }

    public void  pressMakeAPaymentButton()
    {
        ElementActions.performTouchAction(driver).tap(MakePaymentBtn);
    }
    public Boolean checkMakeAPaymentOverlayHeader()
    {
        return  ElementActions.isElementDisplayed(driver, MakeAPaymentHeader);
    }

}
