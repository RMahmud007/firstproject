package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingURL {
    private static WebDriver driver;
    public static void openBrowser(String browserName, String url){
        if (browserName.equalsIgnoreCase("Firefox")){
            driver= new FirefoxDriver();
            driver.get(url);
        }else
            driver=new ChromeDriver();
        driver.get(url);
    }

    public static void closeBrowser() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser("chrome", "https://www.ebay.com");
        closeBrowser();
        openBrowser("Firefox", "https://www.ebay.com");
        closeBrowser();
    }

}
