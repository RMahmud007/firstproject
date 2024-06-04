package com.selenium.practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;

public class FluentWaitPractice extends TestNg{
    @Test
    public void mouseHoverTest() throws InterruptedException {

       FluentWait wait= new FluentWait(driver);
       wait.withTimeout(Duration.of(10, SECONDS));
       wait.pollingEvery(Duration.of(250,MILLIS));
       wait.ignoring(NoSuchElementException.class);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Policies")));

        WebElement element =driver.findElement(By.linkText("Policies"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",element);

    }
}
