package com.selenium.practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestExtendSelectDropDown extends TestNg{
    @Test
    public void test1() throws InterruptedException {
        openBrowser("chrome", "https://www.ebay.com");

        WebElement element = driver.findElement(By.id("gh-cat"));
        Select select = new Select(element);
        select.selectByIndex(2);
        select.selectByVisibleText("Baby");
        select.selectByValue("281");
        closeBrowser();
    }

}
