package Directdebits;

import FileReaders.jsonReader;
import Pages.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TC181_ValidateBillPayUserWithCreditCardAsRecurringPayment {

    //TC181 - Page validations for a Bill Pay user with Credit Card as recurring payment
    //TC175 - Page validations for a Bill Pay user with Credit Card as recurring payment

    private WebDriver driver;
    private Login LoginPage;
    private Home HomePage;
    private BillsPayments BillsPaymentsPage;
    private Settings SettingsPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("executionAddress", "0.0.0.0:4723");
        System.setProperty("targetOperatingSystem", "iOS");
        System.setProperty("mobile_platformVersion", "14.4");
        System.setProperty("mobile_deviceName", "iPhone");
        System.setProperty("mobile_automationName", "XCUITest");
        System.setProperty("mobile_udid", "00008030-001C4D5C1E33802E");
        System.setProperty("mobile_bundleId", "com.VodafoneIreland.MyVodafone");
        System.setProperty("mobile_derivedDataPath","/Users/mva-ireland/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");

        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
        HomePage = new Home(driver);
        BillsPaymentsPage = new BillsPayments(driver);
        SettingsPage = new Settings(driver);
        //LoginPage.acceptTermsAndConditions().login(jsonReader.getUserName("SavedCC.username"),jsonReader.getPassword("SavedCC.password")).acceptPermissions();//fluent design
    }

    @Test
    public void CreditCardAsRecurringPayment() {
        HomePage.pressAccountTrayMenuOption();
        Verifications.verifyTrue(HomePage.CheckAccountOverlaySettingText());
    }
    @Test
    public void step2(){
        HomePage.pressAccountSettingOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkAccountSettingsText());
    }

    @Test
    public void step3(){
        SettingsPage.pressPaymentMethodOption();
        Verifications.verifyTrue(BillsPaymentsPage.checkPaymentMethodText());
    }

    @Test
    public void step4(){
        BillsPaymentsPage.pressCloseButtonInBillsPaymentsView();
        Verifications.verifyTrue(HomePage.checkTheVodafoneLogo());
        HomePage.pressAccountTrayMenuOption();
        HomePage.pressAccountSettingOption();
    }

    @Test
    public void step5(){
        SettingsPage.pressPaymentMethodOption();
        BillsPaymentsPage.pressSavedCardsTab();
        Verifications.verifyTrue(BillsPaymentsPage.checkCreditCardAsRecurringPaymentText());
        Verifications.verifyTrue(BillsPaymentsPage.checkTheTwoExistingTabs());
    }

    @Test
    public void step6(){
        BillsPaymentsPage.pressDirectDebitTab();
        BillsPaymentsPage.checkThatAccountOlderAndIbanAreNotFilled();
    }
}

