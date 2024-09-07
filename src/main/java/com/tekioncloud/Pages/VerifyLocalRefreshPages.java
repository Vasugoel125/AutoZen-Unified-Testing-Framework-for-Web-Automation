package com.tekioncloud.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLocalRefreshPages
{
    @FindBy(xpath = "//span[@class='ant-input-affix-wrapper']/input[@id='email']")
    public WebElement username;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='ant-input-affix-wrapper']/input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "(//div[@class='rt-th rt-resizable-header']//div[@tabindex='0'])[2]")
    public WebElement modifyDate;

    @FindBy(xpath = "(//div[@id='automation_selector_tr_row_0']//div[@class='rt-td'])[6]")
    public WebElement date;

    @FindBy(xpath = "//div[contains(@id,'tr_row_0')]//div[@id='title']")
    public WebElement title;

    @FindBy(xpath = "//div[contains(@id,'tr_row_0')]//div[@class='core_label_label__fPnKtiGtmC']")
    public WebElement status;

    @FindBy(xpath = "(//div[contains(@id,'tr_row_0')]//div[@class='rt-td'])[1]")
    public WebElement firstData;

    @FindBy(id = "btnSalesSetupSave")
    public WebElement saveAs;

    @FindBy(xpath = "(//div[@class='ant-select-selection__rendered'])[3]")
    public WebElement selectorWait;

    @FindBy(xpath = "(//div[@class='ant-select-selection__rendered'])[3]")
    public WebElement selectorSelect;

    @FindBy(xpath = "(//li[@role='option'])[2]")
    public WebElement reviewPending;

    @FindBy(xpath = "(//li[@role='option'])[1]")
    public WebElement draft;

    @FindBy(xpath = "//div[contains(@class,'footerRightSection')]/button[contains(@class,'button_primaryButton')]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='action-container undefined']/button[contains(@class,'button_secondaryButton')]")
    public WebElement discardButton;

    @FindBy(xpath = "//button[contains(@class,'refreshIcon')]")
    public WebElement refreshIcon;

    public VerifyLocalRefreshPages(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        driver.get("https://stageapp.tekioncloud.xyz/core/knowledge-base-admin/list");
        driver.manage().window().maximize();
    }
}
