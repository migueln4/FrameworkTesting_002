package com.onetec.testing.pages;

import org.openqa.selenium.WebDriver;

public class JQueryUIPage extends WebPage {

    public static String url = "https://the-internet.herokuapp.com/jqueryui";

    public JQueryUIPage(WebDriver driver) {
        super.driver = driver;
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
