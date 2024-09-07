package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AanchalTesting
{
    @Test(dataProvider = "airline")
    public void TestChrome(String a1) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // Maximize browser
        driver.manage().window().maximize();
        // Load application
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.findElement(By.xpath("//a[text()='Flights']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='radio'][@value='roundtrip']")).click();
        driver.findElement(By.xpath("//select[@name='passCount']//option[@value='3']")).click();
        driver.findElement(By.xpath("//select[@name=\"fromMonth\"]//option[@value=\"12\"]")).click();
        driver.findElement(By.xpath("//select[@name=\"fromDay\"]//option[@value=\"28\"]")).click();
        driver.findElement(By.xpath("//select[@name=\"toPort\"]//option[@value=\"London\"]")).click();
        driver.findElement(By.xpath("//select[@name=\"toMonth\"]//option[@value=\"1\"]")).click();
        driver.findElement(By.xpath("//select[@name=\"toDay\"]//option[@value=\"28\"]")).click();
        driver.findElement(By.xpath("//input[@value='First']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@name='airline']//option[text()='"+a1+"']")).click();
    }
    //a1="bfojxgjof"
    @DataProvider(name = "airline")
    public Object[][] TestDataFeed()
    {
        Object[][] data = new Object[2][1];
        data[0][0] = "Unified Airlines";
        data[1][0] = "Blue Skies Airlines";
        return data;
    }
}
