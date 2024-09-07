import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class newtesting
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement month = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        Select opt = new Select(month);
        opt.selectByIndex(11);
        Thread.sleep(2000);
        WebElement year = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        Select opt1 = new Select(year);
        opt1.selectByValue("2001");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='12']")).click();
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        WebElement fileupload = driver.findElement(By.id("uploadPicture"));
        fileupload.sendKeys(System.getProperty("user.dir")+("/textupload.txt"));
    }
}
