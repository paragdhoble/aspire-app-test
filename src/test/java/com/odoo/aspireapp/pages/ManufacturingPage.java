package com.odoo.aspireapp.pages;

import com.odoo.aspireapp.base.BaseTest;
import com.odoo.aspireapp.wrapper.Wrappers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class ManufacturingPage extends BaseTest {

    @FindBy(xpath = "//*[contains(text(),'Create')]")
    public WebElement createBtn;

    @FindBy(xpath = "//*[@name='product_id']/div//input")
    public WebElement productName;

    @FindBy(xpath = "(//*[@name='product_qty'])[1]")
    public WebElement productqtyTxt;

    @FindBy(name = "action_confirm")
    public WebElement confirmBtn;

    @FindBy(xpath = "(//*[@name='qty_producing'])[1]")
    public WebElement quantityTxt;

    @FindBy(xpath = "(//*[text()='Mark as Done'])[2]")
    public WebElement makeAsDoneBtn;

    @FindBy(xpath = "//*[text()='Ok']")
    public WebElement okBtn;

    @FindBy(xpath = "//*[@title='Save record']")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[@title='Search for records']")
    public WebElement searchText;

    @FindBy(xpath = "//*[@class='o_menu_sections']//div[4]/button")
    public WebElement configurationMenu;

    @FindBy(xpath = "//*[@class='o_menu_sections']//div[3]/button")
    public WebElement reportingMenu;

    @FindBy(xpath = "//*[text()='Manufacturing']")
    public WebElement manufacturing;


    //@FindBy(xpath = "//*[text()='sample_product']//parent::td[1]/following-sibling::td[6])[1]")
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[11]/span")
    public WebElement productSearch;


    public void createOrder() {
        PageFactory.initElements(driver, this);
        Wrappers.clickOn(driver, createBtn);
        Wrappers.sendKeys(driver, productName, "Sample_Product");
        Wrappers.explicitWait(2);
        Wrappers.sendKeys(driver, productqtyTxt, "11");
        Wrappers.clickOn(driver, confirmBtn);
        Wrappers.explicitWait(3);
        Wrappers.sendKeyClear(driver ,quantityTxt);
        Wrappers.sendKeys(driver, quantityTxt, "11");
        Wrappers.clickOn(driver, makeAsDoneBtn);
        Wrappers.clickOn(driver, okBtn);
        Wrappers.clickOn(driver, saveBtn);
    }

    public void filter() {
        PageFactory.initElements(driver, this);
        Wrappers.explicitWait(1);
        Wrappers.sendKeyClear(driver , searchText);
        Wrappers.explicitWait(1);
    }

    public void manufacturingNavigation() {
        PageFactory.initElements(driver, this);
        Wrappers.clickOn(driver, manufacturing);
    }

    public void verifyOrder() {
        PageFactory.initElements(driver, this);
        SoftAssert softAssert = new SoftAssert();
        manufacturingNavigation();
        Wrappers.explicitWait(3);
        filter();
        String productName = productSearch.getText();
        softAssert.assertEquals(productName, "Done");

    }
}
