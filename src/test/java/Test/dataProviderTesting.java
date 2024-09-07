package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class dataProviderTesting
{
    private WebDriver driver;
//    @BeforeMethod
//    public void startup()
//    {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.manage().window().maximize();
//    }

    @DataProvider(parallel = false)
    public static Object[][] getData() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/cred.xlsx");
        FileInputStream inputStream= new FileInputStream(file);
        //System.out.println("This is the first test page");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int lastRow = sheet.getLastRowNum();
        System.out.println("lastRow = " + lastRow);
        String value = sheet.getRow(1).getCell(1).getStringCellValue();
        System.out.println("value = " + value);
        int lastcell = sheet.getRow(0).getLastCellNum();
        System.out.println("lastcell = " + lastcell);
        Object[][] a = new Object[lastRow][lastcell];
        for (int i = 1; i <=lastRow; i++)
        {
            for (int j = 0; j < lastcell; j++)
            {
                a[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return a;
    }

    //number of rows --> number of times it is going to run your test
    //number of columns --> number of parameters to your test method t


    @Test(dataProvider = "getData")
    public void dataprovidertest(String username,String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input")).sendKeys(username);
        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(password);
        Thread.sleep(3000);
//        driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button")).click();
//        Thread.sleep(2000);
        //String OriginalTitle = driver.getTitle();
//        if (OriginalTitle.equals("OrangeHRM"))
//        {
//            System.out.println("Successfull login");
//        }
//        else
//        {
//            System.out.println("Userid or password is incorrect");
//        }
        //Thread.sleep(2000);
        //driver.quit();
    }
//    @AfterMethod
//    public void tearDown()
//    {
//        driver.quit();
//    }
}
