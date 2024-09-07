package Listners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListnersTest
{
    @Test
    public void Testing() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
        //Assert.assertEquals(1,2);
        driver.quit();
    }

}
