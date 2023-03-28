package tests.US_002_018_030;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;


public class US_002_UserHomeHeadersTest extends TestBaseReport {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 5)
    public void mealsLogoSignInTest() {
        userPage = new UserPage();
        extentTest=extentReports.createTest("Headers basliklari kontrol","MealsLogo ve SignIn basliklar gorulebilir ve click yapilabilir");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Browser baslatildi MealsCenter urlye gidildi");
        ReusableMethods.bekle(3);
        userPage.userCookies.click();
        extentTest.info("Cookies reddedildi");
        softAssert.assertTrue(userPage.userLogo.isDisplayed());
        extentTest.info("Meals logo goruldu");
        softAssert.assertTrue(userPage.userLogo.isEnabled());
        extentTest.info("Meals logonun islevsel oldugu test edildi");
        softAssert.assertTrue(userPage.userSignIn.isDisplayed());
        extentTest.info("SignIn butonu goruldu");
        userPage.userSignIn.click();
        extentTest.info("Sign in buton clicklendi");
        String actualLoginText = userPage.userLoginText.getText();
        extentTest.info("Sign in button tiklaninca gidilen sayfanin verify edilmesi icin texti alindi");
        String expectedLoginText = "Login";
        softAssert.assertEquals(actualLoginText, expectedLoginText);
        extentTest.info("Olmasi gereken text ile actual text karsilastirildi");
        extentTest.info("Driver kapatildi");
        extentTest.pass("Meals logo ve sign In goruldu islevsel olduklari dogrulandi");
        softAssert.assertAll();

    }

    @Test(priority = 10)
    public void BeforeOrderCartBagTest() {
        userPage = new UserPage();
        extentTest=extentReports.createTest("Headers basliklari kontrol","Header Cart ve Bag basliklar gorulebilir ve click yapilabilir");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Browser baslatildi MealsCenter urlye gidildi");
        ReusableMethods.bekle(3);
        userPage.userCookies.click();
        extentTest.info("Cookies reddedildi");
        softAssert.assertTrue(userPage.userCartButton.isDisplayed());
        extentTest.info("Cart butonu goruldu");
        userPage.userCartButton.click();
        extentTest.info("Cart butonu clicklendi");
        String actualCartText = userPage.userCartText.getText();
        extentTest.info("Cart butonun islevselliginin verify edilmesi icin texti alindi");
        String excpectedCartText = "Cart";
        ReusableMethods.bekle(1);
        softAssert.assertEquals(actualCartText, excpectedCartText);
        extentTest.info("Olmasi gereken text ile actual text karsilastirildi");
        ReusableMethods.bekle(1);
        userPage.userHeadersClosex.click();
         extentTest.info("Cart bolumu acilan not kapatildi");
        ReusableMethods.bekle(1);
        softAssert.assertTrue(userPage.userBagButton.isDisplayed());
        extentTest.info("Bag logo butonu goruldu");
        userPage.userBagButton.click();
        extentTest.info("Bag butonu clicklendi");
        ReusableMethods.bekle(1);
        String actualBagText = userPage.userBagText.getText();
        extentTest.info("Cart butonun islevselliginin verify edilmesi icin texti alindi");
        String expectedBagText = "You don't have any orders here!\n" +
                "let's change that!";
        ReusableMethods.bekle(2);
        softAssert.assertEquals(actualBagText, expectedBagText);
        extentTest.info("Olmasi gereken text ile actual text karsilastirildi");
        userPage.userHeadersClosex.click();
        extentTest.info("Bag bolumu acilan not kapatildi");
        extentTest.info("Driver kapatildi");
        extentTest.pass("Cart ve Bag goruldu islevsel olduklari dogrulandi");
        softAssert.assertAll();

    }

    @Test(priority = 15)
    public void AfterOrderCartBagTest() {

        userPage = new UserPage();
        extentTest=extentReports.createTest("Headers basliklari kontrol","Header Cart ve Bag order sonrasi degisiklikler,");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Browser baslatildi MealsCenter urlye gidildi");
        ReusableMethods.bekle(3);
        userPage.userCookies.click();
        extentTest.info("Cookies reddedildi");
        userPage.userAdresBox.sendKeys("100000");
        extentTest.info("Adres kutusuna adres girildi");
        ReusableMethods.waitForVisibility(userPage.userChooseAddres, 10);
        userPage.userChooseAddres.click();
        extentTest.info("Adres kutusunda gorulen adres secildi");
        userPage.eleven7.click();
        extentTest.info("Siparis verilecek restaurant isaretlendi");
        String eleven7Text = userPage.eleven7.getText();
        userPage.addToCard.click();
        extentTest.info("Siparis verildi");
        userPage.userLogo.click();
        userPage.userCartButton.click();
        extentTest.info("Cart tiklandi");
        String actualCartText = userPage.userBagChecOutText.getText();
        extentTest.info("Siparisin burada goruldugunu test etmek icin text alindi");
        String excpectedCartText = "Go to checkout";
        ReusableMethods.bekle(1);
        softAssert.assertEquals(actualCartText, excpectedCartText);
        extentTest.info("Siparisin burada goruldugu dogrulandi");
        userPage.userHeadersClosex.click();
        extentTest.info("Cart bolumu kapatildi");
        ReusableMethods.bekle(1);
        userPage.userBagButton.click();
        extentTest.info("Bag butonu clicklendi");
        ReusableMethods.bekle(1);
        String actualBagText = userPage.userBagChecOutText.getText();
        extentTest.info("Siparisin burada goruldugunu test etmek icin text alindi");
        String excpectedBagText = "Go to checkout";
        ReusableMethods.bekle(1);
        softAssert.assertEquals(actualBagText, excpectedBagText);
        extentTest.info("Siparisin burada goruldugu dogrulandi");
        userPage.userHeadersClosex.click();
        extentTest.info("Bag bolumu kapatildi");
        extentTest.info("Driver kapatildi");
        extentTest.pass("Cart ve Bag goruldu islevsel olduklari dogrulandi");
        softAssert.assertAll();

    }
}