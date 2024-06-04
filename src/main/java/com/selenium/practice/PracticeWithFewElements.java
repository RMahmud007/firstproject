package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeWithFewElements {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver chromeDriver = new ChromeDriver();

        //To open the browser to get to specfic website//
        chromeDriver.get("https://www.amazon.com");
        chromeDriver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        Thread.sleep(6000);

        //to go back the browser
        chromeDriver.navigate().back();
        Thread.sleep(6000);

        //Using link//
        chromeDriver.findElement(By.linkText("Careers")).click();

        //to go back the browser
        chromeDriver.navigate().back();
        Thread.sleep(6000);

        //Using ID//
        chromeDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java");
        Thread.sleep(6000);

        //To search Java book
        chromeDriver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(6000);

        chromeDriver.quit();
    }
}
