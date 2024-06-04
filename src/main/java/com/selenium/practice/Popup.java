package com.selenium.practice;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Popup extends TestNg{
    public static void clickUsingXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public static void clickUsingID(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public static void typeUsingXpath(String locator, String value){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    public static void typeUsingID(String locator, String value){
        driver.findElement(By.id(locator)).sendKeys(value);
    }
    @Test
    public void popUpTest() throws InterruptedException {
        openBrowser("chrome", "https://www.demo.guru99.com/test/delete_customer.php");

        typeUsingXpath("//input[@name='cusid']","1000");
        clickUsingXpath("//input[@name='submit']");
        Alert alert = driver.switchTo().alert();
        //To dismiss??//driver.switchTo().alert().dismiss();
        alert.accept();
        //TO see the popup message?//
        //String testOfAlert = driver.switchTo().alert().getText();
        //System.out.println(testOfAlert);
        closeBrowser();
    }

}
