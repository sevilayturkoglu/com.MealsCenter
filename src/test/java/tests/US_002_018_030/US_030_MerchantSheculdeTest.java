package tests.US_002_018_030;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.MerchantSheculdePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;


public class US_030_MerchantSheculdeTest extends TestBaseReport {
    MerchantSheculdePage merchantSheculdePage = new MerchantSheculdePage();
    MerchantPage merchantPage = new MerchantPage();
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void accordingToCustomerNameListTest() {
        merchantPage = new MerchantPage();
        extentTest=extentReports.createTest("Ileri tarihli sheculded sayfasi olusturma","Musteri adina gore orderslari siralayabilir");
        merchantSheculdePage = new MerchantSheculdePage();
        merchantPage.merchantLogin();
        extentTest.info("Browser baslatildi,gecerli credentials ile merchant sayfasina login olundu");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Sol taraftaki dashboard menuden Orders tilandi");
        merchantSheculdePage.merchantSheculdeButton.click();
        extentTest.info("Orders altindaki menuden schulded tiklandi");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        extentTest.info("Sayfaya gidildigini dogrulamak icin url alindi");
        String expectedUrl = "scheduled";
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        extentTest.info("Gidilmek istenilen sayfa ile actual urlnin ayni olup olmadigi verify edildi");
        String customName="sevila espaniola";
        merchantSheculdePage.accordingToCustomName(customName);
        extentTest.info("Siralanmasi istenen musteri adi musteri satirina girildi,schulded sayfasinin bu musteri adina gore siralandigi verify edildi");
        extentTest.info("Browser kapatildi");
        extentTest.pass("Schulded listenin musteri adina gore siralandigi goruldu");
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
        extentTest=extentReports.createTest("Ileri tarihli sheculded sayfasi olusturma","Order type gore orderslari siralayabilir");
        ReusableMethods.bekle(1);
        merchantPage.merchantLogin();
        extentTest.info("Browser baslatildi,gecerli credentials ile merchant sayfasina login olundu");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Sol taraftaki dashboard menuden Orders tiklandi");
        merchantSheculdePage.merchantSheculdeButton.click();
        extentTest.info("Orders altindaki menuden schulded tiklandi");
        ReusableMethods.bekle(1);
        merchantSheculdePage.orderTypeButton.click();
        extentTest.info("Order type menu click yapildi ");
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("(//span[.='" + type + "'])[1]")).click();
        extentTest.info("Delivery,Pickup,Denien order typlerindan biri secildi");
        ReusableMethods.bekle(1);
        String actualText=merchantSheculdePage.orderTypeText.getText();
        extentTest.info("Test yapilmak uzere secilen order type nin texti alindi");
        softAssert.assertTrue(actualText.contains(type));
        extentTest.info("Beklenen order type ile actual order type in ayni oldugu test edildi");
        ReusableMethods.bekle(1);
        extentTest.info("Browser kapatildi");
        extentTest.pass("Schulded listenin order type gore siralandigi goruldu");
        softAssert.assertAll();
        Driver.closeDriver();

    }@Test
    public void accordingToPaymentStatus() {
        merchantPage = new MerchantPage();
        merchantSheculdePage = new MerchantSheculdePage();
        extentTest=extentReports.createTest("Ileri tarihli sheculded sayfasi olusturma","Payment statuye gore orderslari siralayabilir");
        merchantPage.merchantLogin();
        extentTest.info("Browser baslatildi,gecerli credentials ile merchant sayfasina login olundu");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Sol taraftaki dashboard menuden Orders tilandi");
        merchantSheculdePage.merchantSheculdeButton.click();
        extentTest.info("Orders altindaki menuden schulded tiklandi");
        merchantSheculdePage.paymantStatusButton.click();
        extentTest.info("Schulded sayfasindan payment status clicklendi");
        merchantSheculdePage.paymentStatus("Unpaid");
        extentTest.info("Listelenmesi istenilen payment statu clicklendi,listenin istenilen payment statuye gore olustugu verify edildi ");
        extentTest.info("Browser kapatildi");
        extentTest.pass("Schulded listenin payment statuye gore siralandigi goruldu");
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
        extentTest=extentReports.createTest("Ileri tarihli sheculded sayfasi olusturma","Order tarhi ve order ID ye artan azalana gore orderslari siralayabilir");
        merchantPage.merchantLogin();
        extentTest.info("Browser baslatildi,gecerli credentials ile merchant sayfasina login olundu");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Sol taraftaki dashboard menuden Orders tilandi");
        merchantSheculdePage.merchantSheculdeButton.click();
        extentTest.info("Orders altindaki menuden schulded tiklandi");
        merchantSheculdePage.schuldeSortButton.click();
        extentTest.info("Sayfadaki Sort butonu tiklandi");
        merchantSheculdePage.sortSchulde(sortType);
        extentTest.info("Istenilen type secildi,listenin istenilen order type gore siralandigi goruldu");
        extentTest.info("Browser kapatildi");
        extentTest.fail("Schulded listenin Delivery Time Ascendinge uygun olarak siralanmadigi goruldu");
        softAssert.assertAll();
        Driver.closeDriver();
    }

}

