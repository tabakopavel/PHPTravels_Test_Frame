package com.phptravel.pages;

import com.phptravel.factory.Driver;
import com.phptravel.pages.ui.AccountDropdown;
import com.phptravel.pages.ui.MenuBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public class AccountPage {
    private MenuBar menuBar;
    private AccountDropdown accountDropdown;

    @FindBy(how = How.CSS, using = "div.alert.alert-danger")
    WebElement alert_login;

    @FindBy(how = How.CSS, using = "h3.RTL")
    WebElement title_hi;

    @FindBy(how = How.CSS, using = "h3.RTL")
    By title_hi_loc;

    @FindBy(how = How.LINK_TEXT, using = "Logout")
    By logout_link;


    public AccountPage() {
        HtmlElementLoader.populatePageObject(this, Driver.getDriver());
    }

    public static AccountPage open() {
        Driver.getDriver().get(System.getProperty("test.account_url"));
        return new AccountPage();
    }

    public boolean NotLoggedIn() throws NullPointerException {
        boolean result = false;
        String alert = this.alert_login.getText();
        if (alert.equalsIgnoreCase("Invalid Email or Password")) {
            result = true;
        } else {
        }
        return result;
    }

    public String LoggedIn_dropdown(String user, String exp_res) throws NullPointerException {
        String result = "String user, String exp_res";
        if (exp_res.equalsIgnoreCase("false")) {
            result = "Invalid Email or Password";
        } else if (exp_res.equalsIgnoreCase("true")) {
            result = Driver.getDriver().findElement(By.linkText(user)).getText();
        }
        return result;
    }

    public String Drop_logout_link(String username) {
        String result = "false";
        Driver.getDriver().findElement(By.linkText(username)).click();
        if (Driver.getDriver().findElement(By.linkText("Logout")).getText().equalsIgnoreCase("Logout")) {
            result = "true";
        } else {
            result = "false";
        }
        return result;
    }

    public String Logging_title(String exp_res) throws NullPointerException {
        String result = null;
        if (exp_res.equalsIgnoreCase("false")) {
            result = this.alert_login.getText();
        } else if (exp_res.equalsIgnoreCase("true")) {
            result = this.title_hi.getText();
        }

        return result;
    }


}
