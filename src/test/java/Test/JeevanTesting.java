package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

public class JeevanTesting
{
    WebDriver driver;
    @BeforeMethod
    public void startUp(Method method)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/s?k=macbook&i=electronics&crid=1R7P5TMRTV8ZN&sprefix=macboo%2Celectronics%2C289&ref=nb_sb_noss_2");
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative puis-include-content-margin puis s-latency-cf-section s-card-border']"));
        for (int i = 3; i < elements.size(); i++)
        {
            String text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div["+i+"]/div/div/div/div/div"))).getText();
            System.out.println(text);
            if(text.contains("Sponsored"))
            {
                System.out.println("Yes");
            }
            else
            {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div["+i+"]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))).click();
                System.out.println("No");
                break;
            }
        }
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"add-to-cart-button\"]"))).click();
        Thread.sleep(3000);
        //driver.switchTo().frame(0);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]"))).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nav-cart-count-container\"]"))).click();
        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(\"//*[@id=\\\"attach-close_sideSheet-link\\\"]\"))).click();")))).click();
    }
}
