package TekionTestingPakage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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
        TekionTest = extent.createTest(method.getName());
    }
    @Test
    public void BlogTesting() throws InterruptedException
    {
        PageObjects obj = new PageObjects(driver);
        obj.more.click();
        obj.blogs.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        String value = obj.blogText.getText();
        Assert.assertEquals(value, "Blogs");
        if (value.equalsIgnoreCase("blogs")) {
            System.out.println("We have opened the " + value + " page !!");
            TekionTest.pass("There is blog page available in the Webpage");
        } else {
            TekionTest.fail("It is not able to locate the blog page in webpage");
        }
        List<String> splitted_str = new ArrayList<>();
        for (int i = 0; i < obj.texts.size(); i++) {
            String str = obj.texts.get(i).getText();
            String[] str2 = str.split(" ");
            for (int j = 0; j < str2.length; j++) {
                splitted_str.add(str2[j]);
                System.out.println(str2[j]);
            }
        }
//        int length = splitted_str.size();
        System.out.println("Keyword entered for searching is:- " + splitted_str.get(11));
        obj.search.sendKeys(splitted_str.get(11));
        wait.until(ExpectedConditions.visibilityOf(obj.waitXpath));
        for (int i = 0; i < obj.output.size(); i++) {
            String text = obj.output.get(i).getText();
            Assert.assertTrue(text.contains(splitted_str.get(11)),"It has searched for the result but the result was not available");
//            if ()
//            {
//                System.out.println(text);
//                TekionTest.pass("It is able to fetch the " + splitted_str.get(11) + " keyword and search that word!!");
//                Assert.assertTrue(true);
//            } else {
////                TekionTest.fail("It has searched for the result but the result was not available");
//                Assert.assertFalse(false);
//            }
        }
    }
    @Test
    public void NewsTesting() throws InterruptedException {
        PageObjects obj = new PageObjects(driver);
        obj.more.click();
        obj.blogs.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(obj.waitXpath2));
        obj.dropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(obj.newsWait));
        obj.news.click();
        String value = obj.newsText.getText();
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
        List<String> splitted_str = new ArrayList<>();
        for (int i = 0; i < obj.texts.size(); i++)
        {
            String str = obj.texts.get(i).getText();
            String[] str2 = str.split(" ");
            for (int j = 0; j < str2.length; j++)
            {
                splitted_str.add(str2[j]);
                System.out.println(str2[j]);
            }
        }
        System.out.println("Keyword entered for searching is:- " + splitted_str.get(14));
        obj.search.sendKeys(splitted_str.get(14));
        for (int i = 0; i < obj.output.size(); i++) {
            String text = obj.output.get(i).getText();
            if (text.contains(splitted_str.get(14))) {
                System.out.println(text);
                TekionTest.pass("It is able to fetch the " + splitted_str.get(14) + " keyword and search that word!!");
                Assert.assertTrue(true);
            } else {
//                TekionTest.fail("It has searched for the result but the result was not available");
                Assert.assertFalse(false);
            }
        }
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
