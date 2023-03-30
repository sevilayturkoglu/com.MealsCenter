package tests.US_009_021_033;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.Merchant_PromoPage;
import utilities.ReusableMethods;
import utilities.TestBaseReport;


public class US_033_Promo_Coupon extends TestBaseReport {
    Merchant_PromoPage merchant_promoPage = new Merchant_PromoPage();
    MerchantPage merchantPage = new MerchantPage();
    Merchant_PromoPage cuopon_Name = new Merchant_PromoPage();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 5)
    public void TC_03301_promoCouponMaken() {
        merchantPage = new MerchantPage();
        merchant_promoPage = new Merchant_PromoPage();
        extentTest=extentReports.createTest("Creating a Coupon by going to the Promo link in the Dashboard Menu");
        merchantPage.merchantLogin();
        extentTest.info("Browser opens, Merchant admin page opens");
        merchantPage.merchantMenuLeftSide("Promo");
        extentTest.info("Promo Link is clicked.");
        merchant_promoPage.merchantPromoButton.click();
        extentTest.info("Coupon Link is clicked.");
        merchant_promoPage.merchantCouponMake("Ozel Subway Kupon 2");
        extentTest.info("Coupon added and coupon created");
        ReusableMethods.bekle(2);
        merchant_promoPage.couponDelete();
        extentTest.info("In order for the test to run smoothly, the coupon has been deleted, " +
                "the coupon with the same name cannot be created again.");
        ReusableMethods.bekle(2);
        extentTest.pass("Coupon created");
        softAssert.assertAll();
    }

    @Test(priority = 10)
    public void TC_03302_promoCouponDelete(){
        merchantPage = new MerchantPage();
        merchant_promoPage=new Merchant_PromoPage();
        extentTest=extentReports.createTest("Creating, deleting the second coupon and displaying " +
                "that I deleted the coupon in the coupon list");
        merchantPage.merchantLogin();
        extentTest.info("Browser opens, Merchant admin page opens");
        merchantPage.merchantMenuLeftSide("Promo");
        extentTest.info("Promo Link is clicked.");
        merchant_promoPage.merchantPromoButton.click();
        extentTest.info("Coupon Link is clicked.");

        merchant_promoPage.merchantCouponMake("Sizin Kuponunuz!");
        extentTest.info("Second coupon created");
        ReusableMethods.bekle(1);
        String couponEntryCountBeforeDelete = merchant_promoPage.couponEntryCount.getText();
        extentTest.info("Confirmed that second coupon has been added");
        ReusableMethods.bekle(2);

        merchant_promoPage.couponDelete();
        extentTest.info("Second coupon deleted");
        ReusableMethods.bekle(2);
        String couponEntryCountAfterDelete = merchant_promoPage.couponEntryCount.getText();
        softAssert.assertNotEquals(couponEntryCountAfterDelete,couponEntryCountBeforeDelete);
        extentTest.pass("the coupon has been confirmed deleted");
        softAssert.assertAll();
    }

    @Test(priority=15)
    public void TC_03303_promoCouponUpdate(){
        merchantPage = new MerchantPage();
        merchant_promoPage=new Merchant_PromoPage();
        extentTest=extentReports.createTest("Creating, deleting the second coupon and displaying " +
                "that I deleted the coupon in the coupon list");
        merchantPage.merchantLogin();
        extentTest.info("Browser opens, Merchant admin page opens");
        merchantPage.merchantMenuLeftSide("Promo");
        extentTest.info("Promo Link is clicked.");
        merchant_promoPage.merchantPromoButton.click();
        extentTest.info("Coupon Link is clicked.");

        merchant_promoPage.merchantCouponMake("Icecek Kupon");
        extentTest.info("Second coupon created");

        merchant_promoPage.couponUpdate();
        extentTest.pass("Coupon name updated, update confirmed");
        ReusableMethods.bekle(1);
    }

    @Test(priority = 20)
    public void TC_03304_promoCouponIsimList(){
        merchantPage = new MerchantPage();
        merchant_promoPage=new Merchant_PromoPage();
        extentTest=extentReports.createTest("Creating, deleting the second coupon and displaying " +
                "that I deleted the coupon in the coupon list");
        merchantPage.merchantLogin();
        extentTest.info("Browser opens, Merchant admin page opens");
        merchantPage.merchantMenuLeftSide("Promo");
        extentTest.info("Promo Link is clicked.");
        merchant_promoPage.merchantPromoButton.click();
        extentTest.info("Coupon Link is clicked.");
        merchant_promoPage.isimList();
        merchant_promoPage.isimListesi.isDisplayed();
        extentTest.pass("Name List displayed");
    }

    @Test(priority = 25)
    public void TC_03305_promoCouponKullanimList() {
        merchantPage = new MerchantPage();
        merchant_promoPage = new Merchant_PromoPage();
        extentTest = extentReports.createTest("Creating, deleting the second coupon and displaying " +
                "that I deleted the coupon in the coupon list");
        merchantPage.merchantLogin();
        extentTest.info("Browser opens, Merchant admin page opens");
        merchantPage.merchantMenuLeftSide("Promo");
        extentTest.info("Promo Link is clicked.");
        merchant_promoPage.merchantPromoButton.click();
        extentTest.info("Coupon Link is clicked.");
        merchant_promoPage.usedListesi.click();
        extentTest.pass("Click Used List");
        merchant_promoPage.usedListesi.isDisplayed();
        extentTest.pass("Usage List displayed");
    }

    @Test(priority = 30)
    public void TC_03306_promoCouponSearchBox() {
        merchantPage = new MerchantPage();
        merchant_promoPage = new Merchant_PromoPage();
        extentTest = extentReports.createTest("Creating, deleting the second coupon and displaying " +
                "that I deleted the coupon in the coupon list");
        merchantPage.merchantLogin();
        extentTest.info("Browser opens, Merchant admin page opens");
        merchantPage.merchantMenuLeftSide("Promo");
        extentTest.info("Promo Link is clicked.");
        merchant_promoPage.merchantPromoButton.click();
        extentTest.info("Coupon Link is clicked.");

        merchant_promoPage.searchbox.click();
        extentTest.info("Clicked in the search box");
        merchant_promoPage.searchbox.sendKeys("Iste Bu Kupon");
        extentTest.info("Coupon name entered in search box");
        ReusableMethods.bekle(1);
        merchant_promoPage.searchBoxBuyutec.click();
        extentTest.info("Clicked the magnifying glass next to the Search Box");
        //softAssert.assertTrue(merchant_promoPage.searchBoxBuyutec.isEnabled());
        softAssert.assertTrue(merchant_promoPage.searchBoxBuyutec.isDisplayed());
        extentTest.info("Searched coupon found");
        ReusableMethods.bekle(1);
        merchant_promoPage.searcBoxClose.click();
        extentTest.info("Wanted coupon closed");
        //softAssert.assertTrue(merchant_promoPage.searcBoxClose.isEnabled());
        softAssert.assertTrue(merchant_promoPage.searcBoxClose.isDisplayed());
        extentTest.pass("Coupon List seen back");

        System.out.println("Merhaba");
    }

}
