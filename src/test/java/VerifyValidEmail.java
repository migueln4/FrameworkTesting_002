import com.onetec.testing.browsers.Browser;
import com.onetec.testing.pages.ForgotPasswordPage;
import com.onetec.testing.pages.HomePage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VerifyValidEmail {

    private static Browser browser;
    private static HomePage homePage;
    private static ForgotPasswordPage forgotPasswordPage;
    private static WebDriver driver;

    @BeforeClass
    public static void startBrowser() {
        browser = new Browser();
        browser.startBrowser(HomePage.url);
        driver = browser.getDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }


    @Test
    public void checkValidEmail() {

        homePage.clickLinkForgotPassword();

        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);

        forgotPasswordPage.enterMail("hola@hola.com");

        Assert.assertTrue(forgotPasswordPage.wrongMail());

    }

    @AfterClass
    public static void cleanUp() {
        browser.takeScreenshot("resultado.png");
        browser.close();
        browser.quit();
    }

}
