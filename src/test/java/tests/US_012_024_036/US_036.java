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
    public void Test01 () {

       // giris yap anasayfaya git
       AdminPage adminPage = new AdminPage();
       adminPage.adminLoginOl();

       /////// web element ile otomatize edemedim suana kadar

    //    WebElement [] elements = {adminPage.totalSales, adminPage.totalMerchant, adminPage.totalCommission, adminPage.totalSubscription,
    //            adminPage.comissionThisWeek, adminPage.comissionThisMonth, adminPage.subscriptionsThisMonth,
    //            adminPage.orderReceived, adminPage.todayDelivered, adminPage.newCustomer, adminPage.totalRefund,
    //            adminPage.lastOrders, adminPage.popularItems, adminPage.popularMerchants,
    //            adminPage.salesOverview, adminPage.topCustomers, adminPage.overviewOfReviev, adminPage.recentPayout};



        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminPage.totalSales.isDisplayed());
        softAssert.assertTrue(adminPage.totalMerchant.isDisplayed());
        softAssert.assertTrue(adminPage.totalCommission.isDisplayed());
        softAssert.assertTrue(adminPage.totalSubscription.isDisplayed());
        softAssert.assertTrue(adminPage.comissionThisWeek.isDisplayed());
        softAssert.assertTrue(adminPage.comissionThisMonth.isDisplayed());
        softAssert.assertTrue(adminPage.subscriptionsThisMonth.isDisplayed());
        softAssert.assertTrue(adminPage.orderReceived.isDisplayed());
        softAssert.assertTrue(adminPage.todayDelivered.isDisplayed());
        softAssert.assertTrue(adminPage.newCustomer.isDisplayed());
        softAssert.assertTrue(adminPage.totalRefund.isDisplayed());
        softAssert.assertTrue(adminPage.lastOrders.isDisplayed());
        softAssert.assertTrue(adminPage.popularItems.isDisplayed());
        softAssert.assertTrue(adminPage.popularMerchants.isDisplayed());
        softAssert.assertTrue(adminPage.salesOverview.isDisplayed());
        softAssert.assertTrue(adminPage.topCustomers.isDisplayed());
        softAssert.assertTrue(adminPage.overviewOfReviev.isDisplayed());
        softAssert.assertTrue(adminPage.recentPayout.isDisplayed());

        softAssert.assertAll();

    }
}
