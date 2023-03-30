package tests.US_012_024_036;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import utilities.TestBaseReport;

public class US_036_AdminPage_SummaryInfoTest extends TestBaseReport {

    @Test
    public void AdminPageSummaryInfoTest() {

        // giris yap anasayfaya git
        AdminPage adminPage = new AdminPage();

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
