package com.phptravel;

import com.phptravel.factory.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.phptravel.tests.BaseTests.BaseTest;

/**
 * Created by UX303L on 09.04.2017.
 */
public class Test1 extends BaseTest {
    WebDriver test_driver;

    @Test
    public void test() {
        test_driver = Driver.getDriver();
        test_driver.get("https://translate.google.com/?hl=ru#ru/en/%D0%BA%D0%BE%D0%BB%D0%B8%D1%87%D0%B5%D1%81%D1%82%D0%B2%D0%BE");
    }

}
