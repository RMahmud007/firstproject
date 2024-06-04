package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeWithMethod {
    private static ChromeDriver chromeDriver;
    public static void openBrowser(){
         chromeDriver = new ChromeDriver();

        //To open the browser to get to specfic website//
        chromeDriver.get("https://www.amazon.com");
    }
    public static void closeBrowser() throws InterruptedException {
            Thread.sleep(3000);
            chromeDriver.quit();
    }
    public static void main(String[] args) throws InterruptedException {
        openBrowser();

        chromeDriver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        Thread.sleep(3000);

        //to go back the browser
        chromeDriver.navigate().back();
        Thread.sleep(3000);

        //Using link//
        chromeDriver.findElement(By.linkText("Careers")).click();

        //to go back the browser
        chromeDriver.navigate().back();
        Thread.sleep(3000);

        //Using ID//
        chromeDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java");
        Thread.sleep(3000);

        //To search Java book
        chromeDriver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);

        //span[text()='java']

        closeBrowser();

    }
}
