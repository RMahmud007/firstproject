package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.ebay.com");

        chromeDriver.findElement(By.linkText("Sign in")).click();

        Thread.sleep(5000);

        chromeDriver.navigate().back();

        Thread.sleep(5000);
        chromeDriver.findElement(By.id("gh-ac")).sendKeys("Java Books");
        Thread.sleep(2000);
        chromeDriver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//button[@id='gh-shop-a']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//i[text()='Notification']")).click();
        Thread.sleep(2000);


        chromeDriver.quit();



    }
}
