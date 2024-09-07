package com.tekioncloud.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyLocalRefreshMethod
{
    static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver,50);
    public void click(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void visibility(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
