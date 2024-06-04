package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingXPath {
    private static ChromeDriver chromeDriver;
    public static void openBrowser(){
         chromeDriver = new ChromeDriver();

        //To open the browser to get to specfic website//
        chromeDriver.get("https://www.ebay.com");
    }
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
            chromeDriver.quit();
    }
    public static void main(String[] args) throws InterruptedException {
        openBrowser();

        chromeDriver.findElement(By.xpath(" //button[@id='gh-shop-a']")).click();
        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath(" //input[@id='gh-ac']")).sendKeys("JAVA");
        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath(" //input[@id='gh-btn']")).click();
        chromeDriver.findElement(By.xpath("//i[text()='Notification']")).click();
        Thread.sleep(2000);


        closeBrowser();

    }
}
