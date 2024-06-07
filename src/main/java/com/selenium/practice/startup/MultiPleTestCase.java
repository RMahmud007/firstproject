package com.selenium.practice.startup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultiPleTestCase {
    public static WebDriver driver;
    public static void openBrowser(){
        driver =new ChromeDriver();
        driver.get("https://www.ebay.com");
    }
    public static void waitFor(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeBrowser(){
        waitFor(3);
        driver.quit();
    }
    @Test(priority = 1)
    public void test1() throws InterruptedException {
        openBrowser();
        driver.findElement(By.xpath(" //button[@id='gh-shop-a']")).click();
        closeBrowser();
    }
    @Test(priority = 2)
    public void test2() throws InterruptedException {
        openBrowser();
        WebElement element =driver.findElement(By.linkText("Policies"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
        closeBrowser();
    }
    @Test(priority = 3)
    public void test3() throws InterruptedException {
        openBrowser();
        WebElement element = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        closeBrowser();
    }
    @Test(priority = 4)
    public void test4() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Toys")).click();
        closeBrowser();
    }
    @Test(priority = 5)
    public void test5() throws InterruptedException {
        openBrowser();
        driver.findElement(By.id("gh-cat")).click();
        closeBrowser();
    }
    @Test(priority = 6)
    public void test6() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Daily Deals")).click();
        closeBrowser();
    }
    @Test(priority = 7)
    public void test7() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Policies")).click();
        closeBrowser();
    }
    @Test(priority = 8)
    public void test8() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Sign in")).click();
        closeBrowser();
    }
    @Test(priority = 9)
    public void test9() throws InterruptedException {
        openBrowser();
        driver.findElement(By.id("gh-p-4")).click();
        closeBrowser();
    }
    @Test(priority = 10)
    public void test10() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Sell")).click();
        closeBrowser();
    }
    @Test(priority = 11)
    public void test11() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Watchlist")).click();
        closeBrowser();
    }
    @Test(priority = 12)
    public void test12() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("register")).click();
        closeBrowser();
    }
    @Test(priority = 13)
    public void test13() throws InterruptedException {
        openBrowser();
        driver.findElement(By.id("gh-as-a")).click();
        closeBrowser();
    }
    @Test(priority = 14)
    public void test14() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("How to sell")).click();
        closeBrowser();
    }
    @Test(priority = 15)
    public void test15() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Company info")).click();
        closeBrowser();
    }
    @Test(priority = 16)
    public void test16() throws InterruptedException {
        openBrowser();
        driver.findElement(By.xpath("//i[text()='Notification']")).click();
        closeBrowser();
    }
    @Test(priority = 17)
    public void test17() throws InterruptedException {
        openBrowser();
        driver.findElement(By.xpath(" //input[@id='gh-btn']")).click();
        closeBrowser();
    }
    @Test(priority = 18)
    public void test18() throws InterruptedException {
        openBrowser();
        driver.findElement(By.xpath(" //input[@id='gh-ac']")).sendKeys("JAVA");
        closeBrowser();
    }
    @Test(priority = 19)
    public void test19() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Global Impact")).click();
        closeBrowser();
    }
    @Test(priority = 20)
    public void test20() throws InterruptedException {
        openBrowser();
        driver.findElement(By.linkText("Developers")).click();
        closeBrowser();
    }
}
