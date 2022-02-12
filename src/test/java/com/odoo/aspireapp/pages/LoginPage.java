package com.odoo.aspireapp.pages;

import com.odoo.aspireapp.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    @FindBy(xpath = "//input[@name='login']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement pwd;

    @FindBy(xpath = "//*[contains(text(),'Log in')]")
    private WebElement login;

    public void login(String userName, String password) {
        PageFactory.initElements(driver, this);
        email.sendKeys(userName);
        pwd.sendKeys(password);
        login.click();
    }
}
