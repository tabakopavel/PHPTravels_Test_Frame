package com.phptravel.tests.BaseTests;

import com.phptravel.factory.Driver;
import com.phptravel.pages.AccountPage;
import com.phptravel.pages.HomePage;
import com.phptravel.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTestWithLogin {

    @BeforeMethod
    public void init() {
        Driver.init();
        HomePage homePage = HomePage.open();
        LoginPage loginPage = homePage.clickLoginPage();
        AccountPage account_page = loginPage.login("user@phptravels.com", "demouser");
    }

    @AfterMethod(alwaysRun = true)
    public void clean() {
        Driver.clean();
    }
}
