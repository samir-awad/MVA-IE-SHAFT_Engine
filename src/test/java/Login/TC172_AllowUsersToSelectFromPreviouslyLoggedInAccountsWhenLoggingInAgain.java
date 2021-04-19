package Login;

import Pages.Login;
import com.shaft.gui.browser.BrowserFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;

public class TC172_AllowUsersToSelectFromPreviouslyLoggedInAccountsWhenLoggingInAgain{

    private WebDriver driver;
    private Login LoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        LoginPage = new Login(driver);
    }

    @Test()
    public void Step1() throws IOException, ParseException {
       
    }


}
