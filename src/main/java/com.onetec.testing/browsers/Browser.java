package com.onetec.testing.browsers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class Browser {

    private static WebDriver driver;
    private ChromeOptions options;
    private static WebDriverWait wait;

    public void startBrowser(String url) {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,60);
        maximizeWindow();
        driver.get(url);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void startBrowser() {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,60);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public static WebElement waitToBePresent(By by) {
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public static WebElement waitToBeVisible(By by) {
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitToBeClickable(By by) {
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static void takeScreenshot(String path) {
        File captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(captura,new File("C:/TestsQA/Capturas/"+path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshBrowser() {
        driver.navigate().refresh();
    }


}
