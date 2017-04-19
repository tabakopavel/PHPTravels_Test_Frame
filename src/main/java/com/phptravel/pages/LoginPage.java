package com.phptravel.pages;

import com.phptravel.factory.Driver;
import com.phptravel.pages.ui.AccountDropdown;
import com.phptravel.pages.ui.MenuBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public class LoginPage {

    private MenuBar menuBar;
    private AccountDropdown accountDropdown;

    @FindBy(how = How.NAME, using = "username")
    WebElement loginInput;

    @FindBy(how = How.NAME, using = "password")
    WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement loginbutton;

    public LoginPage() {

        HtmlElementLoader.populatePageObject(this, Driver.getDriver());
    }

    public AccountPage login(String login, String password) {
        this.loginInput.sendKeys(login);
        this.passwordInput.sendKeys(password);
        this.loginbutton.click();
        return new AccountPage();
    }

    public static LoginPage open() {
        Driver.getDriver().get(System.getProperty("test.login_url"));
        return new LoginPage();
    }

}
