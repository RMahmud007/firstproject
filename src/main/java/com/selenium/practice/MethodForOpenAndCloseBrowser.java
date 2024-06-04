package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodForOpenAndCloseBrowser {
    private static ChromeDriver chromeDriver;
    public static void openBrowser(){
        chromeDriver =new ChromeDriver();
        chromeDriver.get("https://www.ebay.com");
    }
    public static void closeBrowser(){
        chromeDriver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser();
        chromeDriver.findElement(By.xpath(" //button[@id='gh-shop-a']")).click();
        Thread.sleep(2000);
        chromeDriver.quit();
    }
}
