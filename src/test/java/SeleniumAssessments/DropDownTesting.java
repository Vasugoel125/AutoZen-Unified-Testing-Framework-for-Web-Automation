package SeleniumAssessments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class DropDownTesting
{
    public static void testing(WebDriver driver) throws InterruptedException {
        driver.get("https://letcode.in/dropdowns");
        driver.manage().window().maximize();
        Select fruit = new Select(driver.findElement(By.id("fruits")));
        fruit.selectByVisibleText("Apple");
        Select superHero = new Select(driver.findElement(By.id("superheros")));
        if(superHero.isMultiple())
        {
            superHero.selectByValue("ta");
            superHero.selectByValue("im");
            superHero.selectByValue("sm");
        }
        Select language = new Select(driver.findElement(By.id("lang")));
        List<WebElement> options = language.getOptions();
        System.out.println("The options are mentioned below:- ");
        for (int i = 0; i < options.size(); i++)
        {
            System.out.println(options.get(i).getText());
        }
        language.selectByIndex(4);
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByValue("India");
        WebElement firstSelectedOption = country.getFirstSelectedOption();
        System.out.println("The selected option is:- " + firstSelectedOption.getText());
        Thread.sleep(3000);
        driver.close();
    }
    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the browser name:- ");
        String browser = sc.nextLine();
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        testing(driver);
    }
}
