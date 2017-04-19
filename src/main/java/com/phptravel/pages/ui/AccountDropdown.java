package com.phptravel.pages.ui;

import com.phptravel.factory.Driver;
import com.phptravel.pages.AccountPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by UX303L on 17.04.2017.
 */
@Name("Account Dropdown Top Right")
@FindBy(xpath = "//body/div[2]/div/div/div[2]/ul/li[2]")
public class AccountDropdown extends HtmlElement {
    @FindBy(how = How.XPATH, using = "./ul/li[1]/a")
    private static WebElement Link1;

    @FindBy(how = How.XPATH, using = "./ul/li[2]/a")
    private static WebElement Link2;

    @FindBy(how = How.XPATH, using = "//body/div[2]/div/div/div[2]/ul/li[2]")
    private static WebElement dropDownMenu;

    public void clickLogin() {
        dropDownMenu.click();
        Link1.click();
    }

    public void clickLogout() {
        dropDownMenu.click();
        Link2.click();
    }

    public void clickSignUp() {
        dropDownMenu.click();
        Link2.click();
    }

    public AccountPage clickAccountPage() {
        dropDownMenu.click();
        Link1.click();
        return new AccountPage();
    }
}
