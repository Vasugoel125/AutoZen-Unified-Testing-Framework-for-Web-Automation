package TekionTestingPakage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StreamsPageObject extends PageFactory
{
    @FindBy(id = "menu-item-40")
    WebElement shop;

    @FindBy(xpath = "//h3")
    List<WebElement> lists;
    public StreamsPageObject(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        driver.get("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
    }
}
