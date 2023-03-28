package tests.US_003_004_007_019_031;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantDashboardPage;
import pages.MerchantPage;
import utilities.Driver;
import utilities.TestBaseReport;

public class US_031_AllOrdersTest extends TestBaseReport {

    MerchantPage merchantPage;
    MerchantDashboardPage merchantDashboardPage;
    @Test
    public void allOrdersTest(){
        merchantPage=new MerchantPage();
        merchantDashboardPage=new MerchantDashboardPage();
        extentTest=extentReports.createTest("All Orders Test","All orders shoul be listed in 'All Orders Page'");
        merchantPage.merchantLogin();
        extentTest.info("Retaurant manager logged in as a merchant");
        merchantDashboardPage.dashboardMenuListClick("Orders");
        extentTest.info("Orders menu is displayed and clicked");
        merchantDashboardPage.merchantAllOrders.isDisplayed();
        extentTest.pass("All Orders menu is visible");
        merchantDashboardPage.merchantAllOrders.click();
        extentTest.info("All Orders menu is clicked");
        String expectedText="Order history";
        String actualText=merchantDashboardPage.merchantOrderHistoryText.getText();
        Assert.assertEquals(actualText,expectedText);
        extentTest.pass("All Orders Test PASSED");
        Driver.closeDriver();

    }
}
