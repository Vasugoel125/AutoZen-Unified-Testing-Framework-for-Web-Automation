package KeshavTesting;

import com.tekioncloud.KeshavTesting.ModuleClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Options;
import org.bouncycastle.math.raw.Mod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass
{
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test()
    public void testingTheHierarchy() throws InterruptedException {
        ModuleClass moduleClass = new ModuleClass();
        moduleClass.performGoogleOperations(driver);
        Thread.sleep(4000);
    }
}
