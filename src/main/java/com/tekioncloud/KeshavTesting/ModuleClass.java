package com.tekioncloud.KeshavTesting;

import org.openqa.selenium.WebDriver;

public class ModuleClass
{
    public void performGoogleOperations(WebDriver driver) throws InterruptedException {
        PageClass pageClass = new PageClass(driver);
//        pageClass.searchText.click();
//        pageClass.searchText.sendKeys("Vasu Goel");
        pageClass.languageText.click();
        Thread.sleep(10000);
    }
}