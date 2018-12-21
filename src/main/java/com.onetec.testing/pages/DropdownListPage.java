package com.onetec.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownListPage extends WebPage {

    public static String url = "https://the-internet.herokuapp.com/dropdown";

    @FindBy(how = How.XPATH, using="//*[@id=\"dropdown\"]")
    private WebElement dropdownListElement;

    public DropdownListPage(WebDriver driver) {
        super.driver = driver;
    }

    public void clickDropdownList(String text) {
        Select dropdownList = new Select(dropdownListElement);
        dropdownList.selectByValue(text);
    }

    public boolean optionSelected(String text) {
        Select dropdownList = new Select(dropdownListElement);
        List<WebElement> options = dropdownList.getOptions();
        for(WebElement opt : options) {
            if (opt.getAttribute("value").equals(text))
                return true;
        }
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
