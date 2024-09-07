package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Scanner;

public class Assessment
{
    public static void testing(WebDriver driver) throws InterruptedException {
        driver.get("https://letcode.in/test");
        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Edit']"))));
        Thread.sleep(2000);
        WebElement EditElement = driver.findElement(By.xpath("//a[text()='Edit']"));
        EditElement.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("Vasu Goel");
        driver.findElement(By.xpath("//input[@id='join']")).sendKeys(Keys.ARROW_LEFT+" appended");
        driver.findElement(By.xpath("//input[@id='join']")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//input[@id='getMe']")).getAttribute("value");
        System.out.println("text = " + text);
        driver.findElement(By.xpath("//input[@id='clearMe']")).clear();
        boolean enabled = driver.findElement(By.xpath("//input[@id='noEdit']")).isEnabled();
        System.out.println("The element is enabled or not:- " + enabled);
        String dontwrite = driver.findElement(By.id("dontwrite")).getAttribute("value");
        driver.findElement(By.id("dontwrite")).sendKeys("Trying to edit");
        String dontwrite2 = driver.findElement(By.id("dontwrite")).getAttribute("value");
        if(dontwrite.equalsIgnoreCase(dontwrite2))
        {
            System.out.println("The text field is in readonly mode");
        }
        else
        {
            System.out.println("The text field is not in readonly mode");
        }
        //Assert.assertEquals(dontwrite,dontwrite2);
        Thread.sleep(2000);
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
