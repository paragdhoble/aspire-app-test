package com.odoo.aspireapp.pages;

import com.odoo.aspireapp.base.BaseTest;
import com.odoo.aspireapp.wrapper.Wrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    @FindBy(xpath = "//input[@name='login']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement pwd;

    @FindBy(xpath = "//*[contains(text(),'Log in')]")
    public WebElement login;

    public void login(String userName, String password) {
        PageFactory.initElements(driver, this);
        Wrappers.sendKeys(driver ,email ,userName);
        Wrappers.sendKeys(driver ,pwd , password);
        Wrappers.clickOn(driver ,login);
    }
}
