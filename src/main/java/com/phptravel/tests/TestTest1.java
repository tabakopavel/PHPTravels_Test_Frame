package com.phptravel.tests;

import com.phptravel.pages.AccountPage;
import com.phptravel.pages.HomePage;
import com.phptravel.pages.HotelPage;
import com.phptravel.tests.BaseTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestTest1 extends BaseTest {

    @Test
    public void TestTest1() {

        HomePage homePage = HomePage.open();
        HotelPage hotelPage = homePage.clickHotels();
        hotelPage.search("Rome, Italy");
        System.out.println(hotelPage.matchResultByCity("Rome"));
        Assert.assertEquals(hotelPage.matchResultByCity("Rome"), "Rome", "Unsuccessful Search");

    }


}
