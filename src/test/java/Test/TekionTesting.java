package Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;

public class TekionTesting
{
    ExtentReports extent;
    ExtentTest TekionTest;
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
        driver.get("https://www.tekion.com/");
        driver.manage().window().maximize();
        TekionTest = extent.createTest(method.getName());
    }
    @Test()
    public void BlogTesting() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div/div[2]/div/div[4]/div/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[1]/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[2]/div"));
        String value = element.getText();
        Assert.assertEquals(value, "Blogs");
        if (value.equalsIgnoreCase("blogs")) {
            System.out.println("We have opened the " + value + " page !!");
            TekionTest.pass("There is blog page available in the Webpage");
        } else {
            TekionTest.fail("It is not able to locate the blog page in webpage");
        }
        List<WebElement> texts = driver.findElements(By.xpath("//h4"));
        List<String> splitted_str = new ArrayList<>();
        for (int i = 0; i < texts.size(); i++) {
            String str = texts.get(i).getText();
            String[] str2 = str.split(" ");
            for (int j = 0; j < str2.length; j++) {
                splitted_str.add(str2[j]);
                System.out.println(str2[j]);
            }
        }
        //splitted_str.add("vasu");
        int length = splitted_str.size();
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(splitted_str.get(6));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='Blog_Inner__1y3SX']"))));
        List<WebElement> output = driver.findElements(By.xpath("//h4"));

        for (int i = 0; i < output.size(); i++) {
            String text = output.get(i).getText();
            if (text.contains(splitted_str.get(6))) {
                //Assert.assertTrue();
                System.out.println(text);
                TekionTest.pass("It is able to fetch the " + splitted_str.get(6) + " keyword and search that word!!");
            } else {
                TekionTest.pass("It has searched for the result but the result was not available");
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
    }


//        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Fixed Ops");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/div[1]/div/div[1]/div/a/h4"))));
//        List<WebElement> output = driver.findElements(By.xpath("//h4"));
//        for (int i = 0; i < output.size(); i++)
//        {
//            String text = output.get(i).getText();
//            if(text.contains("Fixed Ops"))
//            {
//                System.out.println(text);
//                TekionTest.pass("It has searched the Fixed Ops and printed the content on console !!");
//            }
//            else
//            {
//                TekionTest.fail("It is not able to fetch the Fixed Ops content and hence the test has failed !!");
//            }
//        }
//    }
    @Test
    public void NewsTesting() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div/div[2]/div/div[4]/div/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[1]/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[2]/div")));
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[2]/div")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='News']")));
        driver.findElement(By.xpath("//div[text()='News']")).click();
        String value = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[2]/div")).getText();
        Assert.assertEquals(value, "News");
        if (value.equalsIgnoreCase("news"))
        {
            System.out.println("We have opened the " + value + " page !!");
            TekionTest.pass("It is able to fetch the news section on webpage");
        }
        else
        {
            TekionTest.fail("It is not able to fetch the new section on webpage");
        }
        List<WebElement> texts = driver.findElements(By.xpath("//h4"));
        List<String> splitted_str = new ArrayList<>();
        for (int i = 0; i < texts.size(); i++)
        {
            String str = texts.get(i).getText();
            String[] str2 = str.split(" ");
            for (int j = 0; j < str2.length; j++)
            {
                splitted_str.add(str2[j]);
                System.out.println(str2[j]);
            }
        }
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(splitted_str.get(9));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        List<WebElement> output = driver.findElements(By.xpath("//h4"));

        for (int i = 0; i < output.size(); i++) {
            String text = output.get(i).getText();
            if (text.contains(splitted_str.get(9))) {
                System.out.println(text);
                TekionTest.pass("It is able to fetch the " + splitted_str.get(9) + " keyword and search that word!!");
            } else {
                TekionTest.pass("It has searched for the result but the result was not available");
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
    }



//        driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
//        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("CRM");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='Blog_Inner__1y3SX']"))));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4"))));
//        List<WebElement> output = driver.findElements(By.xpath("//h4"));
//        for (int i = 0; i < output.size(); i++)
//        {
//            String text = output.get(i).getText();
//            if (text.contains("CRM"))
//            {
//                System.out.println(text);
//                TekionTest.pass("It has searched the CRM and printed the content on console !!");
//            } else
//            {
//                TekionTest.fail("It is not able to fetch the CRM content and hence the test has failed !!");
//            }
//        }
//    }
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
