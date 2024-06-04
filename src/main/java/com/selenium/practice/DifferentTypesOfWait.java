package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static com.selenium.practice.TestNg.driver;


public class DifferentTypesOfWait {
    public void staticWait(int seconds){
        try {
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void implicityWait(){

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void pageLoadWait(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public void explicitWait(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cars & Trucks")));
        driver.findElement(By.linkText("Cars & Trucks")).click();
    }
}
