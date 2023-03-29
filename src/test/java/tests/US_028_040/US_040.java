package tests.US_028_040;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminCouponPage;
import pages.AdminCoupon_List_Delete_UpdatePage;
import pages.AdminLoginPage;
import pages.AdminSearchPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_040 extends TestBaseReport {
    AdminLoginPage adminPage=new AdminLoginPage();
    AdminCouponPage adminCouponPage=new AdminCouponPage();

    @Test
    public void test4001() {
        adminPage.adminLoginOl();
        adminCouponPage = new AdminCouponPage();
        adminCouponPage.promoButton.click();
        adminCouponPage.couponButton.click();
        adminCouponPage.couponMake("NewCoupons20");
    }
    SoftAssert softAssert = new SoftAssert();
    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminCoupon_List_Delete_UpdatePage adminCoupon_List_Delete_UpdatePage = new AdminCoupon_List_Delete_UpdatePage();

    @Test(priority = 5)
    public void test4001_kuponOlusturma() {
        adminLoginPage = new AdminLoginPage();
        adminCoupon_List_Delete_UpdatePage = new AdminCoupon_List_Delete_UpdatePage();
        adminLoginPage.adminLoginOl();
        adminCoupon_List_Delete_UpdatePage.promoButton.click();
        adminCoupon_List_Delete_UpdatePage.couponButton.click();
        //kupon olusturdum
        adminCoupon_List_Delete_UpdatePage.couponMake("ikinciCoupons");
        //testim sonradan saglikli calissin diye kuponu sildim,cunki tekrar ayni isimli kupon olusturmama izin vermiyor
        adminCoupon_List_Delete_UpdatePage.couponDelete();
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 10)
    public void test4003kuponSilme() {
        adminLoginPage = new AdminLoginPage();
        adminCoupon_List_Delete_UpdatePage = new AdminCoupon_List_Delete_UpdatePage();
        adminLoginPage.adminLoginOl();
        adminCoupon_List_Delete_UpdatePage.promoButton.click();
        adminCoupon_List_Delete_UpdatePage.couponButton.click();
        //silebildigimi gostermek icin kupon olusturdum
        adminCoupon_List_Delete_UpdatePage.couponMake("SilmeCouponu");
        String enteryCountBeforeDelete = adminCoupon_List_Delete_UpdatePage.enteryCount.getText();
        ReusableMethods.bekle(1);
        //kuponu sildim
        adminCoupon_List_Delete_UpdatePage.couponDelete();
        String enteryCountAfterDelete = adminCoupon_List_Delete_UpdatePage.enteryCount.getText();
        //kuponu sildigimi dogruladim
        softAssert.assertNotEquals(enteryCountAfterDelete, enteryCountBeforeDelete);
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 15)
    public void test4002upDate() {
        adminLoginPage = new AdminLoginPage();
        adminCoupon_List_Delete_UpdatePage = new AdminCoupon_List_Delete_UpdatePage();
        adminLoginPage.adminLoginOl();
        adminCoupon_List_Delete_UpdatePage.promoButton.click();
        adminCoupon_List_Delete_UpdatePage.couponButton.click();
        //update edebilmek icin kupon yaptim
        adminCoupon_List_Delete_UpdatePage.couponMake("UpdateEdilecekCoupons");
        // yaptigimiz kuponun adini update ettim,update ettigimi dogruladim
        adminCoupon_List_Delete_UpdatePage.updateCoupon();
        //testim sonradan saglikli calissin diye kuponu sildim
        adminCoupon_List_Delete_UpdatePage. couponDelete();
        Driver.closeDriver();
    }
    @Test(priority = 20)
    public void test4004isimSirasinaGoreCouponList() {
        adminLoginPage = new AdminLoginPage();
        adminCoupon_List_Delete_UpdatePage = new AdminCoupon_List_Delete_UpdatePage();
        adminLoginPage.adminLoginOl();
        adminCoupon_List_Delete_UpdatePage.promoButton.click();
        adminCoupon_List_Delete_UpdatePage.couponButton.click();
        adminCoupon_List_Delete_UpdatePage.sortName();
        Driver.closeDriver();
    }
    @Test(priority = 25)
    public void test4004CouponkullanılmaSayısınaGoreList() {
        adminLoginPage = new AdminLoginPage();
        adminCoupon_List_Delete_UpdatePage = new AdminCoupon_List_Delete_UpdatePage();
        adminLoginPage.adminLoginOl();
        adminCoupon_List_Delete_UpdatePage.promoButton.click();
        adminCoupon_List_Delete_UpdatePage.couponButton.click();
        adminCoupon_List_Delete_UpdatePage.usedCoupon();
    }
    AdminSearchPage adminSearchPage = new AdminSearchPage();
    @Test()
    public void test4005searchBox() {
        adminLoginPage = new AdminLoginPage();
        adminSearchPage = new AdminSearchPage();
        adminLoginPage.adminLoginOl();
        adminSearchPage.promoButton.click();
        adminSearchPage.couponButton.click();
        adminSearchPage.searchbox.click();
        softAssert.assertTrue(adminSearchPage.searchbox.isDisplayed());
        softAssert.assertFalse(adminSearchPage.searchbox.isEnabled());
        Driver.closeDriver();
    }

}
