package com.odoo.aspireapp.scenarios;

import com.odoo.aspireapp.base.BaseTest;
import com.odoo.aspireapp.pages.InventoryPage;
import com.odoo.aspireapp.pages.LoginPage;
import com.odoo.aspireapp.util.PropertyUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.odoo.aspireapp.base.BaseTest.driver;

public class InventoryScenario {

    InventoryPage inventoryPage = new InventoryPage();
    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void init() {
        BaseTest.initialize();
        loginPage.login(PropertyUtils.getProp().getProperty("username"), PropertyUtils.getProp().getProperty("password"));
    }

    @Test
    public void createProduct() throws InterruptedException {
        inventoryPage.navigateToInventory();
        inventoryPage.newProductCreation();
        inventoryPage.updateQuantity();
    }

    @AfterTest
    public void tearDown (){
        driver.quit();
    }
}



