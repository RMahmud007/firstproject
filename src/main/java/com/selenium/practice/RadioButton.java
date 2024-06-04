package com.selenium.practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class RadioButton extends TestNg{
    @Test
    public void exampleOfRadioButton() throws InterruptedException {
        openBrowser("chrome","https://materializecss.com/radio-buttons.html");
        List<WebElement>radioButtons=driver.findElements(By.xpath("//form//input[@type='radio'}"));
        //clickUsingXpath("//span[text()='Yellow'])[1]");
        List<WebElement> valueOfRadioButtons=driver.findElements(By.xpath("//form//input[@type='radio']/following-sibling::span"));
        for (int i=0; i<radioButtons.size();i++){
            String value = valueOfRadioButtons.get(i).getText();
            boolean isButtonSelected = radioButtons.get(i).isSelected();
            System.out.println(value+ " - "+ isButtonSelected);
        }
        closeBrowser();
    }

}
