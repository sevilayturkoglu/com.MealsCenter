package tests.US_005_014_015_017_029;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MerchantDashboardPage;
import pages.MerchantPage;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_029_MerchantbackofficeOrdersCompleted extends TestBaseReport {
    /*
    As a restaurant manager,
    I want the orders given from my restaurant to be listed
    on the Completed page after all processes are completed.
     */

    MerchantPage merchantPage = new MerchantPage();
    MerchantDashboardPage merchantDashboardPage=new MerchantDashboardPage();


    @Test
    public void TC_02901_MerchantBackOfficeOrderCompletedTest() {

        merchantPage.MerchantPageLoginSry();
        merchantDashboardPage=new MerchantDashboardPage();
        extentTest=extentReports.createTest("All Orders Test","All orders shoul be listed in 'All Orders Page'");
        extentTest.info("Retaurant manager logged in as a merchant");
        merchantDashboardPage.dashboardMenuListClick("Orders");
        ReusableMethods.bekle(3);
        extentTest.info("Orders menu is displayed and clicked");
        merchantDashboardPage.merchantAllOrders.isDisplayed();
        extentTest.pass("All Orders menu is visible");
        ReusableMethods.bekle(3);
        merchantDashboardPage.merchantAllOrders.click();
        extentTest.info("All Orders menu is clicked");
        ReusableMethods.bekle(3);


        merchantDashboardPage.orderCompleted.click();
        String expectedText="Order completed";
        String actualText=merchantDashboardPage.merchantOrderHistoryText.getText();
        Assert.assertEquals(actualText,expectedText);
        extentTest.pass("All Orders Test PASSED");



    }
}
