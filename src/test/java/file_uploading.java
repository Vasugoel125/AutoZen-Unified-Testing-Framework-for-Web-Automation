import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class file_uploading
{
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement fileupload = driver.findElement(By.id("uploadfile_0"));
        fileupload.sendKeys(System.getProperty("user.dir")+("/textupload.txt"));
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submitbutton")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
