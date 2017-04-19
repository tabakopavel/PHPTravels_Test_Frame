package com.phptravel.pages;

import com.phptravel.factory.Driver;
import com.phptravel.pages.ui.AccountDropdown;
import com.phptravel.pages.ui.MenuBar;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by UX303L on 17.04.2017.
 */
public class HomePage {

    private MenuBar menuBar;
    private AccountDropdown accountDropdown;


    public HomePage() {
        HtmlElementLoader.populatePageObject(this, Driver.getDriver());
    }

    public static HomePage open() {
        Driver.getDriver().get(System.getProperty("test.base_url"));
        return new HomePage();
    }

    public HotelPage clickHotels() {
        menuBar.clickHotels();
        return new HotelPage();
    }

    public LoginPage clickLoginPage() {
        accountDropdown.clickLogin();
        return new LoginPage();
    }


}
