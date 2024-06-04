package com.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowserstwo {
    private static WebDriver driver;
    public static void openBrowser(String browserName){
        if (browserName.equals("Firefox")){
            driver=new FirefoxDriver();
            driver.get("https://www.ebay.com");
        }else{
            driver=new ChromeDriver();
            driver.get("https://www.ebay.com");
        }
    }
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser("chrome");
        closeBrowser();
        openBrowser("Firefox");
        closeBrowser();
    }
}
