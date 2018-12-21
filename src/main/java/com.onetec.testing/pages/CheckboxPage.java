package com.onetec.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckboxPage extends WebPage {

    public static String url="https://the-internet.herokuapp.com/checkboxes";

    @FindBy(how = How.XPATH, using="//*[@id=\"checkboxes\"]/input[1]")
    private WebElement checkbox1;

    @FindBy(how = How.XPATH, using="//*[@id=\"checkboxes\"]/input[2]")
    private WebElement checkbox2;

    public CheckboxPage(WebDriver driver) {
        super.driver = driver;
    }

    public void clickCheckbox(int n) {
        switch(n) {
            case 1:
                checkbox1.click();
                break;
            case 2:
                checkbox2.click();
                break;
            default:
                break;
        }
    }

    public boolean checkIsClicked(int n) {
        switch(n) {
            case 1:
                return checkbox1.isSelected();
            case 2:
                return checkbox2.isSelected();
            default:
                return false;
        }
    }

    public boolean allChecksAreClicked() {
        return checkbox1.isSelected() && checkbox2.isSelected();
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
