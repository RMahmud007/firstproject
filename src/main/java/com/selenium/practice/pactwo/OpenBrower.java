package com.selenium.practice.pactwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.opentelemetry.semconv.ResourceAttributes.TelemetrySdkLanguageValues.JAVA;

public class OpenBrower {
    private static WebDriver driver;

    public static void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
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
        driver.findElement(By.id("gh-ac")).click();
        waitMethod(5);
        driver.findElement(By.id("gh-ac")).sendKeys("JAVA");
        waitMethod(5);
        driver.findElement(By.id("gh-btn")).click();
        waitMethod(5);
        closeBrowser();
    }
}
