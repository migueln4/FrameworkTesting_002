package com.onetec.testing.pages;

import com.onetec.testing.browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JQueryMenuPage extends WebPage {

    public static String url = "https://the-internet.herokuapp.com/jqueryui/menu";

    @FindBy(how = How.XPATH, using="//*[@id=\"ui-id-3\"]/a")
    private WebElement itemMenuEnabled;

    public JQueryMenuPage(WebDriver driver) {
        super.driver = driver;
    }

    public boolean hoverMenu() {
        JQueryUIPage jQueryUIPage = new JQueryUIPage(driver);
        Actions action = new Actions(driver);
        action.moveToElement(itemMenuEnabled).build().perform();
        WebElement link = Browser.waitToBeClickable(By.cssSelector("#ui-id-8 > a"));
        link.click();
        return jQueryUIPage.isAt();
    }

    @Override
    public boolean isAt() {
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.indexOf('?') > 0) {
            currentUrl = driver.getCurrentUrl().substring(0, currentUrl.indexOf('?'));
        }
        return currentUrl.equals(url);
    }

}
