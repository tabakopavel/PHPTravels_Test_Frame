package com.phptravel.pages.ui;

import com.phptravel.factory.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static java.util.concurrent.TimeUnit.SECONDS;

@Name("SearchBox On HotelPage and ToursPage")
@FindBy(xpath = "//body/div[5]/div[2]/div")
public class SearchBox extends HtmlElement {
    @FindBy(how = How.XPATH, using = "./div[2]/form/div[1]/div[1]/div/div[2]/input")
    private static WebElement cityInput;

    @FindBy(how = How.XPATH, using = "./div[2]/form/div[6]/div/button")
    private static Button searchButton;

    public void search(String city) {

        cityInput.sendKeys(city);
        searchButton.click();
        Driver.waitForAjax();

    }
}
