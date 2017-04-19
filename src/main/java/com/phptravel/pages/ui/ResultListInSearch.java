package com.phptravel.pages.ui;

import com.phptravel.factory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

@Name("Search Results Table")
@FindBy(xpath = "//body/div[5]/div[3]")
public class ResultListInSearch extends HtmlElement {


    @FindBy(how = How.XPATH, using = "//body/div[5]/div[3]/div/h1")
    WebElement title;

    @FindBy(how = How.XPATH, using = "./div/table/tbody/tr")
    private By resultsTable;

    @FindBy(how = How.XPATH, using = "./div/table/tbody/tr/td/div/div/div/div[2]/a")
    private By resultInResultsTable;

    private String cityTitle = "title";

    public List<String> getListOfCitiesInResult() {
        List<String> list = new ArrayList<String>();
        List<WebElement> allElements = Driver.getDriver().findElements(By.xpath("//body/div[5]/div[3]/div/table/tbody/tr"));
        for (int i = 0; i < allElements.size(); i++) {
            WebElement x = allElements.get(i).findElement(By.xpath("//body/div[5]/div[3]/div/table/tbody/tr/td/div/div/div/div[2]/a"));
            list.add(i, new String(x.getAttribute(cityTitle)));


        }
        return list;
    }

    public String getTitle() {
        String result = null;
        result = title.getText();
        return result;
    }
}
