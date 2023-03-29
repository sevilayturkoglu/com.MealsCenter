package tests.US_002_018_030;

import org.testng.annotations.Test;
import pages.AdminCouponPage;
import pages.AdminLoginPage;
import utilities.TestBaseReport;

public class US_040_CouponOlusturma extends TestBaseReport {
    AdminLoginPage adminPage= new AdminLoginPage();
    AdminCouponPage adminCouponPage=new AdminCouponPage();

    @Test
    public void kuponOlusturmatest1(){
        adminPage.adminLoginOl();
        adminCouponPage =new AdminCouponPage();
        adminCouponPage.promoButton.click();
        adminCouponPage.couponButton.click();
        adminCouponPage.couponMake("NewCoupons2");


    }

}
