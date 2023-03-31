package tests.US_028_040;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminCoupon;
import pages.AdminPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;



public class US_040_AdminCoupon extends TestBaseReport {

    SoftAssert softAssert = new SoftAssert();
    AdminPage adminPage = new AdminPage();
    AdminCoupon adminCoupon = new AdminCoupon();

    @Test(priority = 5)
    public void TC_04001_kuponOlusturma() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        extentTest = extentReports.createTest("test04001", "create a new coupon");
        adminPage.adminLoginOl();
        extentTest.info("promo button is clicked.");
        adminCoupon.promoButton.click();
        extentTest.info("coupon button is clicked.");
        adminCoupon.couponButton.click();
        extentTest.info("created a new coupon");
        adminCoupon.couponMake("ikinciCoupons");
        extentTest.info("I deleted the coupon to create a cupon with the same name");
        adminCoupon.couponDelete();
        extentTest.pass("new coupon successfully created");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(priority = 10)
    public void TC_04002_kuponSilme() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        extentTest = extentReports.createTest("test04002", "delete the coupon");
        adminPage.adminLoginOl();
        extentTest.info("promo button is clicked.");
        adminCoupon.promoButton.click();
        extentTest.info("coupon button is clicked.");
        adminCoupon.couponButton.click();
        extentTest.info("created a new coupon for delete");
        adminCoupon.couponMake("SilmeCouponu");
        String enteryCountBeforeDelete = adminCoupon.enteryCount.getText();
        ReusableMethods.bekle(1);
        extentTest.info("the coupon deleted");
        adminCoupon.couponDelete();
        String enteryCountAfterDelete = adminCoupon.enteryCount.getText();
        extentTest.info("verify that you deleted the coupon");
        softAssert.assertNotEquals(enteryCountAfterDelete, enteryCountBeforeDelete);
        extentTest.pass("the coupon deleted");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(priority = 15)
    public void TC_04003_upDate() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        adminPage.adminLoginOl();
        extentTest.info("promo button is clicked.");
        adminCoupon.promoButton.click();
        extentTest.info("coupon button is clicked.");
        adminCoupon.couponButton.click();
        extentTest.info("a new coupon create for update.");
        adminCoupon.couponMake("UpdateEdilecekCoupons");
        extentTest.info("the coupon updated");
        adminCoupon.updateCoupon();
        extentTest.info("I deleted the coupon to create a cupon with the same name");
        adminCoupon.couponDelete();
        extentTest.pass("the coupon updated");
        Driver.closeDriver();
    }

    @Test(priority = 20)
    public void TC_04004_isimSirasinaGoreCouponList() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        extentTest = extentReports.createTest("test04004", "All products should be sorted by name");
        adminPage.adminLoginOl();
        extentTest.info("promo button is clicked.");
        adminCoupon.promoButton.click();
        extentTest.info("coupon button is clicked.");
        adminCoupon.couponButton.click();
        extentTest.info("the coupon sorted by name");
        adminCoupon.sortName();
        extentTest.pass("All coupon were sorted");
        Driver.closeDriver();
    }

    @Test(priority = 25)
    public void TC_04004_CouponkullanılmaSayısınaGoreList() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        extentTest = extentReports.createTest("test04004", "All products should be sorted by number of coupons used ");
        adminPage.adminLoginOl();
        extentTest.info("promo button is clicked.");
        adminCoupon.promoButton.click();
        extentTest.info("coupon button is clicked.");
        adminCoupon.couponButton.click();
        extentTest.info("the coupon sorted by number of used");
        adminCoupon.usedCoupon();
        Driver.closeDriver();


    }

    @Test(priority = 30)
    public void TC_04005_searchBox() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        extentTest = extentReports.createTest("test04005", "searchbox button should be visible,enable");
        adminPage.adminLoginOl();
        extentTest.info("promo button is clicked.");
        adminCoupon.promoButton.click();
        extentTest.info("coupon button is clicked.");
        adminCoupon.couponButton.click();
        extentTest.info("searchbox button is clicked.");
        adminCoupon.searchbox.click();
        extentTest.info("searchbox button is visible.");
        softAssert.assertTrue(adminCoupon.searchbox.isDisplayed());
        extentTest.info("searchbox button isn't enabled");
        softAssert.assertFalse(adminCoupon.searchbox.isEnabled());
        Driver.closeDriver();
    }
}
