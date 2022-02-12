package com.odoo.aspireapp.testCases;

import com.odoo.aspireapp.base.BaseTest;
import com.odoo.aspireapp.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login2 extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(Login2.class.getSimpleName());
    private LoginPage common = new LoginPage() ;

    @BeforeTest
    public void init() {
        initialization();
    }

    @Test
    public void Login() {
        common.login(prop.getProperty("username"), prop.getProperty("password"));
       /* driver.findElement(By.xpath("//input[@name='login']")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).click();*/
    }

    @Test(priority = 0)
    public void navigateToInventery()
    {
        //driver.findElement(By.xpath("//a[@id='result_app_1']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Inventory')]")).click();
    }

    @Test(priority = 1,enabled=false)
    public void productFunctionality() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();

        driver.findElement(By.xpath("//html/body/header/nav/div[1]/div[2]/div/a[1]")).click();

        driver.findElement(By.xpath("//*[contains(text(),'Create')]")).click();

        driver.findElement(By.xpath("//input[@id='o_field_input_11']")).sendKeys("testnew04");

        driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();
        Thread.sleep(20000);
        ///html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[1] //btn btn-primary o_form_button_save

    }

    @Test(priority = 2 , enabled=false)
    public void updateQuantity()
    {
        //driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
        //driver.findElement(By.xpath("//span[contains(text(),'Update Quantity')]")).click();
        driver.findElement(By.name("action_update_quantity_on_hand")).click();
       // driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/button[2]/span")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();

        driver.findElement(By.name("product_id")).click();

        driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/input[1]")).sendKeys("1");

        driver.findElement(By.xpath("//input[@name='inventory_quantity']")).sendKeys("15");

        driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
    }

    @Test(priority = 3 ,enabled=false)
    public void applicationClick()
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/nav[1]/a[1]")));
        driver.findElement(By.xpath("//header/nav[1]/a[1]")).click();
    }

    @Test(priority = 4,enabled=false)
    public void manufacturingFeature()
    {
 String b = "aba" ;
        char [] a = b.toCharArray() ;
        driver.findElement(By.xpath("//a[@id='result_app_2']")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
        driver.findElement(By.xpath("//input[@id='o_field_input_1616']")).sendKeys("[1 reference] Aspire 02");
        driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/input[1]")).sendKeys("[1 reference] Aspire 02");
        driver.findElement(By.xpath("//input[@name='product_uom_qty']")).sendKeys("15");
        driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Mark as Done')]")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
    }


    @AfterTest
    public void afterTest() {
        driver.close();
    }

}
