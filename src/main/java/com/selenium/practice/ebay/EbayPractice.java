package com.selenium.practice.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayPractice {
    private static WebDriver driver;
    public static void openChrome(){
        driver =new ChromeDriver();
        driver.get("https://www.ebay.com/");
    }
    public static void waitMethod(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeChrome(){
        driver.quit();
    }

    public static void main(String[] args) {
        openChrome();
        driver.findElement(By.id("gh-ac")).sendKeys("fog lights");
        driver.findElement(By.id("gh-btn")).click();
        closeChrome();
    }
}
