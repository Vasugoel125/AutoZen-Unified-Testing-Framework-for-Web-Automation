package com.tekioncloud.KeshavTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass
{
    @FindBy(xpath = "//textarea[@title='Search']")
    public WebElement searchText;

    @FindBy(xpath = "//a[text()='हिन्दी']")
    public WebElement languageText;

    public PageClass(WebDriver driver) throws InterruptedException {
        PageFactory.initElements(driver,this);
        driver.get("https://www.google.co.in/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
}
