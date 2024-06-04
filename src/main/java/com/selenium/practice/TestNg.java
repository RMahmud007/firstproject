package com.selenium.practice;

import net.bytebuddy.build.Plugin;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TestNg {
    public static WebDriver driver;
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
    @Test (priority = 1)
   public void test1() throws InterruptedException {
        openBrowser("chrome", "https://www.ebay.com");
        closeBrowser();
   }
   @Test (priority = 2)
    public void test2() throws InterruptedException {
        openBrowser("Firefox", "https://www.ebay.com");
        closeBrowser();
    }

}
