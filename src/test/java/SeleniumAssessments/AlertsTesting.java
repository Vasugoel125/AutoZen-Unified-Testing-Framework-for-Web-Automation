package SeleniumAssessments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Scanner;

public class AlertsTesting
{
    public static void testing(WebDriver driver) throws InterruptedException
    {
        driver.get("https://letcode.in/alert");
        driver.manage().window().maximize();
        driver.findElement(By.id("accept")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirm")).click();
        Thread.sleep(2000);
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        System.out.println("text = " + text);
        driver.findElement(By.id("prompt")).click();
        driver.switchTo().alert().sendKeys("Vasu Goel");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("modern")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='modal-close is-large']")).click();
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
