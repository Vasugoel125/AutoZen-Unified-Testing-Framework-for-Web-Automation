package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class javascriptExecutorTesting
{
    private WebDriver driver;
    @BeforeMethod

    public void startup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.in");
        driver.manage().window().maximize();
    }
    @Test
    public void performtask() throws IOException {
        WebElement element = driver.findElement(By.xpath("//a[text()='About Us']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(driver -> {
            return element;
        });
        js.executeScript("arguments[0].click();",element);

        //Thread.sleep(2000);
        //js.executeScript("alert('Welcome to the first testing alert window');");
        //Thread.sleep(3000);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/abcd.png");
        FileUtils.copyFile(source,target);
//        Thread.sleep(2000);
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
