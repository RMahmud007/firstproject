package com.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowsersthree {
    private static WebDriver driver;
    public static void openbrowser(String browserName){
        if (browserName.equals("Firefox")){
            driver =new FirefoxDriver();
            driver.get("https://www.ebay.com");
        }else {
            driver=new ChromeDriver();
            driver.get("https://www.ebay.com");
        }
    }

    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openbrowser("chrome");
        closeBrowser();
        openbrowser("Firefox");
        closeBrowser();
    }
}
