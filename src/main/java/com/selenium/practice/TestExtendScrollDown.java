package com.selenium.practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestExtendScrollDown extends TestNg{
    @Test
    public void mouseHoverTest() throws InterruptedException {
        openBrowser("chrome", "https://www.ebay.com");
        WebElement element =driver.findElement(By.linkText("Policies"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
        closeBrowser();
    }

}
