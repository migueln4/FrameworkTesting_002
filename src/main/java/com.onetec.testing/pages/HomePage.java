package com.onetec.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends WebPage {

    public static String url = "https://the-internet.herokuapp.com/";

    @FindBy(how = How.CSS, using="#content > ul > li:nth-child(17) > a")
    private static WebElement linkForgotPassword;

    public HomePage(WebDriver driver) {
        super.driver = driver;
    }

    public void clickLinkForgotPassword() {
        linkForgotPassword.click();
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean isAt() {
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.indexOf('?') > 0) {
            currentUrl = driver.getCurrentUrl().substring(0, currentUrl.indexOf('?'));
        }
        //System.out.println(currentUrl);
        return currentUrl.equals(this.url);
    }
}
