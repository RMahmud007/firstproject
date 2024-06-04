package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingXPathPracThree {
    private static ChromeDriver chromeDriver;
    public static void openBrowser(){
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.ebay.com");
    }
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        chromeDriver.quit();
    }

    public static void main(String[] args) {
        openBrowser();
        chromeDriver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("JAVA");
        chromeDriver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        chromeDriver.quit();
    }
}
