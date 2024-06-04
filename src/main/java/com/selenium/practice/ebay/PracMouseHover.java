package com.selenium.practice.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PracMouseHover {
    private static WebDriver driver;
    public static void openChrome(){
        driver =new ChromeDriver();
        driver.get("https://www.ebay.com/");
    }
    public static void waitMethod(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeChrome(){
        driver.quit();
    }

    public static void main(String[] args) {
        openChrome();
        WebElement element = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Cars & Trucks")).click();
        waitMethod(2);
        closeChrome();
    }
}
