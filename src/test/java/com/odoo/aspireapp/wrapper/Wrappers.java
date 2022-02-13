package com.odoo.aspireapp.wrapper;

import com.odoo.aspireapp.base.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class Wrappers extends BaseTest{


    private static final Logger LOGGER = Logger.getLogger(Wrappers.class.getSimpleName());

    public static void clickOn(WebDriver driver, WebElement element) {
        try {
            if (element.isDisplayed()) {
                new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                explicitWait(3);
                try {
                    LOGGER.info("Click on WebElement " + element.getText());
                } catch (Exception e) {
                    LOGGER.error("Failed due to " + element + " REASON " + e.getMessage());
                }
            }
        } catch (Exception e) {
            LOGGER.error("Failed due to " + element + " REASON " + e.getMessage());
        }
    }


    public static void explicitWait(int timeSeconds) {
        try {
            TimeUnit.SECONDS.sleep(timeSeconds);
        } catch (Exception e) {
            LOGGER.warn("Error in TimeUnit wait");
        }
    }


    public static void sendKeys(WebDriver driver, WebElement element, String value) {
        try {
            if (element.isDisplayed()) {
                new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(element));
                element.sendKeys(value);
                LOGGER.info("Entered Test Data " + value);

            }
        } catch (Exception e) {
            LOGGER.error("Failed due to " + element + " REASON " + e.getMessage());
        }
    }


    public static void sendKeyClear(WebDriver driver, WebElement element)
    {
        try {
            if(element.isDisplayed()) {
                new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(element));
                for (int i = 0; i <10; i++) {
                    element.sendKeys(Keys.BACK_SPACE);
                }
            }
        }catch (Exception  e) {
            LOGGER.error("Failed due to"+element+" REASON"+e.getMessage());
        }
    }
}
