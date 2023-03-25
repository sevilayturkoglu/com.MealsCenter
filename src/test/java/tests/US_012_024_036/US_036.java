package tests.US_012_024_036;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.UserPage;
import utilities.Driver;

public class US_036 {

    /*
        US_036  As an admin, I should be able to see summary information on the Dashboard page

        36-- Acceptance Criteria
        * On the "https://qa.mealscenter.com/backoffice/admin/dashboard" page
          Total Sales, Commission this week, Order received, Last Orders, Sales overview items should be visible.

        36-- Test Case
        * Follow the US_035 steps and
           Verify url "https://qa.mealscenter.com/backoffice/admin/dashboard".
        * On the page; Verify that the Total Sales item is visible.		//div[@class="report-inner"]
        * On the page; Verify that the Commission this week item is visible.	//div[@id="boxes"]
        * On the page; Verify that Order received is visible.			//h5[@class="m-0 text-secondary"]
        * On the page; Verify that the Last Orders item is visible.		//h5[@class="m-0"]
        * On the page; Verify that the Sales overview item is visible.		//h5[@class="m-0 mb-3"]
     */

    @Test
    public void Test01() {

        // giris yap anasayfaya git
        AdminPage adminPage = new AdminPage();
        adminPage.adminLoginOl();

        // locater WebElement leri arraya atip foreach ile sirayla test et
        // calistigini gormek icin foreach icinde yazdir

        WebElement[] elements = {adminPage.totalSales, adminPage.totalMerchant, adminPage.totalCommission, adminPage.totalSubscription,
                adminPage.comissionThisWeek, adminPage.comissionThisMonth, adminPage.subscriptionsThisMonth,
                adminPage.orderReceived, adminPage.todayDelivered, adminPage.newCustomer, adminPage.totalRefund,
                adminPage.lastOrders, adminPage.popularItems, adminPage.popularMerchants,
                adminPage.salesOverview, adminPage.topCustomers, adminPage.overviewOfReviev, adminPage.recentPayout};

        SoftAssert softAssert = new SoftAssert();

        for (WebElement each : elements) {
            softAssert.assertTrue(each.isDisplayed());
            System.out.println(each.getText());

        }

        softAssert.assertAll();

    }
}
