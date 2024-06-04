package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterMethod extends TestNg{
    @BeforeMethod (alwaysRun = true)
    public void startTest(){
        openBrowser("chrome", "https://www.ebay.com");
    }
    @AfterMethod (alwaysRun = true)
    public void finishTest() throws InterruptedException {
            closeBrowser();
    }
    //Nothing Change
    @Test//(priority = 1)
    public void mouseHover(){
        WebElement element =driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        waitFor(5);
        driver.findElement(By.linkText("Cars & Trucks")).click();
    }

}
