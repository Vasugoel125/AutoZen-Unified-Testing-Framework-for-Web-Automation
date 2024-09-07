package PageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageEditTesting
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
//        driver.get("https://letcode.in/edit");
        PageObjectsTesting obj = new PageObjectsTesting(driver);
        obj.fullname.sendKeys("Vasu");
        obj.appendtext.sendKeys(Keys.ARROW_RIGHT + " appended" + Keys.TAB);
        String value = obj.getvalue.getAttribute("value");
        System.out.println("value = " + value);
        obj.clearvalue.clear();
        Thread.sleep(3000);
        driver.close();
    }
}
