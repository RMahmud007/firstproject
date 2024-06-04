package com.selenium.tests;

import com.selenium.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;

public class EbayPractice extends TestBase {
    @Test (priority = 1,enabled = false)
    public void testEbay1(){
        clickUsingXpath("//button[@id='gh-shop-a']");
    }
    @Test (priority = 2,enabled = false)
    public void mouseHoverTest(){
        WebElement element = driver.findElement(By.linkText("Motors"));
        Actions actions =new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Cars & Trucks")).click();
    }
    @Test (priority = 3,enabled = false)
    public void scrollDownTest(){
        WebElement element= driver.findElement(By.linkText("Policies"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    @Test (priority = 4,enabled = false)
    public void scrolldownMinimum(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");
    }
    @Test (priority = 5,enabled = false)
    public void homeGarden() throws InterruptedException {
        clicklinkTest("Home & Garden");
        waitFor(3);
    }
    @Test (priority = 6,enabled = false)
    public void sellEBay() throws InterruptedException {
        clicklinkTest("Sell");
        waitFor(3);
    }
    @Test (priority = 7,enabled = false)
    public void stores() throws InterruptedException {
        clicklinkTest("Stores");
        waitFor(3);
    }
    @Test (priority = 8,enabled = false)
    public void buy() throws InterruptedException {
        clicklinkTest("Buy");
        waitFor(3);
    }
    @Test (priority = 9,enabled = false)
    public void businessSellers() throws InterruptedException {
        clicklinkTest("Business sellers");
        waitFor(3);
    }
    @Test (priority = 10,enabled = false)
    public void info() throws InterruptedException {
        clicklinkTest("Company info");
        waitFor(3);
    }
    @Test (priority = 11,enabled = false)
    public void withXpath(){
        clickUsingXpath("//button[@id='gh-shop-a']");
    }
    @Test (priority = 12, enabled = false)
    public void withXpathTwo(){
        clickUsingXpath("//input[@id='gh-btn']");
    }
    @Test (priority = 13)
    public void dropDown(){
        List<WebElement>  data =   driver.findElements(By.xpath("//select[@id='gh-cat']/option"));


        System.out.println(data);

        for (int i =0;i<data.size();i++){
            System.out.println(data.get(i).getText());
        }

        WebElement x = driver.findElement(By.linkText("Help & Contact"));
        System.out.println(x.getText());


    }

}
