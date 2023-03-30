package tests.US_028_040;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_040 extends TestBaseReport {
    /*
    Admin olarak Kupon oluşturabilmeli,
     listeleyebilmeli, update edebilmeli ve silebilmeliyim.
      Kupon listesini isme ve kullanılma sayısına göre listeleyebilmeliyim.
       Kuponlar arasında arama da yapabilmeliyim
     */
    SoftAssert softAssert = new SoftAssert();
    AdminPage adminPage = new AdminPage();
    AdminCoupon adminCoupon = new AdminCoupon();

    @Test(priority = 5)
    public void TC04001_kuponOlusturma() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        adminPage.adminLoginOl();
        adminCoupon.promoButton.click();
        adminCoupon.couponButton.click();
        //kupon olusturdum
        adminCoupon.couponMake("ikinciCoupons");
        //testim sonradan saglikli calissin diye kuponu sildim,cunki tekrar ayni isimli kupon olusturmama izin vermiyor
        adminCoupon.couponDelete();
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 10)
    public void TC04002_kuponSilme() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        adminPage.adminLoginOl();
        adminCoupon.promoButton.click();
        adminCoupon.couponButton.click();
        //silebildigimi gostermek icin kupon olusturdum
        adminCoupon.couponMake("SilmeCouponu");
        String enteryCountBeforeDelete = adminCoupon.enteryCount.getText();
        ReusableMethods.bekle(1);
        //kuponu sildim
        adminCoupon.couponDelete();
        String enteryCountAfterDelete = adminCoupon.enteryCount.getText();
        //kuponu sildigimi dogruladim
        softAssert.assertNotEquals(enteryCountAfterDelete, enteryCountBeforeDelete);
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 15)
    public void TC04003_upDate() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        adminPage.adminLoginOl();
        adminCoupon.promoButton.click();
        adminCoupon.couponButton.click();
        //update edebilmek icin kupon yaptim
        adminCoupon.couponMake("UpdateEdilecekCoupons");
        // yaptigimiz kuponun adini update ettim,update ettigimi dogruladim
        adminCoupon.updateCoupon();
        //testim sonradan saglikli calissin diye kuponu sildim
        adminCoupon. couponDelete();
        Driver.closeDriver();
    }
    @Test(priority = 20)
    public void TC04004_isimSirasinaGoreCouponList() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        adminPage.adminLoginOl();
        adminCoupon.promoButton.click();
        adminCoupon.couponButton.click();
        adminCoupon.sortName();
        Driver.closeDriver();
    }
    @Test(priority = 25)
    public void TC04004_CouponkullanılmaSayısınaGoreList() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        adminPage.adminLoginOl();
        adminCoupon.promoButton.click();
        adminCoupon.couponButton.click();
        adminCoupon.usedCoupon();
    }
    @Test(priority=30)
    public void TC04004_searchBox() {
        adminPage = new AdminPage();
        adminCoupon = new AdminCoupon();
        adminPage.adminLoginOl();
        adminCoupon.promoButton.click();
        adminCoupon.couponButton.click();
        adminCoupon.searchbox.click();
        softAssert.assertTrue(adminCoupon.searchbox.isDisplayed());
        softAssert.assertFalse(adminCoupon.searchbox.isEnabled());
        Driver.closeDriver();
    }
}
