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
    private static int testNumber;

    @BeforeClass
    public static void initBrowser() {
        browser = new Browser();
        testNumber = 0;
    }

    @Before
    public void startBrowser() {

        testNumber++;

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

    @Test
    public void test() {
        browser.goTo(HomePage.url);

        Assert.assertTrue(homePage.isAt());
    }

    @After
    public void closeBrowser() {
        browser.takeScreenshot("resultadoTest"+testNumber+".png");
        browser.close();
    }

    @AfterClass
    public static void cleanUp() {
        browser.quit();
    }

}
