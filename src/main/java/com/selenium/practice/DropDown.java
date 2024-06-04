package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class DropDown {
    private static WebDriver driver;
    public static void openBrowser(String browserName, String url){
        if (browserName.equalsIgnoreCase("Firefox")){
            driver= new FirefoxDriver();
            driver.get(url);
        }else
            driver=new ChromeDriver();
        driver.get(url);
    }
public static void waitFor(int seconds)  {
    try {
        Thread.sleep(seconds*1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
    public static void closeBrowser() throws InterruptedException{
        waitFor(5);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser("chrome", "https://www.ebay.com");
        waitFor(2);

       List<WebElement> elements= (List<WebElement>) driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(elements.size());
        for (WebElement elem: elements){
            System.out.println(elem.getText());
        }
        closeBrowser();
    }

}
