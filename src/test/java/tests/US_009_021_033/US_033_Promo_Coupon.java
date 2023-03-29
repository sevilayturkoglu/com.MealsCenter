package tests.US_009_021_033;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.Merchant_PromoPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.ArrayList;
import java.util.List;


public class US_033_Promo_Coupon extends TestBaseReport {
    Merchant_PromoPage merchant_promoPage = new Merchant_PromoPage();
    MerchantPage merchantPage = new MerchantPage();
    Merchant_PromoPage cuopon_Name = new Merchant_PromoPage();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 5)
    public void TC_03301_promoCoupon() {
        merchantPage = new MerchantPage();
        merchant_promoPage = new Merchant_PromoPage();
        extentTest=extentReports.createTest("Creating a Coupon by going to the Promo link in the Dashboard Menu");
        merchantPage.merchantLogin();
        extentTest.info("Browser opens, Merchant admin page opens");
        merchantPage.merchantMenuLeftSide("Promo");
        extentTest.info("Promo Link is clicked.");
        merchant_promoPage.merchantPromoButton.click();
        extentTest.info("Coupon Link is clicked.");
        merchant_promoPage.merchantCouponMake("Hosgeldin Ramazan Kuponu");
        extentTest.info("Coupon added and coupon created");
        ReusableMethods.bekle(2);
        //merchant_promoPage.couponDelete();
        //extentTest.info("In order for the test to run smoothly, the coupon has been deleted, " +
        //"the coupon with the same name cannot be created again.");
        ReusableMethods.bekle(2);
        extentTest.pass("Coupon created");
        softAssert.assertAll();
        //Driver.closeDriver();
    }


    @Test(priority = 15)
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

        merchant_promoPage.merchantCouponMake("Ramazan Senligi Kuponu");
        extentTest.info("Second coupon created");
        ReusableMethods.bekle(1);
        String couponEntryCountBeforeDelete = merchant_promoPage.couponEntryCount.getText();
        extentTest.info("Confirmed that second coupon has been added");
        ReusableMethods.bekle(2);

        merchant_promoPage.couponDelete();
        extentTest.info("Second coupon deleted");
        ReusableMethods.bekle(2);
        String couponEntryCountAfterDelete = merchant_promoPage.couponEntryCount.getText();//entrycount
        softAssert.assertNotEquals(couponEntryCountAfterDelete,couponEntryCountBeforeDelete);
        extentTest.pass("Confirmed that the coupon has been deleted");
        softAssert.assertAll();
        //Driver.closeDriver();

    }

    @Test(priority = 10)
    public void TC_03303_promoCouponUpdate() {

        Actions actions = new Actions(Driver.getDriver());
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Making changes on the created coupon");
        merchantPage.merchantMenuLeftSide("Promo");
        extentTest.info("Promo Link is clicked.");
        merchant_promoPage.merchantPromoButton.click();
        extentTest.info("Coupon Link is clicked.");

        merchant_promoPage.promoCouponUpdate.click();
        extentTest.info("Update button clicked");
        merchant_promoPage.promoCouponName.click();
        extentTest.info("Clicked the button on behalf of the coupon");
        ReusableMethods.bekle(2);
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(merchant_promoPage.promoCouponName).sendKeys(Keys.TAB).perform();
        extentTest.info("It went to the box below");
        ReusableMethods.bekle(2);

        Select select = new Select(merchant_promoPage.promoCouponPercentage);
        select.selectByValue("percentage");
        actions.sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("5").sendKeys(Keys.TAB).perform();
        extentTest.info("Coupon type changed");

        ReusableMethods.bekle(1);
        Select select1 = new Select(merchant_promoPage.promoCouponDaysAvailable);
        select1.selectByVisibleText("sunday");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        extentTest.info("Added day by day to benefit from the coupon");

        merchant_promoPage.promoCouponExpirationDate.click();
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("The date the coupon will be valid until has been selected");

        Select select2 = new Select(merchant_promoPage.promoCouponOptions);
        select2.selectByValue("3");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("It has been chosen which positions will benefit from the coupon.");

        ReusableMethods.bekle(2);
        Select select3 = new Select(merchant_promoPage.promoCouponStatus);
        select3.selectByVisibleText("Publish");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Coupon status selected");


        ReusableMethods.bekle(2);

        //merchant_promoPage.promoCouponSaveButton.click();
        merchant_promoPage.promoCouponSuccesfullyUpdate.isDisplayed();
        extentTest.info("Coupon appears to have been successfully changed");
        List<String> merchantCouponList = new ArrayList<>();
        for (WebElement element : merchant_promoPage.allCouponList) {
            merchantCouponList.add(element.getText());
        }
        merchant_promoPage.promoCouponUpdateAllCoupon.click();
        merchant_promoPage.promoCouponUpdateAllCoupon.isDisplayed();
        extentTest.pass("Confirmed by clicking the menu that it has all coupons");

        //merchant_promoPage.merchantPromoButton.click();
    }

    }
