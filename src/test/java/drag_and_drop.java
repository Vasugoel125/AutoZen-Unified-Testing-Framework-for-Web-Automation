import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class drag_and_drop
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(element);
        WebElement droppable = driver.findElement(By.id("draggable"));
        WebElement draggable = driver.findElement(By.id(("droppable")));
        //actions.clickAndHold(droppable).moveToElement(draggable).release().build().perform();
        actions.dragAndDrop(droppable,draggable).build().perform();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Resizable']")).click();
        driver.close();
    }
}
