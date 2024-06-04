package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollDownLittleBit extends TestNg{

    public void scrollDownTest() throws InterruptedException {
        openBrowser("chrome", "https://www.ebay.com");
        WebElement element = driver.findElement(By.linkText("Policies"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        closeBrowser();
    }

}
