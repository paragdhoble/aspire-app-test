package com.odoo.aspireapp.scenarios;

import com.odoo.aspireapp.base.BaseTest;
import com.odoo.aspireapp.pages.LoginPage;
import com.odoo.aspireapp.pages.ManufacturingPage;
import com.odoo.aspireapp.util.PropertyUtils;
import javafx.scene.layout.Priority;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.odoo.aspireapp.base.BaseTest.driver;

public class ManufacturingScenario {
    ManufacturingPage manufacturingPage = new ManufacturingPage();

    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void init() {
        BaseTest.initialize();
        loginPage.login(PropertyUtils.getProp().getProperty("username"), PropertyUtils.getProp().getProperty("password"));
    }

    @Test (priority = 1)
    public void manufacturingOrder(){
        manufacturingPage.manufacturingNavigation();
        manufacturingPage.createOrder();
    }


    @Test (priority = 2)
    public void verify (){
        manufacturingPage.manufacturingNavigation();
        manufacturingPage.verifyOrder();
    }

    @AfterTest
    public void tearDown (){
        driver.quit();
    }
}
