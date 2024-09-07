package com.tmb.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class DriverFactory
{
    private DriverFactory(){}
    public static WebDriver getDriver(String browserName)
    {
        WebDriver driver;
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        else
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }
}
