package TekionTestingPakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObjects
{
    @FindBy(xpath = "//*[@id=\"__next\"]/div/header/div/div/div[2]/div/div[4]/div/div[1]/div[1]")
    WebElement more;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/header/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[1]/a")
    WebElement blogs;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[2]/div")
    WebElement blogText;

    @FindBy(xpath = "//h4")
    List<WebElement> texts;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search;

    @FindBy(xpath = "//div[@class='Blog_Inner__1y3SX']")
    WebElement waitXpath;

    @FindBy(xpath = "//h4")
    List<WebElement> output;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[2]/div")
    WebElement waitXpath2;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[2]/div")
    WebElement dropDown;

    @FindBy(xpath = "//div[text()='News']")
    WebElement newsWait;

    @FindBy(xpath = "//div[text()='News']")
    WebElement news;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[2]/div")
    WebElement newsText;

    public PageObjects(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        driver.get("https://www.tekion.com/");
        driver.manage().window().maximize();
    }

}
