package com.odoo.aspireapp.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.*;

import static com.odoo.aspireapp.base.BaseTest.driver;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

  //  public static String FILE_PATH_TEST_DATA = System.getProperty("user.dir") + "/src/main/java/com/github/paragdhoble/testdata/TestDataContact.xlsx";


    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

    }



}
