//package TekionFramework;
//
//import com.tekioncloud.Pages.DuplicateArticleFunctionalityPages;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//public class TekionFrameworkTesting2
//{
//    WebDriver driver;
//    WebDriverWait wait;
//    @BeforeSuite
//    public void startUp()
//    {
//        ChromeOptions op = new ChromeOptions();
//        op.addArguments("--disable-notifications");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(op);
//        wait = new WebDriverWait(driver, 50);
//    }
//    public void click(WebElement element)
//    {
//        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//    }
//    @Test
//    public void testing() throws InterruptedException
//    {
//        DuplicateArticleFunctionalityPages obj = new DuplicateArticleFunctionalityPages(driver);
//        obj.username.sendKeys("accounting-controller@stage.com");
//        obj.loginButton.click();
//        wait.until(ExpectedConditions.visibilityOf(obj.password));
//        obj.password.sendKeys("Tekion@1234");
//        obj.loginButton.click();
//        Thread.sleep(20000);
//        obj.published.click();
//        Thread.sleep(3000);
//        obj.modifyDate.click();
//        Thread.sleep(3000);
//        System.out.println("These are the contents of the published file");
//        for (int i = 0; i < obj.data.size()-1; i++)
//        {
//            System.out.println(obj.headers.get(i).getText() + ":- " + obj.data.get(i).getText());
//        }
//        Thread.sleep(5000);
//        click(obj.dropDown);
//        click(obj.duplicateButton);
//        obj.draftPending.click();
//        Thread.sleep(3000);
//        obj.refreshButton.click();
//        Thread.sleep(3000);
//        System.out.println("These are the duplicate contents of the published file");
//        for (int i = 0; i < obj.data.size()-1; i++)
//        {
//            System.out.println(obj.headers.get(i).getText() + ":- " + obj.data.get(i).getText());
//        }
////        driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper']/input[@id='email']")).sendKeys("accounting-controller@stage.com");
////        driver.findElement(By.id("loginButton")).click();
////        WebDriverWait wait = new WebDriverWait(driver,50);
////        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ant-input-affix-wrapper']/input[@id='password']")));
////        driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper']/input[@id='password']")).sendKeys("Tekion@1234");
////        driver.findElement(By.id("loginButton")).click();
////        Thread.sleep(20000);
////        driver.findElement(By.xpath("//div[text()='Published']")).click();
////        Thread.sleep(3000);
////        driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header']//div[@tabindex='0'])[2]")).click();
////        Thread.sleep(4000);
////        List<WebElement> headers = driver.findElements(By.xpath("//div[@class='rt-thead -header']//div[@class='rt-th rt-resizable-header']"));
////        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='automation_selector_tr_row_0']//div[@class='rt-td']"));
////        for (int i = 0; i < elements.size()-1; i++)
////        {
////            System.out.println(headers.get(i).getText() + ":-" + elements.get(i).getText());
////        }
////        Thread.sleep(5000);
////        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'ant-dropdown')])[4]"))).click();
////        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Duplicate']"))).click();
////        driver.findElement(By.xpath("//div[text()='Draft / Review Pending']")).click();
////        Thread.sleep(3000);
////        driver.findElement(By.xpath("//button[contains(@class,'refreshIcon')]")).click();
////        Thread.sleep(4000);
////        List<WebElement> headers2 = driver.findElements(By.xpath("//div[@class='rt-thead -header']//div[@class='rt-th rt-resizable-header']"));
////        List<WebElement> elements2 = driver.findElements(By.xpath("//div[@id='automation_selector_tr_row_0']//div[@class='rt-td']"));
////        for (int i = 0; i < elements2.size()-1; i++)
////        {
////            System.out.println(headers2.get(i).getText() + ":-" + elements2.get(i).getText());
////        }
//    }
//}
