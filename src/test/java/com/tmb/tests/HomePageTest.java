package com.tmb.tests;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest
{
    @Test(description = "To check whether the user is able to login into webpage")
    public void loginTest() throws InterruptedException
    {
        DriverManager.getDriver().findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input")).sendKeys("Admin");
        DriverManager.getDriver().findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
        DriverManager.getDriver().findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button")).click();
        Assert.assertEquals(DriverManager.getDriver().getTitle(),"OrangeHRM");
    }
}
