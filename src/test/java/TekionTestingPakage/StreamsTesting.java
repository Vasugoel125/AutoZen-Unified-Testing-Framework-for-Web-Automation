package TekionTestingPakage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class StreamsTesting
{
    ExtentReports extent;
    ExtentTest ShopLists;
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
        ShopLists = extent.createTest(method.getName());
    }

    @Test
    public void streamsTesting()
    {
        StreamsPageObject obj = new StreamsPageObject(driver);
        obj.shop.click();
        ShopLists.pass("It has successfully clicked on the shop link !!");
        List<String> totalItems = new ArrayList<>();
        obj.lists.stream().forEach(items -> totalItems.add(items.getText()));
        ShopLists.pass("It has successfully stored all the items in the list !!");
        System.out.println("Total number of items are:- " + totalItems.size());
        System.out.println("All the items name are as follows:- ");
        totalItems.forEach(names -> System.out.println(names));
        ShopLists.pass("Successfully printed all the items available on the webpage !!");
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
