package Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class extentReportTest
{
    ExtentReports extent;
    ExtentTest myFirstTest;
    WebDriver driver;
    @BeforeSuite
    public void beforeSuit()
    {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void startUp(Method method)   // Reflections in java
    {
        myFirstTest = extent.createTest(method.getName());
       //myFirstTest = extent.createTest("MyFirstTest");
    }
    @Test
    public void testing1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        myFirstTest.pass("URL loaded successfully");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input")).sendKeys("Admin");
        myFirstTest.pass("Username addedd successfully");
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
        myFirstTest.fail("Password entered successfully");
        Assert.assertEquals(1,2);
        myFirstTest.pass("The first test case has passed");
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void testing2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        myFirstTest.pass("URL loaded successfully");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input")).sendKeys("Admin");
        myFirstTest.pass("Username addedd successfully");
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
        myFirstTest.pass("Password entered successfully");
        myFirstTest.pass("The second test case also got passed");

        Thread.sleep(2000);
        driver.quit();
    }

    @AfterSuite
    public void afterSuit()
    {
        extent.flush();
    }
}
