package com.tekioncloud.Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DuplicateArticleFunctionalityPages extends PageFactory
{
    @FindBy(xpath = "//span[@class='ant-input-affix-wrapper']/input[@id='email']")
    public WebElement username;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='ant-input-affix-wrapper']/input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//div[text()='Published']")
    public WebElement published;

    @FindBy(xpath = "(//div[@class='rt-th rt-resizable-header']//div[@tabindex='0'])[2]")
    public WebElement modifyDate;

    @FindBy(xpath = "//div[@class='rt-thead -header']//div[@class='rt-th rt-resizable-header']")
    public List<WebElement> headers;

    @FindBy(xpath = "//div[@id='automation_selector_tr_row_0']//div[@class='rt-td']")
    public List<WebElement> data;

    @FindBy(xpath = "(//div[contains(@class,'ant-dropdown')])[4]")
    public WebElement dropDown;

    @FindBy(xpath = "//div[text()='Duplicate']")
    public WebElement duplicateButton;

    @FindBy(xpath = "//div[text()='Draft / Review Pending']")
    public WebElement draftPending;

    @FindBy(xpath = "//button[contains(@class,'refreshIcon')]")
    public WebElement refreshButton;

    public DuplicateArticleFunctionalityPages(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        driver.get("https://stageapp.tekioncloud.xyz/core/knowledge-base-admin/list");
        driver.manage().window().maximize();
    }
}
