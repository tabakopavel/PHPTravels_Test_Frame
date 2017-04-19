package com.phptravel.tests;

import com.phptravel.factory.Driver;
import com.phptravel.pages.HomePage;
import com.phptravel.pages.HotelPage;
import com.phptravel.tests.BaseTests.BaseTest;
import com.phptravel.tests.BaseTests.BaseTestWithLogin;
import com.phptravel.utilities.dataprovider.CredentialsProvider;
import com.phptravel.utilities.dataprovider.SearchProvider;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {


    @Test(dataProvider = "search_prov", dataProviderClass = SearchProvider.class)
    public void SearchTest(String searchInput,String expectedResult, String expectedCityOrTitle) {

        HomePage homePage = HomePage.open();
        HotelPage hotelPage = homePage.clickHotels();
        hotelPage.search(searchInput);

        if(expectedResult.equalsIgnoreCase("true")){
            Assert.assertEquals(hotelPage.matchResultByCity(expectedCityOrTitle),expectedCityOrTitle,"Unsuccessful Search");
        }else if(expectedResult.equalsIgnoreCase("false")){
            Assert.assertEquals(hotelPage.getTitle(),expectedCityOrTitle,"Unsuccessful Search");
        }
        Reporter.log("Done", 2, true);

    }
}
