package com.odoo.aspireapp.util;

import com.odoo.aspireapp.base.BaseTest;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class.getSimpleName());
    public static Properties prop;

    static {
        try {
            prop = new Properties();
            String environment = System.getProperty("env");
            String defaultPath = "/src/test/resources/config/application.properties";
            String path = StringUtils.isBlank(environment) ? defaultPath
                    : "/src/test/resources/config/application-" + environment + ".properties";
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + path);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }//C:\Parag\Stud_Code\Automation_Code\Aspireapp_odoo\src\test\resources\config\application.properties

    public static Properties getProp() {
        return prop;
    }
}
