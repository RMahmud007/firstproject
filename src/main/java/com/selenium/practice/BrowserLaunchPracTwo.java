package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunchPracTwo {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver chromeDriver =new ChromeDriver();
        chromeDriver.get("https://www.ebay.com");
        chromeDriver.findElement(By.id("gh-ac")).sendKeys("JAVA");
        Thread.sleep(5000);
        chromeDriver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);

        chromeDriver.quit();
    }
}
