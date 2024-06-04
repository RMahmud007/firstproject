package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

// create a static method which will open a browser and navigate to jetblue.com and make sure this runs before running any test

// create a static method which will close browser and make sure this runs after running any test

// create a test method which will accept all cookies if displayed
// select from, to, depart return and search for flights
public class JetBlue {
    private static ChromeDriver chromeDriver;
    public static void openBrowser(){
        chromeDriver =new ChromeDriver();
        chromeDriver.get("https://www.jetblue.com/");
    }
    public static void closeBrowser(){
        chromeDriver.close();
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser();
        Thread.sleep(5000);
        chromeDriver.switchTo().frame("trustarc_cm");
        chromeDriver.findElement(By.xpath("//a[text()='Accept All Cookies']")).click();
        chromeDriver.switchTo().defaultContent();
        chromeDriver.findElement(By.xpath("//dot-city-selector[@data-qaid='fromAirport']//input")).sendKeys("New York City area (NYC)");
        chromeDriver.findElement(By.xpath("//dot-city-selector[@data-qaid='toAirport']//input")).sendKeys("Detroit, MI (DTW)");

        //click on depart button
        chromeDriver.findElement(By.xpath("//jb-date-picker-input[@data-qaid='departDateInput']//input")).sendKeys("11/02/2024");
        chromeDriver.findElement(By.xpath("//jb-date-picker-input[@data-qaid='returnDateInput']//input")).sendKeys("12/02/2024");
        chromeDriver.findElement(By.xpath("//div[contains(@class,'last-month')]//span[text()='8']")).click();
        chromeDriver.findElement(By.xpath("//span[text()='Search flights']")).click();
        Thread.sleep(6000);
        chromeDriver.close();
    }


}
