package com.onetec.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DynamicContentPage extends WebPage {

    public static String url = "https://the-internet.herokuapp.com/dynamic_content";

    @FindBy(how = How.XPATH, using="//*[@id=\"content\"]/div[1]/div[1]/img")
    private WebElement image1;

    @FindBy(how = How.XPATH, using="//*[@id=\"content\"]/div[2]/div[1]/img")
    private WebElement image2;

    @FindBy(how = How.XPATH, using="//*[@id=\"content\"]/div[3]/div[1]/img")
    private WebElement image3;

    public DynamicContentPage(WebDriver driver) {
        super.driver = driver;
    }

    public boolean itsImg(String url) {
        if(url.equals(image1.getAttribute("src"))
            || url.equals(image2.getAttribute("src"))
            || url.equals(image3.getAttribute("src"))) {
            return true;
        }
        else
            return false;
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
