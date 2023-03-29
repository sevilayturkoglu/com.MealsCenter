package tests.US_002_018_030;

import org.testng.annotations.Test;
import pages.AdminCouponPage;
import pages.AdminPage;
import utilities.TestBaseReport;

public class US_040_CouponOlusturma extends TestBaseReport {
    AdminPage adminPage= new AdminPage();
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
