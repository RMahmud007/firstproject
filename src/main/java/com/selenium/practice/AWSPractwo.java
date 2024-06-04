package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AWSPractwo {
    private static WebDriver driver;

    public static void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://aws.amazon.com/");
    }

    public static void waitMethod(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        openBrowser();
        driver.findElement(By.linkText("About AWS")).click();
        waitMethod(2);
        closeBrowser();
    }
}
