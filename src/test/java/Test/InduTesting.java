package Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;

public class InduTesting
{
    public static ExtentReports extent;
    public static ExtentTest link_test;
    public static ExtentSparkReporter spark;
    @BeforeSuite
    public void beforesuite()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/index.html");
        extent.attachReporter(spark);
    }
    @BeforeMethod
    public void beforemethod(Method method)
    {
        link_test=extent.createTest(method.getName());
    }
    @Test
    public void implementation() throws InterruptedException, IOException, ParseException, FileNotFoundException, org.json.simple.parser.ParseException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://news.ycombinator.com/");
        link_test.pass("website loaded");
        String s=driver.getTitle();
        if(s.equalsIgnoreCase("Hacker news")) {
            System.out.println("yes it is the right website");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//a[normalize-space()='login']")).click();
            Thread.sleep(3000);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/kinduvadana/Desktop/credentials.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String name =(String) jsonObject.get("username");
            if(!name.isEmpty())
            {
                link_test.pass("username is presented");
            }
            else
            {
                link_test.fail("username is not presented");
            }
            String pwd = (String) jsonObject.get("password");
            if(!pwd.isEmpty())
            {
                link_test.pass("password is presented");
            }
            else
            {
                link_test.fail("password is not presented");
            }
            WebElement e =driver.findElement(By.xpath("//body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
            e.sendKeys(name);
            driver.findElement(By.xpath("//body[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")).sendKeys(pwd);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='login']")).click();
            link_test.pass("login successfully");
            Thread.sleep(3000);
        }
        else{
            System.out.println("This is wrong website");
        }

        driver.close();
    }
    @AfterSuite
    public void Aftersuite()
    {
        extent.flush();
    }
}
