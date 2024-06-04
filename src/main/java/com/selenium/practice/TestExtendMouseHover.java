package com.selenium.practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestExtendMouseHover extends TestNg{
    @Test
    public void mouseHoverTest() throws InterruptedException {
        openBrowser("chrome", "https://www.ebay.com");

        WebElement element = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Cars & Trucks")).click();
        closeBrowser();
    }

}
