package com.onetec.testing.pages;

import com.onetec.testing.browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    private WebDriver driver;

    private String url = "https://the-internet.herokuapp.com/forgot_password";

    @FindBy(how = How.ID, using="email")
    private static WebElement mailForm;

    @FindBy(how = How.XPATH, using="//*[@id=\"form_submit\"]/i")
    private static WebElement submitButton;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMail(String email) {
        mailForm.sendKeys(email);
        submitButton.click();
    }

    public boolean wrongMail() {
        By by = By.cssSelector("#content");
        WebElement element = Browser.waitToBePresent(by);
        return element.getText().equals("Your e-mail's been sent!");
    }

    public String getUrl() {
        return url;
    }



}
