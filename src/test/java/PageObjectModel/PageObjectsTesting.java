package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsTesting extends PageFactory
{
    //public WebDriver driver;
    @FindBy(id ="fullName")
    WebElement fullname;

    @FindBy(id = "join")
    WebElement appendtext;

    @FindBy(id = "getMe")
    WebElement getvalue;

    @FindBy(id = "clearMe")
    WebElement clearvalue;

    public PageObjectsTesting(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        driver.get("https://letcode.in/edit");
        driver.manage().window().maximize();
    }
}
