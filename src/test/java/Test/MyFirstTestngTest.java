package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTestngTest
{
    WebDriver driver;
    @BeforeMethod
    public void loadpage()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test()
    public void VerifyWebpageTile() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button")).click();
        String OriginalTitle = driver.getTitle();
        String ExpectedTitle = "OrangeHRM";
        Assert.assertEquals(OriginalTitle,ExpectedTitle);
    }
    @Test
    public void VerifyPasswordError() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin1234");
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
        String value = driver.findElement(By.xpath("//div[@class = 'oxd-alert-content oxd-alert-content--error']")).getText();
        String expectederror = "Invalid credentials";
        Assert.assertEquals(value,expectederror);
    }
    @AfterMethod
    public void closepage()
    {
        driver.quit();
    }
}
