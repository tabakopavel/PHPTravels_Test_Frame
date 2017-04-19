package com.phptravel.tests.BaseTests;

import com.phptravel.factory.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    @BeforeMethod
    public void init() {
        Driver.init();


    }

    @AfterMethod(alwaysRun = true)
    public void clean() {
        Driver.clean();
    }
}
