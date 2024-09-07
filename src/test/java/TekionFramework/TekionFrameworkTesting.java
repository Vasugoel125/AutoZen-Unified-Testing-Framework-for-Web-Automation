package TekionFramework;

import com.tekioncloud.Methods.VerifyLocalRefreshMethod;
import com.tekioncloud.Pages.VerifyLocalRefreshPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TekionFrameworkTesting
{
    static WebDriver driver;
    WebDriverWait wait;
    @BeforeSuite
    public void startUp()
    {
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(op);
        wait = new WebDriverWait(driver,50);
    }
    public void click(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    @Test
    public void testing() throws InterruptedException {
        VerifyLocalRefreshPages obj = new VerifyLocalRefreshPages(driver);
//        VerifyLocalRefreshMethod obj1 = new VerifyLocalRefreshMethod();
        Thread.sleep(10000);
        obj.username.sendKeys("accounting-controller@stage.com");
        obj.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(obj.password));
        obj.password.sendKeys("Tekion@1234");
        obj.loginButton.click();
        Thread.sleep(15000);
        obj.modifyDate.click();
        Thread.sleep(3000);
        String date1 = obj.date.getText();
        System.out.println("These are the contents before updating the article");
        System.out.println(date1);
        String title1 = obj.title.getText();
        System.out.println(title1);
        String statusText1 = obj.status.getText();
        System.out.println(statusText1);
        click(obj.firstData);
        click(obj.saveAs);
        wait.until(ExpectedConditions.visibilityOf(obj.selectorWait));
        if(statusText1.equalsIgnoreCase("Draft"))
        {
            click(obj.selectorSelect);
            click(obj.reviewPending);

        }
        else if(statusText1.equalsIgnoreCase("Review Pending"))
        {
            click(obj.selectorSelect);
            click(obj.draft);
        }
        click(obj.saveButton);
        click(obj.discardButton);
        click(obj.refreshIcon);
        Thread.sleep(5000);
        click(obj.modifyDate);
        Thread.sleep(5000);
        System.out.println("These are the contents after updating the article");
        String date2 = obj.date.getText();
        System.out.println(date2);
        String title2 = obj.title.getText();
        System.out.println(title2);
        String statusText2 = obj.status.getText();
        System.out.println(statusText2);
//        driver.get("https://stageapp.tekioncloud.xyz/core/knowledge-base-admin/list");
//        driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper']/input[@id='email']")).sendKeys("accounting-controller@stage.com");
//        driver.findElement(By.id("loginButton")).click();
//        WebDriverWait wait = new WebDriverWait(driver,50);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ant-input-affix-wrapper']/input[@id='password']")));
//        driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper']/input[@id='password']")).sendKeys("Tekion@1234");
//        driver.findElement(By.id("loginButton")).click();
//        Thread.sleep(20000);
//
//        driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header']//div[@tabindex='0'])[2]")).click();
//
//        Thread.sleep(5000);
//        String date = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@id='automation_selector_tr_row_0']//div[@class='rt-td'])[6]")))).getText();
//        System.out.println(date);
//        String title = driver.findElement(By.xpath("//div[contains(@id,'tr_row_0')]//div[@id='title']")).getText();
//        System.out.println(title);
//        String statusText1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'tr_row_0')]//div[@class='core_label_label__fPnKtiGtmC']"))).getText();
//        System.out.println(statusText1);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@id,'tr_row_0')]//div[@class='rt-td'])[1]"))).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSalesSetupSave"))).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ant-select-selection__rendered'])[3]")));
//        if(statusText1.equalsIgnoreCase("Draft"))
//        {
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ant-select-selection__rendered'])[3]"))).click();
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@role='option'])[2]"))).click();
//        }
//        else if(statusText1.equalsIgnoreCase("Review Pending"))
//        {
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ant-select-selection__rendered'])[3]"))).click();
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@role='option'])[1]"))).click();
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'footerRightSection')]/button[contains(@class,'button_primaryButton')]"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='action-container undefined']/button[contains(@class,'button_secondaryButton')]"))).click();
//        Thread.sleep(5000);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'refreshIcon')]"))).click();
//        Thread.sleep(5000);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='rt-th rt-resizable-header']//div[@tabindex='0'])[2]"))).click();
//        Thread.sleep(5000);
//        String date2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@id='automation_selector_tr_row_0']//div[@class='rt-td'])[6]"))).getText();
//        System.out.println(date2);
//        String title2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'tr_row_0')]//div[@id='title']"))).getText();
//        System.out.println(title2);
//        String statusText2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'tr_row_0')]//div[@class='core_label_label__fPnKtiGtmC']"))).getText();
//        System.out.println(statusText2);
    }
}
