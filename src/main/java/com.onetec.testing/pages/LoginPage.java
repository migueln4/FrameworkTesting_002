package com.onetec.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LoginPage extends WebPage {

    public static String url = "https://the-internet.herokuapp.com/login";

    @FindBy(how = How.ID, using="username")
    private WebElement username;

    @FindBy(how = How.ID, using="password")
    private WebElement password;

    @FindBy(how = How.XPATH, using="//*[@id=\"login\"]/button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super.driver = driver;
    }

    public boolean clickSubmit(String user, String pass) {
        boolean loginFailed = true;
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.submit();
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        for(WebElement div : divs) {
            if(div.getAttribute("class").equals("flash error")) {
                loginFailed = true;
            }
            else if (div.getAttribute("class").equals("flash success")) {
                loginFailed = false;
            }
        }
        return loginFailed;
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
