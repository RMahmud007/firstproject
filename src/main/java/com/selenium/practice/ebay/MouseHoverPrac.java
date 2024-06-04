package com.selenium.practice.ebay;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseHoverPrac {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.ebay.com");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
    }
}
