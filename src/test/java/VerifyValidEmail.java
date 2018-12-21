import com.onetec.testing.browsers.Browser;
import com.onetec.testing.pages.CheckboxPage;
import com.onetec.testing.pages.DropdownListPage;
import com.onetec.testing.pages.ForgotPasswordPage;
import com.onetec.testing.pages.HomePage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VerifyValidEmail {

    private static Browser browser;
    private HomePage homePage;
    private ForgotPasswordPage forgotPasswordPage;
    private CheckboxPage checkboxPage;
    private DropdownListPage dropdownListPage;
    private WebDriver driver;
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

    @Test
    public void checkboxTest() {
        browser.goTo(HomePage.url);
        homePage.clickLinkCheckboxes();
        checkboxPage = PageFactory.initElements(driver,CheckboxPage.class);
        checkboxPage.clickCheckbox(1);
        checkboxPage.clickCheckbox(2);
        checkboxPage.clickCheckbox(2);
        Assert.assertTrue(checkboxPage.allChecksAreClicked());
    }

    @Test
    public void selectDropdownList() {
        String option = "1";

        browser.goTo(HomePage.url);

        homePage.clickDropdownList();

        dropdownListPage = PageFactory.initElements(driver,DropdownListPage.class);

        dropdownListPage.clickDropdownList(option);

        Assert.assertTrue(dropdownListPage.optionSelected(option));
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
