package com.phptravel.tests;

import com.phptravel.tests.BaseTests.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.phptravel.pages.AccountPage;
import com.phptravel.pages.LoginPage;
import com.phptravel.utilities.dataprovider.CredentialsProvider;


public class LoginTest extends BaseTest {
    @Test(dataProvider = "cred_prov", dataProviderClass = CredentialsProvider.class)
    public void LoginTest(String login, String password, String exp_res, String exp_title) {
        LoginPage login_page = LoginPage.open();
        AccountPage account_page = login_page.login(login, password);

        if(exp_res.equalsIgnoreCase("true")){
           Assert.assertEquals(account_page.Drop_logout_link("John"),"true","User is not legged in!");
            Assert.assertEquals(account_page.Logging_title(exp_res),exp_title,"User is not legged in!");
        }else if(exp_res.equalsIgnoreCase("false")){
            Assert.assertEquals(account_page.Logging_title(exp_res),exp_title,"User logged!");
        }
        Reporter.log("Done", 2, true);
    }
}
