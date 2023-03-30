package tests.US_003_004_007_019_031;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantDashboardPage;
import pages.MerchantPage;
import pages.UserPage;
import utilities.TestBaseReport;

public class US_019_MerchantPanelTest extends TestBaseReport {

    MerchantPage merchantPage;
    MerchantDashboardPage merchantDashboardPage;

    @Test
    public void TC_019_MercantInfoTest(){
        merchantPage=new MerchantPage();
        merchantDashboardPage=new MerchantDashboardPage();
        extentTest=extentReports.createTest("Merchant Information Test","A restaurant manager could access information about his/her restaurant");
        merchantPage.merchantLogin();
        extentTest.info("Retaurant manager logged in as a merchant");
        merchantDashboardPage.dashboardMenuListClick("Merchant");
        extentTest.info("Merchant menu is displayed and clicked");
        merchantDashboardPage.merchantMenuLeftInformation.click();
        extentTest.info("Information is clicked");
        String expected="Information";
        String actual=merchantDashboardPage.merchantInformationText.getText();
        Assert.assertTrue(actual.contains(expected));
        extentTest.pass("Merchant Information Test about reataurant is PASSED");
    }
}
