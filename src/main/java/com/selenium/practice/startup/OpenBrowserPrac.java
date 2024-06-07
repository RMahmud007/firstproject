package com.selenium.practice.startup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowserPrac {
    private static WebDriver driver;

    public static void openBrowser(String browserName) {
        if (browserName.equals("Firefox")) {
            driver = new FirefoxDriver();
            driver.get("https://www.ebay.com");
        } else {
            driver = new ChromeDriver();
            driver.get("https://www.ebay.com");
        }
    }

    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser("Firefox");

        driver.findElement(By.xpath(" //button[@id='gh-shop-a']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //input[@id='gh-ac']")).sendKeys("JAVA");
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //input[@id='gh-btn']")).click();


        closeBrowser();

        openBrowser("chrome");
        driver.findElement(By.xpath(" //button[@id='gh-shop-a']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //input[@id='gh-ac']")).sendKeys("JAVA");
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //input[@id='gh-btn']")).click();
        closeBrowser();

    }
}
