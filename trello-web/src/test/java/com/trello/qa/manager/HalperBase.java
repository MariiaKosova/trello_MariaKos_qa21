package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HalperBase {
    WebDriver driver;

    public HalperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void goHomePage() throws InterruptedException {
        Thread.sleep(10000);
       click(By.cssSelector("[href='/']"));
       click(By.cssSelector("[href='/']"));
       driver.navigate().refresh();
    }
}
