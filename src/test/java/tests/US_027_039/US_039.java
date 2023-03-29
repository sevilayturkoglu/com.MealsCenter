package tests.US_027_039;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_039 {
    AdminPage adminPage=new AdminPage();


    @Test
    public void TC_3901(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adminEarningsButton.isDisplayed());
        softAssert.assertTrue(adminPage.adminEarningsButton.isEnabled());
        adminPage.adminEarningsButton.click();
        softAssert.assertTrue(adminPage.adminMerchantEarningsButton.isDisplayed());
        softAssert.assertTrue(adminPage.adminMerchantEarningsButton.isEnabled());
        adminPage.adminMerchantEarningsButton.click();
        softAssert.assertTrue(adminPage.adminMerchantEarningsText.isDisplayed());
    }
    @Test
    public void TC_3902(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adminTotalSales.isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void TC_3903(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        adminPage.adminEarningsButton.click();
        adminPage.adminMerchantEarningsButton.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adminMerchantEarningBalanceText.isDisplayed());
        softAssert.assertTrue(adminPage.adminMerchantEarningBalanceText.isEnabled());


        List<WebElement> balanceWebElementList=adminPage.adminBalanceList;
        List<String> balanceList= new ArrayList<>();
        for (WebElement element:balanceWebElementList
        ) {
            String each=element.getText();
            balanceList.add(each);

        }
        System.out.println(balanceList);
        softAssert.assertTrue(adminPage.adminBalanceList.containsAll(balanceList));
        //Burada listenin gorundugunu nasil test edebilirim
        // merchant earning text in gorunmesi dogrulamayi yapmis olur mu?

    }
    @Test
    public void TC_3904(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        adminPage.adminEarningsButton.click();
        adminPage.adminMerchantEarningsButton.click();
        SoftAssert softAssert=new SoftAssert();
        adminPage.adminMerchantEarningBalanceText.click();
        //Balance yazisina tiklayinca siralama olmus onu kontrol edecegim.
        List<WebElement> balanceWebElementList=adminPage.adminBalanceList;
        List<String> balanceList= new ArrayList<>();
        List<String> sortedBalanceList=new ArrayList<>();
        for (WebElement element:balanceWebElementList
        ) {
            String each=element.getText();
            balanceList.add(each);
            sortedBalanceList.add(each);
        }

        Collections.sort(sortedBalanceList);

        softAssert.assertEquals(sortedBalanceList,balanceList);

        //sirali balance list ile balance a tiklanmis halinin esit oldugunu gorduk.
    }
    @Test
    public void TC_3905(){
        //simdi de merchanta basinca esit mi diye bakacagiz.
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        adminPage.adminEarningsButton.click();
        adminPage.adminMerchantEarningsButton.click();
        SoftAssert softAssert=new SoftAssert();
        adminPage.adminMerchantEarningsMerchantText.click();
        //Bu adim  body deki merchant yazisini tiklayip isme gore siralama yapilabildigini gostermek icindir
        List<WebElement> MerchantWebElementList= adminPage.adminMerchantNameList;
        List<String> MerchantName=new ArrayList<>();
        List<String> sortedMerchantName=new ArrayList<>();
        ReusableMethods.bekle(2);
        for (WebElement each:MerchantWebElementList
        ) {
            MerchantName.add(each.getText());
            sortedMerchantName.add(each.getText());
        }

        Collections.sort(sortedMerchantName);
        softAssert.assertEquals(sortedMerchantName,MerchantName);


    }
    @Test
    public void TC_3906(){
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        adminPage.adminEarningsButton.click();
        adminPage.adminMerchantEarningsButton.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adminMerchantEarningActionIcon.isDisplayed());
        softAssert.assertTrue(adminPage.adminMerchantEarningActionIcon.isEnabled());
        adminPage.adminMerchantEarningActionIcon.click();
        softAssert.assertTrue(adminPage.adminActionIconOrder.isDisplayed());
        softAssert.assertTrue(adminPage.adminActionIconRefund.isDisplayed());
        softAssert.assertTrue(adminPage.adminActionIconCancel.isDisplayed());
        softAssert.assertTrue(adminPage.adminActionIconTotal.isDisplayed());

    }
    @Test
    public void TC_3907(){
        //search butonu
        adminPage=new AdminPage();
        adminPage.adminLoginOl();
        adminPage.adminEarningsButton.click();
        adminPage.adminMerchantEarningsButton.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminPage.adMinEarningsSearchButton.isDisplayed());
        softAssert.assertTrue(adminPage.adMinEarningsSearchButton.isEnabled());
        adminPage.adMinEarningsSearchButton.click();

    }
}
