package com.odoo.aspireapp.scenarios;

import com.odoo.aspireapp.base.BaseTest;
import com.odoo.aspireapp.pages.InventoryPage;
import com.odoo.aspireapp.pages.LoginPage;
import com.odoo.aspireapp.pages.ManufacturingPage;
import com.odoo.aspireapp.util.PropertyUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestCases extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(TestCases.class.getSimpleName());
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    ManufacturingPage manufacturingPage = new ManufacturingPage();


    @BeforeMethod
    public void init() {
        BaseTest.initialize();
        loginPage.login(PropertyUtils.getProp().getProperty("username"), PropertyUtils.getProp().getProperty("password"));
    }

    @Test(priority = 1)
    public void createProduct() {
        inventoryPage.navigateToInventory();
        inventoryPage.newProductCreation();
        inventoryPage.updateQuantity();
    }

    @Test(priority = 2)
    public void manufacturingOrder() {
        manufacturingPage.manufacturingNavigation();
        manufacturingPage.createOrder();
    }


    @Test(priority = 3)
    public void verify() {
        manufacturingPage.manufacturingNavigation();
        manufacturingPage.verifyOrder();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}



