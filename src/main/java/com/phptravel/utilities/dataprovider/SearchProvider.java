package com.phptravel.utilities.dataprovider;

import com.phptravel.utilities.classes.Credentials;
import com.phptravel.utilities.classes.Search;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by UX303L on 17.04.2017.
 */
public class SearchProvider {
    @DataProvider(name = "search_prov", parallel = false)
    public static Iterator<Object[]> getSearch(){
        List<Object[]> searchList = new ArrayList<Object[]>();
        List<Search> search = Search.getSearchList();
        for(int i=0;i<search.size();i++){
            searchList.add(new Object[]{search.get(i).getSearchInput(),search.get(i).getExpectedResult(),search.get(i).getExpectedCityOrTitle()});
        }
        return searchList.iterator();
    }
}
