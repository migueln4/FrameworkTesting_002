package com.onetec.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends WebPage {

    public static String url="https://the-internet.herokuapp.com/";

    @FindBy(how = How.CSS, using="#content > ul > li:nth-child(17) > a")
    private WebElement linkForgotPassword;

    @FindBy(how = How.CSS, using="#content > ul > li:nth-child(5) > a")
    private WebElement linkCheckboxes;

    @FindBy(how = How.CSS, using="#content > ul > li:nth-child(9) > a")
    private WebElement linkDropdownList;

    @FindBy(how = How.CSS, using="#content > ul > li:nth-child(10) > a")
    private WebElement linkDynamicContent;

    @FindBy(how = How.CSS, using="#content > ul > li:nth-child(18) > a")
    private WebElement linkFormAuthentication;

    @FindBy(how = How.CSS, using="#content > ul > li:nth-child(24) > a")
    private WebElement linkJQueryMenu;

    @FindBy(how = How.CSS, using="#content > ul > li:nth-child(13) > a")
    private WebElement linkExitIntent;


    public HomePage(WebDriver driver) {
        super.driver = driver;
    }

    public void clickLinkForgotPassword() {
        linkForgotPassword.click();
    }

    public void clickLinkCheckboxes() { linkCheckboxes.click();}

    public void clickDropdownList() { linkDropdownList.click();}

    public void clickDynamicContent() {
        linkDynamicContent.click();
    }

    public void clickFormAuthentication() {
        linkFormAuthentication.click();
    }

    public void clickJQuerymenu() {
        linkJQueryMenu.click();
    }

    public void clickExitIntent() {
        linkExitIntent.click();
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
