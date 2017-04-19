package com.phptravel.utilities.classes;

import org.testng.Assert;
import org.testng.Reporter;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by UX303L on 10.04.2017.
 */
public class Propertiess {

    private static FileInputStream fis;
    private static Properties properties = new Properties();

    public static void init() {
        try {
            fis = new FileInputStream("C:\\project_idea_ultimate\\PHPTravels_Test_Frame\\src\\main\\resources\\config.properties");
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Propertiess.getNamesProp();
    }

    @SuppressWarnings("unchecked")
    public static void getNamesProp() {
        Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            System.setProperty(key, properties.getProperty(key));
            Reporter.log(key + " - " + properties.getProperty(key), 2, true);
        }
    }


}
