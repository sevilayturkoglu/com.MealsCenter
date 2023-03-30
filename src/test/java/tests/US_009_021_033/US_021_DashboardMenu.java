package tests.US_009_021_033;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantDashboardPage;
import pages.MerchantPage;
import utilities.TestBaseReport;

public class US_021_DashboardMenu extends TestBaseReport {
    MerchantPage merchantPage= new MerchantPage();
    MerchantDashboardPage merchantDashboardPage=new MerchantDashboardPage();
    SoftAssert softAssert = new SoftAssert();


    @DataProvider
    public static Object [][] dashboardListesi(){

    String[][] dashboardMenusu={
            {"Merchant"}, {"Orders"}, {"Attributes"}, {"Food"},
            {"Order Type"}, {"Payment gateway"}, {"Promo"}, {"Images"},
            {"Account"},{"Buyers"},{"Users"},{"Reports"},{"Inventory Management"},

    };

    return dashboardMenusu;
    }

    @Test(dataProvider = "dashboardListesi")
    public void TC_02101_dashboardListesiTest(String option){
        merchantPage=new MerchantPage();
        merchantDashboardPage=new MerchantDashboardPage();
        extentTest=extentReports.createTest("Existence and verification of a Dashboard Menu in the Merchant Panel");
        merchantPage.merchantLogin();
        extentTest.info("Browser started, login to merchant page with valid credentials");
        merchantDashboardPage.dashboardMenuListClick(option);
        extentTest.pass("From the Dashboard menu on the left, click and display Merchant, Orders, Attributes, " +
                "Food, Order Type, Payment gateway, Promo, Images, Account, Buyers, Users, Reports and Inventory Management, " +
                "respectively.");
        softAssert.assertAll();
        //Driver.closeDriver();

    }









}
