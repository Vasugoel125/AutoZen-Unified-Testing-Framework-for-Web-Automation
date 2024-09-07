package com.tmb.driver;

import com.tmb.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public final class Driver
{
    private Driver(){}

    public static void initDriver()
    {
        String Browser = ConfigFactory.getConfig().browser();
        System.out.println(Browser);
        WebDriver driver = DriverFactory.getDriver(Browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
        DriverManager.getDriver().get(ConfigFactory.getConfig().url());
    }

    public static void quitDriver()
    {
        DriverManager.getDriver().quit();
    }
}
