package SeleniumAssessments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.util.Scanner;

public class DropTesting
{
    public static void testing(WebDriver driver) throws InterruptedException {
        driver.get("https://letcode.in/dropable");
        driver.manage().window().maximize();
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,droppable).build().perform();
        Thread.sleep(3000);
        driver.close();
    }
    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the browser name:- ");
        String browser = sc.nextLine();
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        testing(driver);
    }
}
