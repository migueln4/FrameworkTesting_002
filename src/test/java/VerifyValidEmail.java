import com.onetec.testing.browsers.Browser;
import com.onetec.testing.pages.CheckboxPage;
import com.onetec.testing.pages.DropdownListPage;
import com.onetec.testing.pages.DynamicContentPage;
import com.onetec.testing.pages.ForgotPasswordPage;
import com.onetec.testing.pages.HomePage;
import com.onetec.testing.pages.JQueryMenuPage;
import com.onetec.testing.pages.LoginPage;
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
    private DynamicContentPage dynamicContentPage;
    private JQueryMenuPage jQueryMenuPage;
    private LoginPage loginPage;
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
        //browser.goTo(HomePage.url);
        Assert.assertTrue(homePage.isAt());
    }

    @Test
    public void checkboxTest() {
        //browser.goTo(HomePage.url);
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
        //browser.goTo(HomePage.url);
        homePage.clickDropdownList();
        dropdownListPage = PageFactory.initElements(driver,DropdownListPage.class);
        dropdownListPage.clickDropdownList(option);
        Assert.assertTrue(dropdownListPage.optionSelected(option));
    }

    @Test
    public void dynamicContentSearch() {
        String searchUrl = HomePage.url+"img/avatars/Original-Facebook-Geek-Profile-Avatar-1.jpg";
        int attempts = 0;
        boolean flag = false;
        //browser.goTo(HomePage.url);
        homePage.clickDynamicContent();
        dynamicContentPage = PageFactory.initElements(driver,DynamicContentPage.class);
        do {
            flag = dynamicContentPage.itsImg(searchUrl);
            browser.refreshBrowser();
            attempts++;
        }while (!flag);
        System.out.println("Intentos realizados: "+attempts);
        Assert.assertTrue(flag);
    }

    @Test
    public void loginAttemptFailed() {
        String user = "user";
        String pass = "pass";
        //browser.goTo(HomePage.url);
        homePage.clickFormAuthentication();
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        Assert.assertTrue(loginPage.clickSubmit(user,pass));

    }

    @Test
    public void loginAttemptSuccess() {
        String user = "tomsmith";
        String pass = "SuperSecretPassword!";
        //browser.goTo(HomePage.url);
        homePage.clickFormAuthentication();
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        Assert.assertFalse(loginPage.clickSubmit(user,pass));
    }

    @Test
    public void hoverMenu() {
        //browser.goTo(HomePage.url);
        homePage.clickJQuerymenu();
        jQueryMenuPage = PageFactory.initElements(driver,JQueryMenuPage.class);
        Assert.assertTrue(jQueryMenuPage.hoverMenu());
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
