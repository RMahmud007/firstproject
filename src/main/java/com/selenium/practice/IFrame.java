package com.selenium.practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IFrame extends TestNg{
    @Test
    public void iFrameTest() throws InterruptedException {
        openBrowser("chrome", "https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        WebElement element = driver.findElement(By.id("sampleHeading"));
        System.out.println(element.getText());
        closeBrowser();
    }

}
