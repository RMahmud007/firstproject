package com.selenium.practice;

import org.testng.annotations.Test;

import static com.selenium.practice.Popup.typeUsingID;

public class FileUploadTest extends TestNg{
    @Test
    public void fileUploadTest() throws InterruptedException {
        openBrowser("chrome", "https://demo.guru99.com/test/upload/");
        String prefixOfPath =System.getProperty("user.dir");
        System.out.println(prefixOfPath);
        typeUsingID("uploadfile_0", prefixOfPath+"/src/main/resources/img.png");
        closeBrowser();
    }

}
