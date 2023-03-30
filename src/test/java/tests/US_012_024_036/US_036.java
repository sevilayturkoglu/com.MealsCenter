package tests.US_012_024_036;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminLoginPage;
import utilities.TestBaseReport;

public class US_036 extends TestBaseReport {

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
        AdminLoginPage adminPage = new AdminLoginPage();

        adminPage.adminLoginOl();

        extentTest = extentReports.createTest("Test of summary information on the admin dashboard page ", "Summary information on the admin dashboard page should be visible");
        extentTest.info("The admin dashboard page is accessible.");

        // locater WebElement leri arraya atip foreach ile sirayla test et
        // calistigini gormek icin foreach icinde yazdir

        WebElement[] elements = {adminPage.totalSales, adminPage.totalMerchant, adminPage.totalCommission, adminPage.totalSubscription,
                adminPage.comissionThisWeek, adminPage.comissionThisMonth, adminPage.subscriptionsThisMonth,
                adminPage.orderReceived, adminPage.todayDelivered, adminPage.newCustomer, adminPage.totalRefund,
                adminPage.lastOrders, adminPage.popularItems, adminPage.popularMerchants,
                adminPage.salesOverview, adminPage.topCustomers, adminPage.overviewOfReviev, adminPage.recentPayout};

        SoftAssert softAssert = new SoftAssert();

        int countOfTitle = 0;

        for (WebElement each : elements) {
            softAssert.assertTrue(each.isDisplayed());
            // System.out.println(each.getText());
            extentTest.info("Confirmed that '" + each.getText() + "' item is visible on the admin dashboard page");
            countOfTitle++;

        }

        int expCount = 18;

        softAssert.assertEquals(countOfTitle, expCount);

        extentTest.info("Confirmed that All 18 titles are visible on the admin dashboard page");

        softAssert.assertAll();

    }
}
