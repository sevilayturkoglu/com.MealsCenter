package tests.US_002_018_030;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_018_UserFavoritesTest {

    UserPage userPage = new UserPage();

    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 5)
    public void favoriteRestaurantMake() {

        userPage = new UserPage();

        ReusableMethods.bekle(1);
        userPage.userLoginBeing();
        ReusableMethods.bekle(1);
        userPage.userLogo.click();
        userPage.UserChoseCuisineMore("American");
        ReusableMethods.bekle(1);
        userPage.favouriteTikStarBox.click();
        ReusableMethods.bekle(2);
        userPage.favouriteTikBurgerBox.click();
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }

    @Test(priority = 15)
    public void checkYourFavoriteRestaurants() {

        userPage = new UserPage();

        ReusableMethods.bekle(1);
        userPage.userLoginBeing();
        ReusableMethods.bekle(1);
        userPage.userUstDDMenu("Saved Stores", "favourites");
        ReusableMethods.bekle(2);
        softAssert.assertTrue(userPage.favouriteBurgerKing.isDisplayed());
        ReusableMethods.bekle(1);
        softAssert.assertTrue(userPage.favouriteStarbucks.isDisplayed());
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(priority = 25)
    public void eraseYourFavoriteRestaurant() {

        userPage = new UserPage();

        ReusableMethods.bekle(1);
        userPage.userLoginBeing();
        ReusableMethods.bekle(1);
        userPage.userUstDDMenu("Saved Stores", "favourites");
        ReusableMethods.bekle(2);
        userPage.inFavouriteTikBox1.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().refresh();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        softAssert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(userPage.favouriteBurgerKing)));
        ReusableMethods.bekle(2);
        userPage.inFavouriteTikBox1.click();
        ReusableMethods.bekle(2);
        softAssert.assertAll();
        Driver.closeDriver();
    }


}




