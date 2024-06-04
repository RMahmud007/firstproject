package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MethodForWaitTime {
    private static WebDriver driver;
    public static void openBrowser(String browserName, String url){
        if (browserName.equalsIgnoreCase("Firefox")){
            driver= new FirefoxDriver();
            driver.get(url);
        }else
            driver=new ChromeDriver();
        driver.get(url);
    }
public static void waitFor(int second)  {
    try {
        Thread.sleep(second*1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
    public static void closeBrowser() throws InterruptedException{
        waitFor(5);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser("chrome", "https://www.ebay.com");
        waitFor(2);
        driver.findElement(By.xpath(" //button[@id='gh-shop-a']")).click();
        waitFor(2);
        driver.findElement(By.xpath(" //input[@id='gh-ac']")).sendKeys("JAVA");
        waitFor(2);
        driver.findElement(By.xpath(" //input[@id='gh-btn']")).click();

        closeBrowser();
        openBrowser("Firefox", "https://www.ebay.com");
        waitFor(5);
        closeBrowser();
    }

}
