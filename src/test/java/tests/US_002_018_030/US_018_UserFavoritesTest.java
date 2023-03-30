package tests.US_002_018_030;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.time.Duration;

public class US_018_UserFavoritesTest extends TestBaseReport {

    UserPage userPage = new UserPage();

    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 5)
    public void TC_01801_favoriteRestaurantMake() {

        userPage = new UserPage();
        extentTest = extentReports.createTest("Favori restaurant ekleme", "Favori sayfama restaurant ekleme");
        ReusableMethods.bekle(1);
        userPage.userLoginBeing();
        extentTest.info("Browseri baslatildi ,MealsCenter Url ye gidildi,login olundu ");
        ReusableMethods.bekle(1);
        userPage.userLogo.click();
        userPage.UserChoseCuisineMore("American");
        extentTest.info("Favorilere eklenmek uzere Amerikan cuisine gidildi");
        ReusableMethods.bekle(1);
        userPage.favouriteTikStarBox.click();
        extentTest.info("Favori olarak bir restaurant eklendi");
        ReusableMethods.bekle(2);
        userPage.favouriteTikBurgerBox.click();
        extentTest.info("Favori sayfama bir restaurant daha eklendi");
        ReusableMethods.bekle(2);
        extentTest.info("Sayfami kapattim");
        extentTest.pass("Favorim olmasi istenilen restaurantlar eklnedi");


    }

    @Test(priority = 15)
    public void TC_01802_checkYourFavoriteRestaurants() {

        userPage = new UserPage();
        extentTest = extentReports.createTest("Favori restaurant gorme", "Favori sayfama ekledigim restaurantlari gorebilirim");
        ReusableMethods.bekle(1);
        userPage.userLoginBeing();
        extentTest.info("Browseri baslatildi ,MealsCenter Url ye gidildi,login olundu ");
        ReusableMethods.bekle(1);
        userPage.userUstDDMenu("Saved Stores", "favourites");
        extentTest.info("Account bolumunden Saved story kismina gidildi,bu adrese gidildigi dogrulandi");
        ReusableMethods.bekle(2);
        softAssert.assertTrue(userPage.favouriteBurgerKing.isDisplayed());
        extentTest.info("Daha once secilen restaurantin sayfada oldugu verify edildi");
        ReusableMethods.bekle(1);
        softAssert.assertTrue(userPage.favouriteStarbucks.isDisplayed());
        extentTest.info("Daha once secilen diger restaurantin sayfada oldugunu verifay edildi");
        extentTest.info("Driver kapatildi");
        extentTest.pass("Favori olmasi istenilen restaurantlar sayfada goruldu");
        softAssert.assertAll();

    }

    @Test(priority = 25)
    public void TC_01803_eraseYourFavoriteRestaurant() {

        userPage = new UserPage();
        extentTest = extentReports.createTest("Favori restaurant silme", "Favori sayfamadan restaurant kaldirma ");
        ReusableMethods.bekle(1);
        userPage.userLoginBeing();
        extentTest.info("Browseri baslatildi ,MealsCenter Url ye gidildi,login olundu ");
        ReusableMethods.bekle(1);
        userPage.userUstDDMenu("Saved Stores", "favourites");
        extentTest.info("Account bolumunden Saved story kismina gidildi,bu adrese gidildigi dogrulandi");
        ReusableMethods.bekle(2);
        userPage.inFavouriteTikBox1.click();
        extentTest.info("Artik favorim olmasini istenilmeyen restaurant tiklandi");
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().refresh();
        extentTest.info("Durum degisikligini gormek icin sayfa yenilendi");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        softAssert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(userPage.favouriteBurgerKing)));
        extentTest.info("Favorimden kaldirilan restaurantin gorunup gorunmedigini verify edildi");
        ReusableMethods.bekle(2);
        userPage.inFavouriteTikBox1.click();
        extentTest.info("Daha sonraki test calismalarin etkilenmemesi icin kalan favori restaurant silindi");
        ReusableMethods.bekle(2);
        extentTest.info("Driveri kapatildi");
        extentTest.pass("Favorim olmasini istenmeyen restaurantlar silindi");
        softAssert.assertAll();

    }

}


