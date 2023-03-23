package tests.US_002_018_030;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.MerchantSheculdePage;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_030_MerchantSheculdeTest {
    MerchantSheculdePage merchantSheculdePage = new MerchantSheculdePage();
    MerchantPage merchantPage = new MerchantPage();
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void accordingToCustomerNameListTest() {
        merchantPage = new MerchantPage();
        merchantSheculdePage = new MerchantSheculdePage();
        merchantPage.merchantLogin();
        merchantPage.merchantMenuLeftSide("Orders");
        merchantSheculdePage.merchantSheculdeButton.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "scheduled";
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        String customName="sevila espaniola";
        merchantSheculdePage.accordingToCustomName(customName);
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] orderType() {
        Object[][] orders = {{"Delivery"}, {"Pickup"}, {"Dinein"}};
        return orders;
    }
    @Test(dataProvider = "orderType")
    public void accordingToOrderTypeList(String type) {
        //bu testi yapmak icin Subway den ileri tarihli" Delivery,Pickup ve Dinein " siparisler verilmesi gerekir
        merchantPage = new MerchantPage();
        merchantSheculdePage = new MerchantSheculdePage();
        ReusableMethods.bekle(1);
        merchantPage.merchantLogin();
        merchantPage.merchantMenuLeftSide("Orders");
        merchantSheculdePage.merchantSheculdeButton.click();
        ReusableMethods.bekle(1);
        merchantSheculdePage.orderTypeButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("(//span[.='" + type + "'])[1]")).click();
        ReusableMethods.bekle(1);
        String actualText=merchantSheculdePage.orderTypeText.getText();
        softAssert.assertTrue(actualText.contains(type));
        ReusableMethods.bekle(1);
        softAssert.assertAll();
        Driver.closeDriver();

    }@Test
    public void accordingToPaymentStatus() {
        merchantPage = new MerchantPage();
        merchantSheculdePage = new MerchantSheculdePage();
        merchantPage.merchantLogin();
        merchantPage.merchantMenuLeftSide("Orders");
        merchantSheculdePage.merchantSheculdeButton.click();
        merchantSheculdePage.paymantStatusButton.click();
        merchantSheculdePage.paymentStatus("Unpaid");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] sortType() {
        Object[][]sorted={{"Order ID - Ascending"},{"Order ID - Descending"}
                        ,{"Delivery Time - Descending"},{"Delivery Time - Ascending"}};
        return  sorted;
    }
    @Test(dataProvider = "sortType")//Delivery Time - Ascending bug var sanirim,tekrar kontrol et
    public void zccordingToOrderSort(String sortType) {
        merchantPage = new MerchantPage();
        merchantSheculdePage = new MerchantSheculdePage();
        merchantPage.merchantLogin();
        merchantPage.merchantMenuLeftSide("Orders");
        merchantSheculdePage.merchantSheculdeButton.click();
        merchantSheculdePage.schuldeSortButton.click();
        merchantSheculdePage.sortSchulde(sortType);
        softAssert.assertAll();
        Driver.closeDriver();
    }

}

