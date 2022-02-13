package com.odoo.aspireapp.base;

import com.odoo.aspireapp.util.PropertyUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final Logger LOGGER = Logger.getLogger(BaseTest.class.getSimpleName());
    public static long PAGE_LOAD_TIMEOUT = 5;
    public static long IMPLICIT_WAIT = 3;
    public static WebDriver driver;

    public static void initialize() {
        initializeBrowser();
        manageBrowserProperties();
    }

    private static void initializeBrowser() {
        String browserName = PropertyUtils.getProp().getProperty("browser");
        if ("chrome".equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            LOGGER.info(" Browser Launch" + browserName);
        }
        if ("firefox".equals(browserName)) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            LOGGER.info(" Browser Launch" + browserName);
        } else {
            LOGGER.error("Browser not define. Does not match with supported values chrome/firefox");
            throw new RuntimeException("Browser not defined");
        }
    }

    private static WebDriver manageBrowserProperties() {
        driver.manage().window().maximize();
        LOGGER.info("Maximize the Window");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(PropertyUtils.getProp().getProperty("url"));
        return driver;
    }

}