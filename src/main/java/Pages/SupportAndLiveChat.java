package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupportAndLiveChat {

    private final WebDriver driver;
    private static By SupportHeader_text;
    private static By SupportHeaderClose_button;
    private static By MinimizeLiveChat_button;
    private static By Support_title;
    private static By Support_Subtitle;

    //Bill Pay
    private static By FirstSupportTitle_textBP;
    private static By SecondSupportTitle_textBP;
    private static By SupportListFirstItem_textBP;

    //PAYG
    private static By FirstSupportTitle_textPAYG;
    private static By SecondSupportTitle_textPAYG;
    private static By SupportListFirstItem_textPAYG;

    //Fixed
    private static By FirstSupportTitle_textFixed;
    private static By SupportListFirstItem_textFixed;


    private static By ChatNow_button;
    private static By LiveChatFormFullName_inputText;
    private static By LiveChatFormQuestions_inputText;
    private static By LiveChatFormStartChat_button;


    public By getFirstSupportTitle_textBP() {
        return FirstSupportTitle_textBP;
    }

    public By getSecondSupportTitle_textBP() {
        return SecondSupportTitle_textBP;
    }

    public By getSupportListFirstItem_textBP() {
        return SupportListFirstItem_textBP;
    }

    public By getSupportHeader_text() {
        return SupportHeader_text;
    }

    public By getSupport_title() {
        return Support_title;
    }

    public By getSupport_Subtitle() {
        return Support_Subtitle;
    }

    public By getChatNow_button() {
        return ChatNow_button;
    }

    public By getFirstSupportTitle_textPAYG() {
        return FirstSupportTitle_textPAYG;
    }

    public By getSecondSupportTitle_textPAYG() {
        return SecondSupportTitle_textPAYG;
    }

    public By getSupportListFirstItem_textPAYG() {
        return SupportListFirstItem_textPAYG;
    }

    public By getFirstSupportTitle_textFixed() {
        return FirstSupportTitle_textFixed;
    }

    public By getSupportListFirstItem_textFixed() {
        return SupportListFirstItem_textFixed;
    }


    public SupportAndLiveChat(WebDriver driver) {
        this.driver = driver;
        if (System.getProperty("targetOperatingSystem").equals("Android")) {
            SupportHeader_text = new MobileBy.ByAccessibilityId("id_header_title_Support");
            SupportHeaderClose_button = new MobileBy.ByAccessibilityId("id_header_close_icon");
            MinimizeLiveChat_button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[3]");

            //"What are you looking for" Element Bill Pay
            FirstSupportTitle_textBP = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]");

            //"Select Support Topic" Element Bill Pay
            SecondSupportTitle_textBP = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]");

            //"Account" Element Bill Pay
            SupportListFirstItem_textBP = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View[2]");

            //"Need for" Element PAYG
            FirstSupportTitle_textPAYG = new MobileBy.ByAccessibilityId("id_chat_heading_text");

            //"Available from" Element PAYG
            SecondSupportTitle_textPAYG = new MobileBy.ByAccessibilityId("id_chat_subheading_text");

            //"Account" Element PAYG
            SupportListFirstItem_textPAYG = By.xpath("//android.view.View[@content-desc=\"Account and top up Help for account and credit queries\"]/android.view.View/android.view.View[1]");

            //"Click Here" Element Fixed
            FirstSupportTitle_textFixed = new MobileBy.ByAccessibilityId("click here");

            //"Account" Element Fixed
            SupportListFirstItem_textFixed = new MobileBy.ByAccessibilityId("Account and billing How to manage your TV bills and payments");


            //live chat component
            ChatNow_button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button");

            LiveChatFormFullName_inputText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.widget.EditText");
            LiveChatFormQuestions_inputText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[2]/android.widget.EditText");
            LiveChatFormStartChat_button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[3]");

        } else {
            //IOS Locators

            SupportHeader_text = MobileBy.AccessibilityId("Support");
            SupportHeaderClose_button = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"id_header_close_icon\"])[2]");
            Support_title = MobileBy.AccessibilityId("id_chat_heading_text");
            Support_Subtitle = MobileBy.AccessibilityId("id_chat_subheading_text");
            MinimizeLiveChat_button = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[3]");

            //"What are you looking for" Element Bill Pay
            FirstSupportTitle_textBP = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]");

            //"Select Support Topic" Element Bill Pay
            SecondSupportTitle_textBP = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]");

            //"Account" Element Bill Pay
            SupportListFirstItem_textBP = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View[2]");

            //"Need for" Element PAYG
            FirstSupportTitle_textPAYG = new MobileBy.ByAccessibilityId("id_chat_heading_text");

            //"Available from" Element PAYG
            SecondSupportTitle_textPAYG = new MobileBy.ByAccessibilityId("id_chat_subheading_text");

            //"Account" Element PAYG
            SupportListFirstItem_textPAYG = By.xpath("//android.view.View[@content-desc=\"Account and top up Help for account and credit queries\"]/android.view.View/android.view.View[1]");

            //"Click Here" Element Fixed
            FirstSupportTitle_textFixed = new MobileBy.ByAccessibilityId("click here");

            //"Account" Element Fixed
            SupportListFirstItem_textFixed = new MobileBy.ByAccessibilityId("Account and billing How to manage your TV bills and payments");


            //live chat component
            ChatNow_button = MobileBy.AccessibilityId("Chat Now");
            LiveChatFormFullName_inputText = MobileBy.xpath("//XCUIElementTypeOther[@name=\"See our most popular Bill pay support topics | Vodafone\"]/XCUIElementTypeOther[45]/XCUIElementTypeTextField");
            LiveChatFormQuestions_inputText = MobileBy.xpath("//XCUIElementTypeOther[@name=\"See our most popular Bill pay support topics | Vodafone\"]/XCUIElementTypeOther[48]/XCUIElementTypeTextView");
            LiveChatFormStartChat_button = MobileBy.AccessibilityId("Start chat");
        }
    }

    public void pressSupportHeaderCloseButton() {
        ElementActions.performTouchAction(driver).tap(SupportHeaderClose_button);
    }

    public void minimizeLiveChat() {
        ElementActions.performTouchAction(driver).tap(MinimizeLiveChat_button);
    }

    public void pressChatNowButton() {
        ElementActions.performTouchAction(driver).tap(ChatNow_button);
    }

    public void fillLiveChatFormAndPressStartChat() {
        ElementActions.type(driver, LiveChatFormFullName_inputText, "Nora Ahmed");
        ElementActions.type(driver, LiveChatFormQuestions_inputText, "My Question");
        ElementActions.performTouchAction(driver).tap(LiveChatFormStartChat_button); //This step must be on SIT3 environment


    }

}
