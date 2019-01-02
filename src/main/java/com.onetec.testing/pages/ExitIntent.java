package com.onetec.testing.pages;

import com.onetec.testing.browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ExitIntent extends WebPage {

    public static String url = "https://the-internet.herokuapp.com/exit_intent";

    @FindBy(how = How.CSS, using="#content > div.example > h3")
    private WebElement titleH3;

    public ExitIntent(WebDriver driver) {
        super.driver = driver;
    }

    public boolean moveMouse() {
        boolean response = false;
        Actions action = new Actions(driver);
        action.moveToElement(titleH3).moveByOffset(0,-10000).build().perform();
        response = Browser.waitToBeClickable(By.cssSelector("#ouibounce-modal > div.modal > div.modal-footer > p")).isDisplayed();
        return response;
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
