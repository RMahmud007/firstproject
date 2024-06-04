package com.selenium.practice.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ElementsListPrac {
    private static WebDriver driver;
    public static void openChrome(){
        driver =new ChromeDriver();
        driver.get("https://www.ebay.com");
    }
    public static void waitFor(int seconds){
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
        List<WebElement> elements= (List<WebElement>) driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(elements.size());
        for (WebElement elem: elements){
            System.out.println(elem.getText());
        }
        waitFor(5);
        closeChrome();
    }
}
