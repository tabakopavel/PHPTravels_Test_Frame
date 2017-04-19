package com.phptravel.pages.ui;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Menu Bar on Top")
@FindBy(xpath = "//body/nav[1]/div/div/div")
public class MenuBar extends HtmlElement {
    @FindBy(how = How.XPATH, using = "./ul/li[1]/a")
    private static Link Home;

    @FindBy(how = How.XPATH, using = "./ul/li[2]/a")
    private static Link Hotels;

    public  void clickHome() {
        Home.click();
    }

    public  void clickHotels() {
        Hotels.click();
    }

}
