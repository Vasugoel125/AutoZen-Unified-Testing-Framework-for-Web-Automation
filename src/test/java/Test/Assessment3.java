package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.Scanner;

public class Assessment3
{
    public static void testing(WebDriver driver) throws InterruptedException
    {
        driver.get("https://www.tekion.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div/div[2]/div/div[3]/a")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        List<WebElement> Names = driver.findElements(By.xpath("//div[@class='testimonials_Heading__cWYQ_']/following-sibling::div//b"));
        List<WebElement> Texts = driver.findElements(By.xpath("//div[@class='testimonials_Heading__cWYQ_']//p"));
        for (int i = 0; i < Names.size(); i++)
        {
            System.out.println(i+1 + ". " + Names.get(i).getText() + ":- " + Texts.get(i).getText());
        }
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
