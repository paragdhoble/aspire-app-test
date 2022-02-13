package com.odoo.aspireapp.pages;

import com.odoo.aspireapp.base.BaseTest;
import com.odoo.aspireapp.wrapper.Wrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Watchable;

public class InventoryPage extends BaseTest {

    @FindBy(xpath = "//div[contains(text(),'Inventory')]")
    public WebElement inventory;

    @FindBy(xpath = "//*[contains(text(),'Products')]")
    public WebElement productLinkHP;

    @FindBy(xpath = "//html/body/header/nav/div[1]/div[2]/div/a[1]")
    public WebElement productLinkDropDown;

    @FindBy(xpath = "//*[contains(text(),'Create')]")
    public WebElement createProduct;

    @FindBy(xpath = "//input[@id='o_field_input_11']")
    public WebElement productName;

    @FindBy(xpath = "//*[contains(text(),'Save')]")
    public WebElement saveButton;

    @FindBy(xpath="//*[contains(text(),'Create')]")
    public WebElement createBtn;

    @FindBy(xpath="//*[@name='name']")
    public WebElement productNameTxt;

    @FindBy(xpath="//*[@title='Save record']")
    public WebElement saveBtn;

    @FindBy(xpath="//*[text()='Update Quantity']")
    public WebElement updateQuantityLink;

    @FindBy(name="inventory_quantity")
    public WebElement countedQuantity;


    public void navigateToInventory() {
        PageFactory.initElements(driver, this);
        Wrappers.clickOn(driver , inventory);
        //inventory.click();

    }

    public void newProductCreation () {
        PageFactory.initElements(driver, this);
        Wrappers.clickOn(driver ,productLinkHP);
        Wrappers.clickOn(driver , productLinkDropDown);
        Wrappers.clickOn(driver , createProduct);
        Wrappers.sendKeys(driver,productName ,"Sample_Product");
        Wrappers.clickOn(driver , saveButton);
    }

    public void updateQuantity () {
        PageFactory.initElements(driver, this);
        Wrappers.explicitWait(4);
        Wrappers.clickOn(driver , updateQuantityLink);
        Wrappers.explicitWait(4);
        Wrappers.clickOn(driver , createBtn);
        Wrappers.clickOn(driver ,countedQuantity);
        Wrappers.sendKeys(driver , countedQuantity , "10");

    }
}
