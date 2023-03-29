package tests.US_027_039;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_039 extends TestBaseReport {
    AdminPage adminPage=new AdminPage();


    @Test
    public void TC_3901_MerchantBalance(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
   extentTest=extentReports.createTest("TC_3901","The Merchant balances should be visible to the Admin.");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adminEarningsButton.isDisplayed());
        extentTest.info("Verified that Earnings button is visible.");
        softAssert.assertTrue(adminPage.adminEarningsButton.isEnabled());
        extentTest.info("Verified that Earnings button is enabled.");
        adminPage.adminEarningsButton.click();
        softAssert.assertTrue(adminPage.adminMerchantEarningsButton.isDisplayed());
        extentTest.info("Verified that Merchant Earnings button is visible.");
        softAssert.assertTrue(adminPage.adminMerchantEarningsButton.isEnabled());
        extentTest.info("Verified that MerchantEarnings button is visible.");
        adminPage.adminMerchantEarningsButton.click();
        softAssert.assertTrue(adminPage.adminMerchantEarningsText.isDisplayed());
        extentTest.pass("Verified that merchant balance list is displayed.");
        softAssert.assertAll();
    }
    @Test
    public void TC_3902_TotalSales(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        extentTest=extentReports.createTest("TC_3902","The total values of the Merchant balances should be displayed.");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adminTotalSales.isDisplayed());
        extentTest.pass("Verified that total sales is visible in the body.");
        softAssert.assertAll();
    }

    @Test
    public void TC_3903_BalanceList(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        extentTest=extentReports.createTest("TC_3903","The Merchant balances should be visible as a list.");
        adminPage.adminEarningsButton.click();
        extentTest.info("Earnings button is clicked.");
        adminPage.adminMerchantEarningsButton.click();
        extentTest.info("Merchant Earnings button is clicked.");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adminMerchantEarningBalanceText.isDisplayed());
        extentTest.info("Verified that the balance text is disabled.");
        softAssert.assertTrue(adminPage.adminMerchantEarningBalanceText.isEnabled());
        extentTest.info("Verified that the balance text is enabled.");

        List<WebElement> balanceWebElementList=adminPage.adminBalanceList;
        extentTest.info("Balance list is created.");
        List<String> balanceList= new ArrayList<>();
        for (WebElement element:balanceWebElementList
        ) {
            String each=element.getText();
            balanceList.add(each);

        }
        System.out.println(balanceList);
        softAssert.assertTrue(adminPage.adminBalanceList.containsAll(balanceList));
        extentTest.pass("Verified that the balance list is disabled.");


    }
    @Test
    public void TC_3904_SortedBalance(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        extentTest=extentReports.createTest("TC_3904","The merchants listed should be sortable by balance.");
        adminPage.adminEarningsButton.click();
        extentTest.info("Earnings button is clicked.");
        adminPage.adminMerchantEarningsButton.click();
        extentTest.info("Merchant Earnings button is clicked.");
        SoftAssert softAssert=new SoftAssert();
        adminPage.adminMerchantEarningBalanceText.click();
        extentTest.info("Balance button is clicked.");
        //Balance yazisina tiklayinca siralama olmus onu kontrol edecegim.
        List<WebElement> balanceWebElementList=adminPage.adminBalanceList;
        extentTest.info("Balance list is created.");
        List<String> balanceList= new ArrayList<>();
        List<String> sortedBalanceList=new ArrayList<>();
        for (WebElement element:balanceWebElementList
        ) {
            String each=element.getText();
            balanceList.add(each);
            sortedBalanceList.add(each);
        }

        Collections.sort(sortedBalanceList);
        extentTest.info("Balance list is sorted.");
        softAssert.assertEquals(sortedBalanceList,balanceList);
        extentTest.pass("Verified that merchants are sorted by balance.");


    }
    @Test
    public void TC_3905_SortedName(){
        //simdi de merchanta basinca esit mi diye bakacagiz.
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        extentTest=extentReports.createTest("TC_3905","The balances listed should be sortable by name.");
        adminPage.adminEarningsButton.click();
        extentTest.info("Earnings button is clicked.");
        adminPage.adminMerchantEarningsButton.click();
        extentTest.info("Merchant Earnings button is clicked.");
        SoftAssert softAssert=new SoftAssert();
        adminPage.adminMerchantEarningsMerchantText.click();
        extentTest.info("Merchant text button is clicked.");
        //Bu adim  body deki merchant yazisini tiklayip isme gore siralama yapilabildigini gostermek icindir
        List<WebElement> MerchantWebElementList= adminPage.adminMerchantNameList;
        List<String> MerchantName=new ArrayList<>();
        List<String> sortedMerchantName=new ArrayList<>();
        ReusableMethods.bekle(2);
        extentTest.info("It is waited for 2 seconds.");
        for (WebElement each:MerchantWebElementList
        ) {
            MerchantName.add(each.getText());
            sortedMerchantName.add(each.getText());
        }

        Collections.sort(sortedMerchantName);
        extentTest.info("MErchant name list is sorted.");
        softAssert.assertEquals(sortedMerchantName,MerchantName);
        extentTest.pass("Verify that merchants are sorted by name.");


    }
    @Test
    public void TC_3906_TotalBalance(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        extentTest=extentReports.createTest("TC_3906"," The Admin should be able to select a specific merchant from the list to view their details.");
        adminPage.adminEarningsButton.click();
        extentTest.info("Earnings button is clicked.");
        adminPage.adminMerchantEarningsButton.click();
        extentTest.info("Merchant Earnings button is clicked.");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adminMerchantEarningActionIcon.isDisplayed());
        extentTest.pass("Verified that the action button is visible.");
        softAssert.assertTrue(adminPage.adminMerchantEarningActionIcon.isEnabled());
        extentTest.pass("Verified that the action button is enabled.");
        adminPage.adminMerchantEarningActionIcon.click();
        softAssert.assertTrue(adminPage.adminActionIconOrder.isDisplayed());
        extentTest.pass("Verified that the merchant's order information  is visible.");
        softAssert.assertTrue(adminPage.adminActionIconRefund.isDisplayed());
        extentTest.pass("Verified that merchant's refund information is visible.");
        softAssert.assertTrue(adminPage.adminActionIconCancel.isDisplayed());
        extentTest.pass("Verified that merchant's canceled order information is visible.");
        softAssert.assertTrue(adminPage.adminActionIconTotal.isDisplayed());
        extentTest.pass("Verified that total balance information is visible.");

    }
    @Test
    public void TC_3907_SearchButton(){
        //search butonu
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        extentTest=extentReports.createTest("TC_3907","The Admin should be able to search for a specific merchant by name.");
        adminPage.adminEarningsButton.click();
        extentTest.info("Earnings button is clicked.");
        adminPage.adminMerchantEarningsButton.click();
        extentTest.info("Merchant Earnings button is clicked.");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adMinEarningsSearchButton.isDisplayed());
        extentTest.info("Verified that the search button is disable.");
        softAssert.assertTrue(adminPage.adMinEarningsSearchButton.isEnabled());
        extentTest.info("Verified that the search button is disable.");
        adminPage.adMinEarningsSearchButton.click();
        extentTest.fail("The Admin can not be able to search for a specific merchant by name.");

    }
}
