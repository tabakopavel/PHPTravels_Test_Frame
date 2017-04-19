package com.phptravel.utilities.classes;

import com.phptravel.utilities.excel.ExcelReadForCredentials;
import com.phptravel.utilities.excel.ExcelReadForSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UX303L on 17.04.2017.
 */
public class Search {
    private String searchInput;
    private String expectedResult;
    private String expectedCityOrTitle;
    private static List<Search> searchList = new ArrayList<Search>();

    public Search(String searchInput,String expectedResult, String expectedCityOrTitle){
        this.searchInput=searchInput;
        this.expectedResult = expectedResult;
        this.expectedCityOrTitle=expectedCityOrTitle;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getExpectedCityOrTitle() {
        return expectedCityOrTitle;
    }

    public static List<Search> getSearchList() {
        ExcelReadForSearch.getData();
        return searchList;
    }

    public static void addSearchOption(Search search) {
        searchList.add(search);
    }

    @Override
    public String toString() {
        return getSearchInput() + " " + getExpectedResult() + " " + getExpectedCityOrTitle();
    }

}
