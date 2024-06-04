package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AWSPrac {
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

    public static void closebrowser() {
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Products")).click();
        driver.switchTo().defaultContent();
        waitMethod(2);
        closebrowser();
    }

}
