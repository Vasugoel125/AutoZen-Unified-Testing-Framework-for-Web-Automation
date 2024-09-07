package Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

public class AmazonTesting
{
    ExtentReports extent;
    ExtentTest AmazonTest;
    WebDriver driver;
    @BeforeSuite
    public void beforeSuit()
    {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
        extent.attachReporter(spark);
    }
    @BeforeMethod
    public void startUp(Method method)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        AmazonTest = extent.createTest(method.getName());
    }

    @Test
    public void Testing()
    {
        AmazonTest.pass("Amazon webpage loaded successfully");
        driver.findElement(By.id("nav-hamburger-menu")).click();
        AmazonTest.pass("It has clicked on the hamburger menu successfully");
        driver.findElement(By.xpath("//a[@class = 'hmenu-item']/div[text() = 'Mobiles, Computers' ]/following-sibling::i[@class = 'nav-sprite hmenu-arrow-next']")).click();
        AmazonTest.pass("It has clicked the \"Mobiles, Computer\" section successfully");
        driver.findElement(By.linkText("Laptops")).click();
        AmazonTest.pass("It has clicked on the Laptop section successfully");
        driver.findElement(By.linkText("Apple")).click();
        AmazonTest.pass("It has clicked on the Apple checkbox successfully");
        driver.findElement(By.xpath("//span[@class = 'a-dropdown-prompt']")).click();
        driver.findElement(By.linkText("Price: High to Low")).click();
        AmazonTest.pass("It has selected the \"High to Low\" preference successfully");
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        for(int i=0;i<elements.size();i++)
        {
            System.out.println(elements.get(i).getText());
        }
        AmazonTest.pass("It has successfully printed all the prices of the items displaying in url");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
    @AfterSuite
    public void afterSuit()
    {
        extent.flush();
    }
}
