package com.selenium.practice;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunchPracFour {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver chromeDriver =new ChromeDriver();
        chromeDriver.get("https://www.ebay.com");
        Thread.sleep(2000);
        chromeDriver.quit();
    }
}
