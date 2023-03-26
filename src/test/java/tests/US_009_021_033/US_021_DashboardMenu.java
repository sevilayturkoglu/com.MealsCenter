package tests.US_009_021_033;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantDashboardPage;
import pages.MerchantPage;
import utilities.Driver;

public class US_021_DashboardMenu {
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
    public void dashboardListesiTest(String option){
        merchantPage=new MerchantPage();
        merchantDashboardPage=new MerchantDashboardPage();
        merchantPage.merchantLogin();
        merchantDashboardPage.dashboardMenuListClick(option);
        softAssert.assertAll();
        Driver.closeDriver();

    }









}
