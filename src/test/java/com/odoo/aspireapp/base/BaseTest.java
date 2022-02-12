package com.odoo.aspireapp.base;

import com.odoo.aspireapp.util.TestUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final Logger LOGGER = Logger.getLogger(BaseTest.class.getSimpleName());

    public static WebDriver driver;
    public static Properties prop;

    public BaseTest() {
        try {
            prop = new Properties();
            String environment = System.getProperty("env");
            String defaultPath = "/src/test/java/com/odoo/aspireapp/config/application.properties";
            String path = StringUtils.isBlank(environment) ? defaultPath
                    : "/src/test/java/com/odoo/aspireapp/config/application-" + environment + ".properties";
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + path);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void initialization() {
        initializeBrowser();
        manageBrowserProperties();
    }

    private static void initializeBrowser() {
        String browserName = prop.getProperty("browser");
        if ("chrome".equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if ("firefox".equals(browserName)) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            LOGGER.error("Browser not define. Does not match with supported values chrome/firefox");
            throw new RuntimeException("Browser not defined");
        }
    }

    private static void manageBrowserProperties() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

}