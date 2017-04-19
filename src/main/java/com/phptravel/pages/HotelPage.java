package com.phptravel.pages;

import com.phptravel.factory.Driver;
import com.phptravel.pages.ui.MenuBar;
import com.phptravel.pages.ui.ResultListInSearch;
import com.phptravel.pages.ui.SearchBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;


public class HotelPage {


    private SearchBox searchBox;
    private ResultListInSearch resultListInSearch;
    private MenuBar menuBar;

    public HotelPage() {
        HtmlElementLoader.populatePageObject(this, Driver.getDriver());
    }

    public static HotelPage open() {
        Driver.getDriver().get(System.getProperty("test.hotels_url"));
        return new HotelPage();
    }

    public void search(String city) {
        searchBox.search(city);
    }

    public String matchResultByCity(String city) {
        String result = null;
        List<String> list = resultListInSearch.getListOfCitiesInResult();

        for (String x : list) {
            if (!x.equalsIgnoreCase(city)) {
                result = "false";
                break;
            }

            result = city;
        }
        return result;
    }

    public String getTitle() {
        String result = null;
        result = resultListInSearch.getTitle();
        return result;
    }
}
