package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.Color;

import javax.swing.*;
import java.util.Scanner;

public class Assessment2
{
    public static void testing(WebDriver driver) throws InterruptedException
    {
        driver.get("https://letcode.in/buttons");
        driver.manage().window().maximize();
        driver.findElement(By.id("home")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        Point position = driver.findElement(By.id("position")).getLocation();
        System.out.println("Location of the button is:- " + position);
        String cssValue = driver.findElement(By.id("color")).getCssValue("color");
        String color = Color.fromString(cssValue).asHex();
        System.out.println("The color of the button is:- "+color);
        Dimension property = driver.findElement(By.id("property")).getSize();
        System.out.println("The size of the button is:- " + property);
        boolean isDisabled = driver.findElement(By.id("isDisabled")).isEnabled();
        System.out.println("The button is disabled or enabled:- " + isDisabled);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//button[@id='isDisabled'][@class='button is-primary']"))).build().perform();
        System.out.println("The button has been long pressed");
        Thread.sleep(3000);
        driver.close();
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the browser name:- ");
        String browser = sc.nextLine();
        WebDriver driver;
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        else
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        testing(driver);
    }
}
